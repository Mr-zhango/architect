
package cn.myfreecloud.lock;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

public class ZookeeperDistrbuteLock extends ZookeeperAbstractLock {
    private CountDownLatch countDownLatch = null;

    /**
     * @return
     */
    @Override
    public boolean tryLock() {
        try {
            // 创建临时节点
            zkClient.createEphemeral(PATH);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public void waitLock() {

        // zk节点被删除的时候的事件通知
        IZkDataListener iZkDataListener = new IZkDataListener() {

            public void handleDataDeleted(String dataPath) {
                // 唤醒被等待的线程
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }

            public void handleDataChange(String dataPath, Object data) {

            }
        };

        // 注册到zookeeper集群进行监听
        zkClient.subscribeDataChanges(PATH, iZkDataListener);

        // 节点存在
        if (zkClient.exists(PATH)) {
            // 创建信号量
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (Exception e) {

            }
        }

        // 解除监听
        zkClient.unsubscribeDataChanges(PATH, iZkDataListener);

    }

}

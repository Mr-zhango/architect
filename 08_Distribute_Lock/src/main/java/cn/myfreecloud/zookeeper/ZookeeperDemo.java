
package cn.myfreecloud.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Desc: 功能描述:(zookDemo)
 */
public class ZookeeperDemo implements Watcher {

    /**
     * 集群地址
     */
    private static final String CONNECT_ADDRES = "192.168.1.20:2181,192.168.1.21:2181,192.168.1.22:2181";
    /**
     * 超时时间
     */
    private static final int SESSIONTIME = 2000;
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zk;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zk = new ZooKeeper(CONNECT_ADDRES, SESSIONTIME, new Watcher() {

            public void process(WatchedEvent watchedEvent) {
                // 获取事件状态
                KeeperState keeperState = watchedEvent.getState();
                // 获取事件类型
                EventType eventType = watchedEvent.getType();
                // 判断是否建立连接
                if (KeeperState.SyncConnected == keeperState) {
                    if (EventType.None == eventType) {
                        // 如果建立建立成功,让后程序往下走
                        System.out.println("zk 建立连接成功!");
                        countDownLatch.countDown();
                    }
                }
            }
        });
        // 阻塞
        countDownLatch.await();
        // 创建一个父节点
        System.out.println("开始创建一个父节点...");
        zk.create("/pa2", "123456".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        // String result = zk.create("/pa2", "123456".getBytes(),
        // Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        // System.out.println("resut:" + result);
        // Thread.sleep(5000);
        // String result = new String(zk.getData("/pa2", false, null));
        // System.out.println("result:" + result);
        zk.close();
    }

    public void process(WatchedEvent event) {
        System.out.println("进入 process ....... event =" + event);
        if (event == null) {
            return;
        }
        //当前path
        String path = event.getPath();
        // 获取事件状态
        KeeperState keeperState = event.getState();
        // 获取事件类型
        EventType eventType = event.getType();
        // 判断是否建立连接
        if (KeeperState.SyncConnected == keeperState) {
            if (EventType.None == eventType) {
                // 如果建立建立成功,让后程序往下走
                System.out.println("zk 建立连接成功!");
                // 放行
                countDownLatch.countDown();
                //创建节点事件
            } else if (EventType.NodeCreated == eventType) {
                try {

                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

        }

    }
}


package cn.myfreecloud.lock;

import org.I0Itec.zkclient.ZkClient;

/**
 * 将重复的代码进行抽取,具体业务由子类进行实现
 */
public abstract class ZookeeperAbstractLock implements Lock {

    // 集群地址
    protected static final String CONNECT_ADDRES = "192.168.1.20:2181,192.168.1.21:2181,192.168.1.22:2181";

    //
    protected static final int SESSIONTIME = 2000;

    // 临时阶段名称
    protected static final String PATH = "/lock";

    protected ZkClient zkClient = new ZkClient(CONNECT_ADDRES);

    // 获取锁
    public void getLock() {
        // 创建zookeeper临时节点,如果创建成功返回true,否则返回false
        if (tryLock()) {
            //  获取
            System.out.println(Thread.currentThread().getName() + "获取到锁的资源");
        } else {
            // 等待
            waitLock();
            // 重新获取锁的资源
            getLock();
        }
    }


    protected abstract boolean tryLock();

    protected abstract void waitLock();

    // 释放锁
    public void unLock() {
        try {
            if (zkClient != null)
                zkClient.close();
            System.out.println("释放锁的资源...");
        } catch (Exception e) {

        }
    }

}

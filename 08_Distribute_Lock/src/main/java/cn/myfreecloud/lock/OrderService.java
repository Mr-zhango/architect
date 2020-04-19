
package cn.myfreecloud.lock;

public class OrderService implements Runnable {

    private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();

    private Lock lock = new ZookeeperDistrbuteLock();

    public void run() {
        getOrderNumber();
    }

    // 获取订单编号方法
    public  void getOrderNumber() {

        try {

               // 加锁
                lock.getLock();
                //Thread.sleep(1);
                String orderNum = orderNumGenerator.orderNum();

                System.out.println("线程名称" + Thread.currentThread().getName() + "获取生成的订单号为:" + orderNum);
                // 解锁
                lock.unLock();

        } catch (Exception e) {


        }


    }

    public static void main(String[] args) {
        System.out.println("程序启动");
    	// 创建100个线程模拟高并发的场景
        for (int i = 0; i < 100; i++) {
            new Thread(new OrderService()).start();
        }

        // 找出来是否有重复的

    }

}

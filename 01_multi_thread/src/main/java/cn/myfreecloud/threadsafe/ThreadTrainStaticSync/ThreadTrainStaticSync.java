package cn.myfreecloud.threadsafe.ThreadTrainStaticSync;


/**
 * @classDesc: 功能描述:(多线程之买火车票案例-展示线程不安全问题)
 * 代码正门 synchronized 的同步方法使用的是 同步代码块(this)的形式
 */
class ThreadTrainStaticSyncThread implements Runnable {
    // 这是货票总票数,多个线程会同时共享资源
    private static int trainCount = 100;

    // 同一个变量
    private Object object = new Object();

    public boolean flag = true;

    @Override
    public void run() {
        // 线程1 flag = true
        if (flag) {
            while (trainCount > 0) {

                // synchronized (object) { 不能保证线程安全
                synchronized (ThreadTrainStaticSyncThread.class) {   // 能够保证线程安全
                    if (trainCount > 0) {
                        try {
                            Thread.sleep(40);
                        } catch (Exception e) {
                        }
                        System.out.println(Thread.currentThread().getName() + ",出售 第" + (100 - trainCount + 1) + "张票.");
                        // 票数-1
                        trainCount--;
                    }

                }
            }

        } else {
            // 线程1 flag = false
            while (trainCount > 0) {
                show();
            }
        }


    }

    /**
     * @methodDesc: 功能描述:(出售火车票)
     * 证明静态的同步方法 使用的不是this锁 使用的是 类名.class作为锁
     */
    public static synchronized void show() {
        if(trainCount >0){
            try {
                Thread.sleep(40);
            } catch (Exception e) {
            }
            System.out.println(Thread.currentThread().getName() + ",出售 第" + (100 - trainCount + 1) + "张票.");
            trainCount--;
        }

    }
}

public class ThreadTrainStaticSync {

    public static void main(String[] args) throws InterruptedException {

        // 线程类一定要是一个实例(贡献同一个线程变量)
        // 定义 一个实例
        ThreadTrainStaticSyncThread threadTrain = new ThreadTrainStaticSyncThread();

        Thread thread1 = new Thread(threadTrain, "一号窗口");
        Thread thread2 = new Thread(threadTrain, "二号窗口");


        thread1.start();
        Thread.sleep(400);
        threadTrain.flag = false;


        thread2.start();
    }

}
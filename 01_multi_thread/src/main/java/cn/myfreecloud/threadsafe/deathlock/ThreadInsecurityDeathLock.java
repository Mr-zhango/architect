package cn.myfreecloud.threadsafe.deathlock;

/**
 * @classDesc: 功能描述:(多线程之买火车票案例-展示线程不安全问题)
 * 代码正门 synchronized 的同步方法使用的是 同步代码块(this)的形式
 */
class ThreadTrainDeathLock implements Runnable {
    // 这是货票总票数,多个线程会同时共享资源
    private int trainCount = 100;

    // 同一个变量
    private Object object = new Object();

    public boolean flag = true;

    @Override
    public void run() {
        // 线程1 flag = true
        if (flag) {
            while (trainCount > 0) {

                synchronized (object) {
                    show();
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
     */
    public synchronized void show() {

        // 同步里面嵌套同步,造成死锁
        synchronized(object){
            if (trainCount > 0) {
                try {
                    Thread.sleep(40);
                } catch (Exception e) {
                }
                System.out.println(Thread.currentThread().getName() + ",出售 第" + (100 - trainCount + 1) + "张票.");
                trainCount--;
            }

        }

    }
}

public class ThreadInsecurityDeathLock {

    public static void main(String[] args) throws InterruptedException {

        // 线程类一定要是一个实例(贡献同一个线程变量)
        // 定义 一个实例
        ThreadTrainDeathLock threadTrain = new ThreadTrainDeathLock();

        Thread thread1 = new Thread(threadTrain, "一号窗口");
        Thread thread2 = new Thread(threadTrain, "二号窗口");


        thread1.start();
        Thread.sleep(400);
        threadTrain.flag = false;


        thread2.start();
    }

}
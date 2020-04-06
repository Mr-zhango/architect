package cn.myfreecloud.threadsafe;

/**
 * @classDesc: 功能描述:(多线程之买火车票案例-展示线程不安全问题)
 * <p>
 * 解决线程不安全问题的方法
 * 1:使用同步代码块
 * 2:使用同步方法
 */
class ThreadTrain implements Runnable {
    // 这是货票总票数,多个线程会同时共享资源
    private int trainCount = 100;
    // 同一个变量
    private Object object = new Object();

    @Override
    public void run() {
        // 不能包裹整个run()否则会导致整个程序编程单线程程序,因为锁一直没有释放
        //  synchronized (object) {
        //  }
        while (trainCount > 0) {// 循环是指线程不停的去卖票

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println(this.getClass().getName() + e.getMessage());
            }

            /**
             * 使用synchronized包裹起来的代码,每次只能让当前一个线程进行执行
             */
            synchronized (object) {
                if (trainCount > 0) {
                    System.out.println(Thread.currentThread().getName() + ",出售 第" + (100 - trainCount + 1) + "张票.");
                    // 票数-1
                    trainCount--;
                }
            }
        }
    }

}

public class ThreadInsecuritySolution {

    public static void main(String[] args) {

        // 线程类一定要是一个实例(贡献同一个线程变量)
        // 定义 一个实例
        ThreadTrain threadTrain = new ThreadTrain();

        Thread thread1 = new Thread(threadTrain, "一号窗口");
        Thread thread2 = new Thread(threadTrain, "二号窗口");

        thread1.start();
        thread2.start();
    }

}
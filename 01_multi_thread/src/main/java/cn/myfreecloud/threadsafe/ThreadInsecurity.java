package cn.myfreecloud.threadsafe;

/**
 * @classDesc: 功能描述:(多线程之买火车票案例-展示线程不安全问题)
 * 暴露线程不安全问题
 */
class ThreadTrainProblem implements Runnable {
    // 这是货票总票数,多个线程会同时共享资源
    private int trainCount = 100;

    @Override
    public void run() {
        while (trainCount > 0) {// 循环是指线程不停的去卖票
            show();
        }
    }

    /**
     * @methodDesc: 功能描述:(出售火车票)
     */
    public void show() {
        if (trainCount > 0) {

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println(this.getClass().getName() + e.getMessage());
            }

            System.out.println(Thread.currentThread().getName() + ",出售 第" + (100 - trainCount + 1) + "张票.");

            // 票数-1
            trainCount--;
        }
    }
}

public class ThreadInsecurity {

    public static void main(String[] args) {

    	// 线程类一定要是一个实例(贡献同一个线程变量)
		// 定义 一个实例
        ThreadTrainProblem threadTrain = new ThreadTrainProblem();

        Thread thread1 = new Thread(threadTrain, "一号窗口");
        Thread thread2 = new Thread(threadTrain, "二号窗口");

        thread1.start();
        thread2.start();
    }

}
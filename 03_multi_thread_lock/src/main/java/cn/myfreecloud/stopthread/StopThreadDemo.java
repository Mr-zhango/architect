package cn.myfreecloud.stopthread;

class StopThread extends Thread {

    // flag true 线程处于运行状态, false 停止线程
    public boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
               stopThreadMethod();
            }
            System.out.println(Thread.currentThread().getName() + "我是子线程");
        }
    }

    public void stopThreadMethod() {
        flag = false;
        System.out.println(getName()+"线程被停止掉了...");

    }
}


/**
 * @author: zhangyang
 * @description: 停止线程测试类
 */
public class StopThreadDemo {
    public static void main(String[] args) {
        StopThread stopThread1 = new StopThread();
        StopThread stopThread2 = new StopThread();

        stopThread1.start();
        stopThread2.start();

        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(i == 29){
                // 停止线程的方法
                stopThread1.interrupt();
                stopThread2.interrupt();
            }

            System.out.println("main ... " + i);
        }


    }

}

package cn.myfreecloud.method;

class CreatThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("run() i:" + i);
        }
    }
}


/**
 * 创建多线程
 * 1.继承Thread类,重写run方法
 */
public class ThreadDemo01 {
    public static void main(String[] args) {

        System.out.println("创建线程开始 main");

        // 1.定义一个类，继承Thread类，重写run方法


        CreatThread creatThread = new CreatThread();

        // 启动线程,注意：启动一个线程使用的是start方法，不是run()方法，调用run()方法相当于主线程执行。

        creatThread.start();

        System.out.println("创建已经开始启动 main");

        for (int i = 0; i < 1000; i++) {
            System.out.println("main() i:" + i);
        }
    }
}




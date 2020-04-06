package cn.myfreecloud.method;

/**
 * 使用匿名内部类的方式来启动多个线程
 */
public class ThreadDemo03 {
    public static void main(String[] args) {

        System.out.println("创建线程开始!main");

        // 使用匿名内部类的方式来创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++) {
                    System.out.println("run() i:" + i);
                }

            }
        }).start();

        System.out.println("创建线程结束!main");

        for (int i = 0; i < 1000; i++) {
            System.out.println("main() i:" + i);
        }

    }
}

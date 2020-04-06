package cn.myfreecloud.method;

/**
 * 多线程的第二种方式
 * 实现Runnable接口,重写run方法
 */
class CreatRunnable implements Runnable {

    /**
     * run()方法也是 执行线程需要执行的方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("run() i:" + i);
        }
    }
}

public class ThreadDemo02 {
    public static void main(String[] args) {

        System.out.println("创建线程开始!main");
        CreatRunnable creatRunnable = new CreatRunnable();

        Thread thread = new Thread(creatRunnable);
        thread.start();

        System.out.println("线程已经启动!main");
        for (int i = 0; i < 1000; i++) {
            System.out.println("main() i:" + i);
        }
    }

}
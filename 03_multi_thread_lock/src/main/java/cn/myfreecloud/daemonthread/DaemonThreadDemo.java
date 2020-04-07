package cn.myfreecloud.daemonthread;

/**
 * @author: zhangyang
 * @date: 2020/4/6 17:36
 * @description: 守护线程 Daemon
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {


        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我是子线程,i:" + i);
                }
            }
        });

        // 把线程设置为守护进程,主线程只要一停,这个守护线程也要停止.
        thread.setDaemon(true);

        thread.start();


        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("我是主线程,i:" + i);

        }
        System.out.println("主线程执行完毕~");

    }
}

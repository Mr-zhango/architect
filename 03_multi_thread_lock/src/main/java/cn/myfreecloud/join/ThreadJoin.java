package cn.myfreecloud.join;

/**
 * @author: zhangyang
 * @date: 2020/4/6 18:31
 * @description: 线程操作中join方法的使用
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        ThreadJoinThread t1 = new ThreadJoinThread();


        ThreadJoinThread t2 = new ThreadJoinThread();


        t1.start();

        // 让其他线程等待,只有当前线程执行完毕,才会释放资源
        t1.join();

        t2.start();

        for (int i = 0; i < 40; i++) {
            System.out.println("main:" + i);
        }

    }
}


class ThreadJoinThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 40; i++) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "----" + i);
        }

    }
}

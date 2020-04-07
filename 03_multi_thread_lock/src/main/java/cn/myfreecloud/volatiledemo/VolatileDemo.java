package cn.myfreecloud.volatiledemo;

/**
 * @author: zhangyang
 * @date: 2020/4/7 15:25
 * @description: Volatile关键字讲解
 */
public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {

        ThreadVolatileDemo t1 = new ThreadVolatileDemo();
        t1.start();

        // 停止线程
        Thread.sleep(300);
        // 此时线程不会停止,因为 主内存中共享变量的改变对 本地内存中的变量不可见
        t1.isRun(false);

        System.out.println("flag:"+t1.flag);

    }
}

class ThreadVolatileDemo extends Thread{

    // 没加内存可见关键字之前,本地变量修改对其他线程的本地内存你不可见
    //public boolean flag = true;
    public volatile boolean flag = true;

    @Override
    public void run() {

        System.out.println("子线程开始执行...");

        while (flag){

        }

        System.out.println("子线程结束执行...");
    }


    public void isRun(boolean flag){
        this.flag = flag;
    }
}

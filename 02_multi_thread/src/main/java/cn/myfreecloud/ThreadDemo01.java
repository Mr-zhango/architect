package cn.myfreecloud;

/**
 * 共享资源类
 */
class Res {
    public String name;
    public String sex;
    // flag 为 true的话,out线程才能去获取值
    public boolean flag = false;
}

/**
 * 写线程
 */
class InputThread extends Thread {

    public Res res;

    public InputThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {

        int count = 0;
        while (true) {
            synchronized (res) {
                if(res.flag){
                    try {
                        // 目前处于读逻辑,线程等待 wait()方法可以让当前线程 从运行状态 变为 休眠状态 wait()使用在多线程直接同步,能够释放锁,不妨碍其他线程的任务执行.
                        // sleep()不释放锁.
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count == 0) {
                    // 偶数
                    res.name = "小明";
                    res.sex = "男";
                } else {
                    // 奇数
                    res.name = "小红";
                    res.sex = "女";
                }
                // 实现奇偶互换
                count = (count + 1) % 2;
                res.flag = true;
                res.notify();
            }
        }


    }
}

/**
 * 读线程
 */
class OutThread extends Thread {


    public Res res;

    public OutThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {


        while (true) {
           synchronized (res){
               // 如果当前正在写入,则不能读取,线程等待
               if (!res.flag) {
                   try {
                       res.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               System.out.println(res.name + "---" + res.sex);
               res.flag = false;
               res.notify();
           }
        }
    }
}

public class ThreadDemo01 {
    public static void main(String[] args) {
        Res res = new Res();
        InputThread inputThread = new InputThread(res);

        OutThread outThread = new OutThread(res);

        inputThread.start();
        outThread.start();
    }
}
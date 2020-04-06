package cn.myfreecloud;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized 和 lock的区别
 * synchronized 是 jdk 1.0 就出现的,为了简单的实现线程安全提供的一种同步机制,没有手动的加锁和解锁方法.
 * lock的区别   是 jdk 1.5 之后出现的,提供了手动的加锁和解锁api.
 */

class Res {

    public String name;
    public String sex;
    // flag 为 true的话,out线程才能去获取值
    public boolean flag = false;

    // 可重入锁
    public Lock lock = new ReentrantLock();

    // 保证单例
    Condition condition = lock.newCondition();
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

            try {
                // 加锁
                res.lock.lock();

                if(res.flag){
                    try {
                        res.condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                if (count == 0) {
                    // 偶数
                    res.name = "小明男男男";
                    res.sex = "男男";
                } else {
                    // 奇数
                    res.name = "小红";
                    res.sex = "女";
                }
                // 实现奇偶互换
                count = (count + 1) % 2;

                res.flag = true;
                // 唤醒当前线程
                res.condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
                // 保证一定会解锁
            } finally {
                // 解锁
                res.lock.unlock();
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

            try {
                // 加锁
                res.lock.lock();
                if(!res.flag){
                    res.condition.await();
                }
                System.out.println(res.name + "---" + res.sex);
                res.flag = false;
                res.condition.signal();

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                res.lock.unlock();
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
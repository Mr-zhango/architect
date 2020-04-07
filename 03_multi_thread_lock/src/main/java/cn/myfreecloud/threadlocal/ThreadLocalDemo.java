package cn.myfreecloud.threadlocal;

/**
 * @author: zhangyang
 * @date: 2020/4/7 16:24
 * @description: 本地线程类
 */
class Res {
    // 生成序列号共享变量
    public static Integer count = 0;

    /**
     * 设置本地局部变量和 其他线程隔离开 互不影响(只有本地线程能够使用,其他本地线程不能使用.底层实现原理是:map实现 map.put("当前线程",值)  key 就是当前线程 )
     */
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {

        // 设置当前线程局部变量的初始化值 0
        protected Integer initialValue() {
            return 0;
        };

    };

    /**
     * 生产订单号的方法
     * @return
     */
    public Integer getNum() {
        int count = threadLocal.get() + 1;
        threadLocal.set(count);
        return count;
    }
}

public class ThreadLocalDemo extends Thread {


    private Res res;

    public ThreadLocalDemo(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---" + "i---" + i + "--num:" + res.getNum());
        }

    }

    public static void main(String[] args) {

        Res res = new Res();

        ThreadLocalDemo threadLocaDemo1 = new ThreadLocalDemo(res);
        ThreadLocalDemo threadLocaDemo2 = new ThreadLocalDemo(res);
        ThreadLocalDemo threadLocaDemo3 = new ThreadLocalDemo(res);


        threadLocaDemo1.start();
        threadLocaDemo2.start();
        threadLocaDemo3.start();
    }

}


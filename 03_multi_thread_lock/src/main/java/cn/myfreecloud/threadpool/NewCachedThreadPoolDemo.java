package cn.myfreecloud.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zhangyang
 * @date: 2020/4/7 16:55
 * @description:
 */
public class NewCachedThreadPoolDemo {
    public static void main(String[] args) {

        // 创建可缓存的线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 30; i++) {
            int index = i;
            // 表示创建了一个线程,类似于start()
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "---" + index);

//                    // 10个线程创建完毕就关闭线程池
//                    if(index == 10 ){
//                        newCachedThreadPool.shutdown();
//                    }
                }
            });


        }

    }
}

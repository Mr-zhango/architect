package cn.myfreecloud.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zhangyang
 * @date: 2020/4/7 17:54
 * @description:
 */
public class NewFixedThreadTest {
    public static void main(String[] args) {
        // 最大线程数控制在3个,其他线程在等待执行
        ExecutorService newFIxedThreadPool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 30; i++) {
            int index = i;
            // 表示创建了一个线程,类似于start()
            newFIxedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "---" + index);

//                    // 10个线程创建完毕就关闭线程池
//                    if(index == 10 ){
//                        newFIxedThreadPool.shutdown();
//                    }
                }
            });


        }
    }
}

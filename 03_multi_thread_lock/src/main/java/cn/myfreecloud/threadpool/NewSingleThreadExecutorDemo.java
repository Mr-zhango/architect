package cn.myfreecloud.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zhangyang
 * @date: 2020/4/7 18:05
 * @description: 4
 */
public class NewSingleThreadExecutorDemo {
    public static void main(String[] args) {

        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            newSingleThreadExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println("index:" + index);
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {

                    }
                }
            });
        }
    }

}

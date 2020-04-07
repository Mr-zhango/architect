package cn.myfreecloud.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhangyang
 * @date: 2020/4/7 18:00
 * @description:
 */
public class NewScheduledThreadPoolDemo {
    public static void main(String[] args) {
        //  创建一个定长线程池，支持定时及周期性任务执行。延迟执行示例代码如下：
        // 线程池大小
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);

        // 执行定时任务的线程池
        newScheduledThreadPool.schedule(new Runnable() {
            public void run() {
                // 延时3s
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);

    }

}

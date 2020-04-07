package cn.myfreecloud.volatiledemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhangyang
 * @date: 2020/4/7 16:05
 * @description: 解决Volatile不满足原子性的问题
 */
public class VolatileNotAtomicSolution {
    public static void main(String[] args) {
        // 初始化能够装10个线程的容器--数组
        VolatileNotAtomicSolutionThread[] volatileNotAtomicArray = new VolatileNotAtomicSolutionThread[10];
        for (int i = 0; i < volatileNotAtomicArray.length; i++) {

            // 创建线程
            volatileNotAtomicArray[i] = new VolatileNotAtomicSolutionThread();
        }

        for (int i = 0; i < volatileNotAtomicArray.length; i++) {

            // 启动线程
            volatileNotAtomicArray[i].start();
        }


    }
}

class VolatileNotAtomicSolutionThread extends Thread {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            // 相当于 atomicInteger ++
            atomicInteger.incrementAndGet();
        }
        System.out.println(getName() + "-------" + atomicInteger.get());
    }
}
package cn.myfreecloud.volatiledemo;

/**
 * @author: zhangyang
 * @date: 2020/4/7 15:41
 * @description: 说明volatile不能满足原子性(不具有同步性)
 */
public class VolatileNotAtomicDemo {
    public static void main(String[] args) {
        // 初始化能够装10个线程的容器--数组
        VolatileNotAtomic[] volatileNotAtomicArray = new VolatileNotAtomic[10];
        for (int i = 0; i < volatileNotAtomicArray.length; i++) {

            // 创建线程
            volatileNotAtomicArray[i] = new VolatileNotAtomic();
        }

        for (int i = 0; i < volatileNotAtomicArray.length; i++) {

            // 启动线程
            volatileNotAtomicArray[i].start();
        }


    }
}

class VolatileNotAtomic extends Thread{

    public static int count = 0;
    //AtomicInteger atomicInteger = new AtomicInteger(0);



    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            count ++;

        }
        System.out.println(getName()+"-------"+count);
    }
}
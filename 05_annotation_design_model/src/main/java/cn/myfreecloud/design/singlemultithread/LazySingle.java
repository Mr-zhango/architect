package cn.myfreecloud.design.singlemultithread;

/**
 * 懒汉式
 * 加入同步为了解决多线程安全问题。
 * 加入双重判断是为了解决效率问题。
 */

/**
 * 饿汉式单例类不能实现延迟加载，不管将来用不用始终占据内存；
 * 懒汉式单例类线程安全控制烦琐，而且性能受影响。
 * 可见，无论是饿汉式单例还是懒汉式单例都存在这样那样的问题.
 */
class LazySingle {

    //使用volatile修饰变量 禁止指令重排

    /**
     * volatile具有可见性、有序性，不具备原子性。
     * <p>
     * 注意，volatile不具备原子性，这是volatile与java中的synchronized、java.util.concurrent.locks.Lock最大的功能差异，这一点在面试中也是非常容易问到的点。
     * <p>
     * 原子性：不可打断的操作，要么成功要么失败。例如基本数据类型的读写操作都是属于原子性，int a = 10这一过程就是原子性（即可以看成当一个线程执行int a = 10这句代码时其他线程是处于等待获取cpu资源的状态，因为线程并发是通过cpu调度交替执行，并不是真正的并行执行），
     * 但是像a++这样的运算操作就是非原子性，因为a++虚拟机要运行三个指令：读取a，a+1，a赋值，这个过程是允许打断的。
     * <p>
     * volatile具有可见性是指当一个线程对变量进行原子操作的时候，另外的线程能立即获取到最新的数据。
     */
    private static volatile LazySingle lazySingle = null;

    /**
     * 私有构造函数，外部访问不了
     */
    private LazySingle() {

    }

    public static LazySingle getInstance() {

        if (lazySingle == null) {
            synchronized (LazySingle.class) {
                if (lazySingle == null)

                    lazySingle = new LazySingle();
            }
        }
        return lazySingle;
    }
}
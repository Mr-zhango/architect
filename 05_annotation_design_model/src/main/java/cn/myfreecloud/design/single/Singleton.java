package cn.myfreecloud.design.single;

/**
 * 懒汉式代码
 * 线程不安全,需要加上同步锁 但是效率高
 */
class SingletonTest {

    /**
     * 单例:保证这个类在jvm中只有一个
     *
     * @param args
     */
    public static void main(String[] args) {
        Singleton sl1 = Singleton.getSingleton();
        Singleton sl2 = Singleton.getSingleton();
        System.out.println(sl1 == sl2);
    }
}

public class Singleton {

    // 当需要的才会被实例化
    private static Singleton singleton;

    public static Singleton getSingleton() {

        if (singleton == null) {
            synchronized (Singleton.class) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }

}

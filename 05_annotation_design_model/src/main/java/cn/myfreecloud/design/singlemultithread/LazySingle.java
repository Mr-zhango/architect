package cn.myfreecloud.design.singlemultithread;

/**
 * 懒汉式
 * 加入同步为了解决多线程安全问题。
 * 加入双重判断是为了解决效率问题。
 */

/**
 *  饿汉式单例类不能实现延迟加载，不管将来用不用始终占据内存；
 *  懒汉式单例类线程安全控制烦琐，而且性能受影响。
 *  可见，无论是饿汉式单例还是懒汉式单例都存在这样那样的问题.
 *
 *
 *
 */
class LazySingle {
    private static LazySingle lazySingle = null;

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
package cn.myfreecloud.design.singlemultithread;

public class SingletonSimple {
    //使用volatile关键字修饰静态变量singleton
    private volatile static SingletonSimple singleton;

    public static SingletonSimple getInstance() {

        // 防止多线程同时进入
        if (singleton == null) {

            //使用synchronized代码块进行同步处理
            synchronized (SingletonSimple.class) {   //a
                if (singleton == null) {
                    singleton = new SingletonSimple();//b
                }
            }
        }
        return singleton;
    }
}

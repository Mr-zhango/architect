package cn.myfreecloud.design.singlemultithread;

public class Singleton {
    //使用volatile关键字修饰静态变量singleton
    private volatile static Singleton singleton;

    public static Singleton getInstance() {
        if (singleton == null) {

            //使用synchronized代码块进行同步处理
            synchronized (Singleton.class) {   //a
                if (singleton == null) {
                    singleton = new Singleton();//b
                }
            }
        }
        return singleton;
    }
}

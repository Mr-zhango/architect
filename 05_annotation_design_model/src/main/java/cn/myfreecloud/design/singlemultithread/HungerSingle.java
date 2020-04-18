package cn.myfreecloud.design.singlemultithread;


/**
 * 多线程下的单例
 * 饿汉式 一上来就创建
 */

class HungerSingle {
    private static final HungerSingle hungerSingle = new HungerSingle();

    /**
     * 私有构造函数，外部访问不了
     */
    private HungerSingle() {

    }

    public static HungerSingle getInstance() {
        return hungerSingle;
    }
}
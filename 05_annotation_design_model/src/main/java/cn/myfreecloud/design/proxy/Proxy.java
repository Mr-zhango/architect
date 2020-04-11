package cn.myfreecloud.design.proxy;

/**
 * @author: zhangyang
 * @date: 2020/4/11 15:33
 * @description: 代理类,中介
 */
public class Proxy implements House {

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new HouseBuyer());

        proxy.mai();
    }

    private HouseBuyer houseBuyer;


    public Proxy(HouseBuyer houseBuyer){
        this.houseBuyer = houseBuyer;
    }

    @Override
    public void mai() {

        System.out.println("我是房产中介,我开始监听了.....");
        houseBuyer.mai();
        System.out.println("我是房产中介,我已经结束监听了.....");
    }
}

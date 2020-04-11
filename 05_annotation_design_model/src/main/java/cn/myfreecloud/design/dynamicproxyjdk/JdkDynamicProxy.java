package cn.myfreecloud.design.dynamicproxyjdk;

import cn.myfreecloud.design.proxy.House;
import cn.myfreecloud.design.proxy.HouseBuyer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: zhangyang
 * @date: 2020/4/11 16:51
 * @description:
 */
public class JdkDynamicProxy implements InvocationHandler {

    public Object object;

    public JdkDynamicProxy(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是jdk动态代理,开始监听了------");
        Object invoke = method.invoke(object, args);
        System.out.println("我是jdk动态代理,已经结束监听了------");
        return invoke;
    }

    public static void main(String[] args) {
        HouseBuyer houseBuyer = new HouseBuyer();
        JdkDynamicProxy jdkDynamicProxy = new JdkDynamicProxy(houseBuyer);

        // jdk 动态代理,通过 java的反射机制 生成代理类
        Object instance = Proxy.newProxyInstance(houseBuyer.getClass().getClassLoader(), houseBuyer.getClass().getInterfaces(), jdkDynamicProxy);

        House house = (House) instance;

        house.mai();
    }
}

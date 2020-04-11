package cn.myfreecloud.design.cglibdynamicproxy;

import cn.myfreecloud.design.proxy.House;
import cn.myfreecloud.design.proxy.HouseBuyer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: zhangyang
 * @date: 2020/4/11 17:20
 * @description:
 * cglib和jdk动态代理的区别
 * cglib底层是借助asm来实现的(java字节码控制)
 * Spring的AOP底层实现就是cglib的动态代理机制
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("我是jdk动态代理,开始监听了------");
        Object invoke = methodProxy.invokeSuper(object, objects);
        System.out.println("我是jdk动态代理,已经结束监听了------");

        return invoke;
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();

        // 使用asm框架生成代理类
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(HouseBuyer.class);

        enhancer.setCallback(cglibProxy);

        House house = (House) enhancer.create();

        house.mai();
    }
}

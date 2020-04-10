package cn.myfreecloud.reflex;

import cn.myfreecloud.reflex.demo.Teacher;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author: zhangyang
 * @date: 2020/4/7 19:35
 * @description:
 */
public class ClassForxx {
    public static void main(String[] args) throws Exception {
        // 1.反射类的基本使用,得到
//        Class<?> userEntity = Class.forName("cn.myfreecloud.reflex.User");
//
//        Object instance = userEntity.newInstance();
//
//        User user = (User) instance;
//        user.setUserId("111");
//        user.setUserName("zhangsan");
//        System.out.println(user);


        // 2.
//        Class<?> userEntity = Class.forName("cn.myfreecloud.reflex.User");
//        Constructor<?> constructor = userEntity.getConstructor(String.class,String.class);
//        User user = (User) constructor.newInstance("222","lisi");
//        System.out.println(user);

        Class<?> userEntity = Class.forName("cn.myfreecloud.reflex.User");
        Method[] declaredMethods = userEntity.getDeclaredMethods();


        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName() + "-----" + declaredMethod.getReturnType());
        }

        System.out.println("**********************");


        // 通过反射技术能获取到其他类中的私有方法并且使用,能够保证接口的安全
        Class<?> teacherClass = Class.forName("cn.myfreecloud.reflex.demo.Teacher");

        Constructor<?> constructor = teacherClass.getConstructor();

        Teacher teacher = (Teacher) constructor.newInstance();

        Method method = teacherClass.getDeclaredMethod("doSomingPrivte");
        method.setAccessible(true);
        method.invoke(teacher);


        Method method2 = teacherClass.getDeclaredMethod("doSomingPrivteWithArgs",String.class);
        method2.setAccessible(true);
        method2.invoke(teacher,"参数在这里传进来~~~");


    }
}

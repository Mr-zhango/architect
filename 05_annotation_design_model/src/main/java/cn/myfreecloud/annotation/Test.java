package cn.myfreecloud.annotation;

import java.lang.reflect.Field;

/**
 * @author: zhangyang
 * @date: 2020/4/10 19:25
 * @description:
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> userEntityClass = Class.forName("cn.myfreecloud.entity.UserEntity");


        // 获取注解(只能获取到当前类上使用了那个注解)
//        Annotation[] annotations = userEntityClass.getAnnotations();
//
//        for (Annotation annotation : annotations) {
//            System.out.println(annotation);
//        }

        Field[] declaredFields = userEntityClass.getDeclaredFields();

        /**
         * StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。
         *
         * StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。
         *
         * 由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类
         */
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(" select ");


        for (int i = 0; i < declaredFields.length; i++) {

            SetProperty setProperty = declaredFields[i].getAnnotation(SetProperty.class);

            String name = setProperty.name();
            int length = setProperty.length();

            stringBuffer.append(name);

            if(i == declaredFields.length - 1){
                stringBuffer.append(" from");
            }else {
                stringBuffer.append(" , ");
            }
        }

        // getAnnotation() 这个方法获取某个注解对象
        SetTable setTable = userEntityClass.getAnnotation(SetTable.class);

        // 获取注解上的表名
        String tableName = setTable.value();

        stringBuffer.append(" " + tableName);

        System.out.println(stringBuffer.toString());


    }
}

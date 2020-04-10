package cn.myfreecloud.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * <p>
 * 1.@Target
 *
 * @Target说明了Annotation所修饰的对象范围：Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、
 * 类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）。
 * 在Annotation类型的声明中使用了target可更加明晰其修饰的目标。
 * 1.	CONSTRUCTOR:用于描述构造器
 * 2.	FIELD:用于描述域
 * 3.	LOCAL_VARIABLE:用于描述局部变量
 * 4.	METHOD:用于描述方法
 * 5.	PACKAGE:用于描述包
 * 6.	PARAMETER:用于描述参数
 * 7.	TYPE:用于描述类、接口(包括注解类型) 或enum声明
 * <p>
 * 2.@Retention
 * 表示需要在什么级别保存该注释信息，用于描述注解的生命周期（即：被描述的注解在什么范围内有效）
 * 3.@Documented
 * 4.@Inherited
 */
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationTest {

    String value();

    int classId() default 0;

    String[] array();
}


class AnnotationDemo {
    private String name;

    @AnnotationTest(value = "123", classId = 123, array = {"111", "222"})
    public void add() {

    }
}

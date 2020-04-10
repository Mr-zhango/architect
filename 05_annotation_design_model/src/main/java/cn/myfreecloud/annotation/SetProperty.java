package cn.myfreecloud.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: zhangyang
 * @date: 2020/4/10 19:22
 * @description:
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SetProperty {

    String name();

    int length();
}

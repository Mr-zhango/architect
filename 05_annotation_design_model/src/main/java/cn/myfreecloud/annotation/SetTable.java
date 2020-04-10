package cn.myfreecloud.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SetTable {
    String value();
}


@SetTable("user_table")
class UserEntity{
    private String userName;

    private Integer userAge;
}
package cn.myfreecloud.entity;

import cn.myfreecloud.annotation.SetProperty;
import cn.myfreecloud.annotation.SetTable;

/**
 * @author: zhangyang
 * @date: 2020/4/10 18:59
 * @description:
 */
@SetTable("user_table")
public class UserEntity {

    @SetProperty(name = "user_name",length = 10)
    private String userName;
    @SetProperty(name = "user_age",length = 10)
    private Integer userAge;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}

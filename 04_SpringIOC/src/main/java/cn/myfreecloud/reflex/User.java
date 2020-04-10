package cn.myfreecloud.reflex;

/**
 * @author: zhangyang
 * @date: 2020/4/7 19:34
 * @description:
 */
public class User {
    private String userId;
    private String userName;

    public User() {
        System.out.println("使用反射技术--无参数构造方法已经执行~~");
    }

    public User(String userId, String userName) {
        System.out.println("使用反射技术--有参数构造方法已经执行!!!!!!!!!!!!!");
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}

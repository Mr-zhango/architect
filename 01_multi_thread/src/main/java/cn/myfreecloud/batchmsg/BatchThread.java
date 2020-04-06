package cn.myfreecloud.batchmsg;

import cn.myfreecloud.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class BatchThread {

    public static void main(String[] args) {

        List<UserEntity> listUserEntity = init();

        // 每个线程最多处理两条数据(相当于分页的每页个数)
        int userThreadPage = 2;
        // list分页处理 (总数据,每页个数)
        List<List<UserEntity>> splitUserList = ListUtils.splitList(listUserEntity, userThreadPage);
        // 总的页数(相当于需要多少个线程进行处理)
        int threadSaze = splitUserList.size();
        for (int i = 0; i < threadSaze; i++) {
            List<UserEntity> list = splitUserList.get(i);
            UserThread userThread = new UserThread(list);
            // 3.执行任务发送短信
            userThread.start();
        }

    }


    // 初始化 list 模拟11个用户
    public static List<UserEntity> init() {
        List<UserEntity> list = new ArrayList<UserEntity>();
        for (int i = 1; i <= 11; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId("userId" + i);
            userEntity.setUserName("userName" + i);
            list.add(userEntity);
        }
        return list;

    }

}

//类中还可创建其他类  比如线程类 定义变量 通过构造函数传入需要的参数
class UserThread extends Thread {

    private List<UserEntity> list;

    // 默认的构造方法
    public UserThread(List<UserEntity> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (UserEntity userEntity : list) {
            try {
                Thread.sleep(1000);
                System.out.println("threadName:" + Thread.currentThread().getName() + "-学员编号:" + userEntity.getUserId()
                        + "---学员名称:" + userEntity.getUserName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 调用发送短信具体代码

        }
    }

}
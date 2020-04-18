package cn.myfreecloud.design.factory;

import javax.security.auth.login.Configuration;

// 抽象类实现公共配置
public class AbstractHBaseCommand implements HBaseCommand {

    Configuration configuration;

    AbstractHBaseCommand(Object executeCondition) {
        this.configuration = getConfiguration("123");
    }

    // 获取连接Hbase的配置
    private Configuration getConfiguration(String resourceId) {
        //Configuration conf = HBaseConfiguration.create();

        //做一些配置相关事情
        //。。。。
        //return conf;
        return null;
    }

    @Override
    public Object execute() {

       return null;
    }
}
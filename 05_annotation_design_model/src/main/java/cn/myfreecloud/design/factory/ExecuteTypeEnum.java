package cn.myfreecloud.design.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ExecuteTypeEnum {

    @Getter
    @AllArgsConstructor
    public enum GETTYPEFORNAME {

        Get("GET"),
        Delete("GET");

        private String name;
    }

    public enum Signal {
        GET, PUT, DELETE
    }
}

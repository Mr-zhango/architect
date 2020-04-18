package cn.myfreecloud.design.factory;

public class CommandFactory {

    private Object executeCondition;

    public CommandFactory(Object executeCondition) {
        this.executeCondition = executeCondition;
    }

    public HBaseCommand create() {
        HBaseCommand hBaseCommand;
        switch (ExecuteTypeEnum.Signal.GET) {
            case GET:
                //return new GetCommand(executeCondition);
            case PUT:
                //return new PutCommand(executeCondition);
            case DELETE:
                //return new DeleteCommand(executeCondition);
        }
        return null;
    }
}
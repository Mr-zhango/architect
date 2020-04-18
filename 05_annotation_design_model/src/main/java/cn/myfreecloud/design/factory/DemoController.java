package cn.myfreecloud.design.factory;


/**
 * 每次增加一个功能，都需要从controller到service写一遍类似的操作。
 *
 * 还需要构建很多相关dto进行数据传递，里面会带着很多重复的变量，比如表名、列名等查询条件。
 * (因为没有使用设计模式)
 */
//@RestController("/hbase/execute")
//public class DemoController {
//
//    private HBaseExecuteService hbaseExecuteService;
//
//    public DemoController(ExecuteService executeService) {
//        this.hbaseExecuteService = executeService;
//    }
//
//    @PostMapping("/insert")
//    public void insertDate(InsertCondition insertCondition) {
//        hbaseExecuteService.insertDate(insertCondition);
//    }
//
//    @PostMapping("/update")
//    public void updateDate(UpdateCondition updateCondition) {
//        hbaseExecuteService.updateDate(updateCondition;
//    }
//
//    @PostMapping("/delete")
//    public void deleteDate(DeleteCondition deleteCondition) {
//        hbaseExecuteService.deleteData(deleteCondition);
//    }
//
//    @GetMapping("/select")
//    public Object selectDate(SelectCondition selectCondition) {
//        return hbaseExecuteService.seletData(selectCondition);
//    }
//}
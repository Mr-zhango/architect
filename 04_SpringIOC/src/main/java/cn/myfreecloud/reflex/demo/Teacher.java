package cn.myfreecloud.reflex.demo;

/**
 * @author: zhangyang
 * @date: 2020/4/10 18:04
 * @description:
 */
public class Teacher {

    private String teacherName;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    public Teacher() {

    }


    public void doSoming() {
        System.out.println("doSoming");
    }

    private void doSomingPrivte() {
        System.out.println("doSomingprivate");
    }

    private void doSomingPrivteWithArgs(String studentName) {

        System.out.println(" doSomingPrivteWithArgs 方法的参数是:" + studentName);
    }
}

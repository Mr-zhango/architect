package cn.myfreecloud.design.factorydemo;

/**
 * @author: zhangyang
 * @date: 2020/4/11 14:41
 * @description:
 */
public class TestFactory {
    public static void main(String[] args) {
        // 一般代码实现
//        AuDi auDi = new AuDi();
//
//        Benz benz = new Benz();
//
//        auDi.run();
//        benz.run();

        // 工厂模式代码实现
        Car audiCar = CarFactory.createCar("奥迪");

        Car benzCar = CarFactory.createCar("奔驰");

        audiCar.run();
        benzCar.run();

    }
}

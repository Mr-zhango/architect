package cn.myfreecloud.design.factorydemo;

public class CarFactory {
    static public Car createCar(String carName) {
        // jdk1.7之后,switch支持了String类型
        Car car = null;
        switch (carName) {
			case "奥迪":
                car = new AuDi();
				break;
			case "奔驰":
                car = new Benz();
                break;
			default:
				break;
        }
        return car;

    }

    public static void main(String[] args) {
        Car car1 = CarFactory.createCar("奥迪");
        Car car2 = CarFactory.createCar("奔驰");
        car1.run();
        car2.run();
    }
}


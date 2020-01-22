package flud;

import java.util.HashSet;

public class t {

    private static void metod(Car c) {
        Car c2 = new Car();
        c2.name = "dsfsd";
        c = c2;
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
//        car2.name = "sdsds";

        HashSet<Car> cars = new HashSet<>();

        cars.add(car1);
        cars.add(car2);

        int a=0;

//        metod(car);
//        System.out.println(car.name);
    }

}

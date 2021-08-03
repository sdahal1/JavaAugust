public class CarTest {
    public static void main(String[] args){
        System.out.println("hello cars demo oop intro");

        Car car1 = new Car("Toyota", "Rav-4");
        Car car2 = new Car("Honda", "Accord");
        Car car3 = new Car("Tesla", "Model X");
        Car usedCar = new Car("Honda", "Civic", 10000);
        Car basicCar = new Car();

        System.out.println(car1.getMileage());
        System.out.println(car2.getMileage());
        System.out.println(car3.getMileage());

        // System.out.println(car2.mileage);
        // System.out.println(car3.mileage);

        // car1.mileage+=1000;
        car1.drive();
        car1.drive(1000);

        car2.drive(23);

        // System.out.println(car1.mileage);
        // System.out.println(car2.mileage);
        // System.out.println(car3.mileage);

        System.out.println(car1.getCarDetails());
        System.out.println(car2.getCarDetails());


    }
}

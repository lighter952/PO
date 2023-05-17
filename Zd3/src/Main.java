
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Motorcycle bike = new Motorcycle();
        Truck truck = new Truck();

        car.isTaxi = true;
        car.horsePower = 200;
        car.openTrunk();
        System.out.println("Producer: " + car.make + ", Doors number: " + car.doorsNumber + ", Power: " + car.horsePower + " hp, Taxi: " + car.isTaxi);
        car.openTrunk();

        bike.isScooter = false;
        bike.horsePower = 100;
        System.out.println("Producer: " + bike.make + ", Drive type: " + bike.driveType + ", Power: " + bike.horsePower + " hp, Scooter: " + bike.isScooter);

        truck.load(15);

    }
}
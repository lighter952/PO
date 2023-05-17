public class Car extends Vehicle{

    int trunkVolume;
    int doorsNumber;
    boolean isTaxi;

    public Car() {
        make = "Porsche";
        model = "992";
        color = "green";
        horsePower = 200;
        trunkVolume = 500;
        doorsNumber = 5;
        isTaxi = false;
    }

    void openTrunk () {
        System.out.println("Trunk is open");
    }

}

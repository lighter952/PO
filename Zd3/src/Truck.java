public class Truck extends Vehicle  {

    int maxCarryingCapacity;
    String type;

    public Truck() {
        make = "MAN";
        model = "TGX";
        horsePower = 550;

        type = "Dump truck";
        maxCarryingCapacity = 22;
    }

    void load(int weight) {
        if(weight < maxCarryingCapacity) {
            System.out.println("The load is too heavy");
            return;
        }
        System.out.println(weight + " tonn loaded to truck");
    }

}

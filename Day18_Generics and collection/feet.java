import java.util.*;

class Vehicle {}
class Truck extends Vehicle {}
class Bike extends Vehicle {}

class FleetManager<T extends Vehicle> {
    private List<T> fleet = new ArrayList<>();

    public void addVehicle(T v) { fleet.add(v); }

    public void showFleet() {
        for (T v : fleet) System.out.println(v.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        FleetManager<Truck> truckManager = new FleetManager<>();
        truckManager.addVehicle(new Truck());
        truckManager.showFleet();

        FleetManager<Bike> bikeManager = new FleetManager<>();
        bikeManager.addVehicle(new Bike());
        bikeManager.showFleet();
    }
}


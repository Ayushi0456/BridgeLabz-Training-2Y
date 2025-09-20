import java.util.*;

// GPS Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract Vehicle class
abstract class Vehicle implements GPS {
    private String vehicleID;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    // Constructor
    public Vehicle(String vehicleID, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleID = vehicleID;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleID);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }

    // Encapsulation - restricted access
    public double getRatePerKm() {
        return ratePerKm;
    }

    public String getDriverName() {
        return driverName;
    }

    // GPS Implementation
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Subclass Car
class Car extends Vehicle {
    public Car(String vehicleID, String driverName, double ratePerKm, String location) {
        super(vehicleID, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm(); // normal rate
    }
}

// Subclass Bike
class Bike extends Vehicle {
    public Bike(String vehicleID, String driverName, double ratePerKm, String location) {
        super(vehicleID, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.8; // discount for bike rides
    }
}

// Subclass Auto
class Auto extends Vehicle {
    public Auto(String vehicleID, String driverName, double ratePerKm, String location) {
        super(vehicleID, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20; // extra base charge
    }
}

// Main Class
public class RideHailingApp {
    // Polymorphic method
    public static void processRide(Vehicle v, double distance) {
        v.getVehicleDetails();
        double fare = v.calculateFare(distance);
        System.out.println("Calculated Fare for " + distance + " km: ₹" + fare);
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        Vehicle car = new Car("C001", "Rajesh", 15, "Sector 18, Noida");
        Vehicle bike = new Bike("B001", "Anil", 10, "Connaught Place, Delhi");
        Vehicle auto = new Auto("A001", "Suresh", 12, "Mathura Road, Delhi");

        // Updating locations
        car.updateLocation("Noida City Center");
        bike.updateLocation("Karol Bagh");
        auto.updateLocation("Chandni Chowk");

        // Processing rides polymorphically
        processRide(car, 12.5);
        processRide(bike, 8);
        processRide(auto, 6.3);
    }
}


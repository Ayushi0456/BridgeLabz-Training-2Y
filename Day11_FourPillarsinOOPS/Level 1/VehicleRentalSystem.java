interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}


abstract class Vehicle {
    
    private String vehicleNumber;
    private String type;
    private double rentalRate; 
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per day: " + rentalRate);
    }
}

class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 500;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + insurancePolicyNumber + ", Insurance Amount: " + calculateInsurance();
    }
}

class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 200;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + insurancePolicyNumber + ", Insurance Amount: " + calculateInsurance();
    }
}

class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 1000; 
    }

    @Override
    public double calculateInsurance() {
        return 1000;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + insurancePolicyNumber + ", Insurance Amount: " + calculateInsurance();
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car("CAR123", 1500, "CAR-INS-001");
        vehicles[1] = new Bike("BIKE456", 500, "BIKE-INS-002");
        vehicles[2] = new Truck("TRUCK789", 3000, "TRUCK-INS-003");

        int rentalDays = 5;

        for (Vehicle v : vehicles) {
            v.displayDetails();
            double rentalCost = v.calculateRentalCost(rentalDays);
            System.out.println("Rental Cost for " + rentalDays + " days: " + rentalCost);

            if (v instanceof Insurable) {
                Insurable insurableVehicle = (Insurable) v;
                System.out.println(insurableVehicle.getInsuranceDetails());
            }

            System.out.println("----------------------------");
        }
    }
}


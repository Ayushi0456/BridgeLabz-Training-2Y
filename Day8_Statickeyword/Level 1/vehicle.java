class Vehicle {
    static double registrationFee = 1000.0;

    final int registrationNumber;
    String ownerName;
    String vehicleType;

    Vehicle(int registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Reg No: " + registrationNumber + ", Owner: " + ownerName +
                               ", Type: " + vehicleType + ", Fee: " + registrationFee);
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(1001, "Raj", "Car");
        Vehicle v2 = new Vehicle(1002, "Simran", "Bike");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
        Vehicle.updateRegistrationFee(1500);
        v1.displayVehicleDetails();
    }
}


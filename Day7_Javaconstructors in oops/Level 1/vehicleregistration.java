class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 5000.0; 

    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to " + registrationFee);
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Ayushi", "Car");
        v1.displayVehicleDetails();

        Vehicle.updateRegistrationFee(6000); 
        Vehicle v2 = new Vehicle("Rahul", "Bike");
        v2.displayVehicleDetails();
    }
}

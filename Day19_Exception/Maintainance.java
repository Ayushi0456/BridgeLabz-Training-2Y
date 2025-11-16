import java.time.LocalDate;

class ServiceOverdueException extends Exception {
    public ServiceOverdueException(String message) {
        super(message);
    }
}

class InvalidMileageException extends Exception {
    public InvalidMileageException(String message) {
        super(message);
    }
}
class VehicleMaintenance {

    private LocalDate lastServiceDate;
    private int mileage;

    public VehicleMaintenance(LocalDate lastServiceDate, int mileage) {
        this.lastServiceDate = lastServiceDate;
        this.mileage = mileage;
    }

    public void checkMaintenance() 
            throws ServiceOverdueException, InvalidMileageException {

        if (mileage < 0) {
            throw new InvalidMileageException("Invalid Mileage! Mileage cannot be negative.");
        }

        LocalDate sixMonthsBack = LocalDate.now().minusMonths(6);
        if (lastServiceDate.isBefore(sixMonthsBack)) {
            throw new ServiceOverdueException("Service Overdue! Last service was more than 6 months ago.");
        }

        System.out.println("Vehicle is in good condition. No maintenance needed.");
    }
}
public class Maintainance {
    public static void main(String[] args) {
        LocalDate lastService = LocalDate.of(2023, 12, 1); // Overdue example
        int mileage = 5000;

        VehicleMaintenance vm = new VehicleMaintenance(lastService, mileage);

        try {
            vm.checkMaintenance();
        } 
        catch (ServiceOverdueException e) {
            System.out.println("Alert: " + e.getMessage());
        } 
        catch (InvalidMileageException e) {
            System.out.println("Alert: " + e.getMessage());
        }

        System.out.println("Maintenance Check Completed.");
    }
}


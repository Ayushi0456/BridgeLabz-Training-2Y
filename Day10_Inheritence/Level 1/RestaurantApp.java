interface Worker {
    void performDuties();
}

class Person {
    protected String name;
    protected String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends Person implements Worker {
    private String specialty;

    public Chef(String name, String id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Chef Duties: Prepare meals, ensure quality of " + specialty + " dishes.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Specialty: " + specialty);
    }
}

class Waiter extends Person implements Worker {
    private int tableNumber;

    public Waiter(String name, String id, int tableNumber) {
        super(name, id);
        this.tableNumber = tableNumber;
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter Duties: Serve food to table number " + tableNumber + " and attend customers.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Assigned Table: " + tableNumber);
    }
}

public class RestaurantApp {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon Ramsay", "C001", "Italian Cuisine");
        Waiter waiter = new Waiter("Alice", "W001", 5);

        System.out.println("----Chef Info----");
        chef.displayInfo();
        chef.performDuties();

        System.out.println("\n----Waiter Info----");
        waiter.displayInfo();
        waiter.performDuties();
    }
}


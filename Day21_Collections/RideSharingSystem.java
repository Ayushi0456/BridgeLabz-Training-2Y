import java.util.*;

class RideRequest implements Comparable<RideRequest> {
    int requestId;
    int priority; 

    public RideRequest(int requestId, int priority) {
        this.requestId = requestId;
        this.priority = priority;
    }

    public int compareTo(RideRequest r) {
        return this.priority - r.priority;
    }

    public String toString() {
        return "ReqID=" + requestId + ", Priority=" + priority;
    }
}

class Driver {
    String name;

    public Driver(String name) { this.name = name; }

    public String toString() { return name; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Driver)) return false;
        return name.equals(((Driver)o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Ride {
    RideRequest req;
    Driver driver;

    public Ride(RideRequest req, Driver driver) {
        this.req = req;
        this.driver = driver;
    }

    public String toString() {
        return driver + " completed " + req;
    }
}

public class RideSharingSystem {
    public static void main(String[] args) {

       
        Queue<RideRequest> requestQueue = new LinkedList<>();

 
        PriorityQueue<RideRequest> priorityQueue = new PriorityQueue<>();

        requestQueue.add(new RideRequest(11, 5));
        requestQueue.add(new RideRequest(12, 1)); 
        requestQueue.add(new RideRequest(13, 3));

        priorityQueue.addAll(requestQueue);

       
        Set<Driver> drivers = new HashSet<>();
        drivers.add(new Driver("Ram"));
        drivers.add(new Driver("Shyam"));

       
        List<Ride> rideHistory = new ArrayList<>();

        System.out.println("Assigning rides...");
        Iterator<Driver> driverIterator = drivers.iterator();

        while (!priorityQueue.isEmpty() && driverIterator.hasNext()) {
            RideRequest req = priorityQueue.poll();
            Driver d = driverIterator.next();
            Ride ride = new Ride(req, d);

            rideHistory.add(ride);
            System.out.println("Assigned: " + ride);
        }

        System.out.println("\nRide History:");
        for (Ride r : rideHistory) {
            System.out.println(r);
        }
    }
}


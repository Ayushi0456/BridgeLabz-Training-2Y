package Participants;
import java.util.*;

class Participant<T> {
    private T rollNumber;
    private String name;
    private String branch;

    public Participant(T rollNumber, String name, String branch) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.branch = branch;
    }

    public T getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public void displayInfo() {
        System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", Branch: " + branch);
    }
}

class EventRegistration<T> {
    private ArrayList<Participant<T>> registeredList = new ArrayList<>();
    private LinkedList<Participant<T>> waitingList = new LinkedList<>();
    private HashSet<T> registeredRollNumbers = new HashSet<>();
    private final int MAX_CAPACITY;

    public EventRegistration(int capacity) {
        this.MAX_CAPACITY = capacity;
    }

    public void registerParticipant(Participant<T> participant) {
        T roll = participant.getRollNumber();

        if (registeredRollNumbers.contains(roll)) {
            System.out.println("Roll number " + roll + " already registered!");
            return;
        }

        if (registeredList.size() < MAX_CAPACITY) {
            registeredList.add(participant);
            registeredRollNumbers.add(roll);
            System.out.println("Registered successfully: " + participant.getName());
        } else {
            waitingList.add(participant);
            System.out.println("Added to waiting list: " + participant.getName());
        }
    }

    public void cancelRegistration(T rollNumber) {
        boolean removed = false;

        Iterator<Participant<T>> itr = registeredList.iterator();
        while (itr.hasNext()) {
            Participant<T> p = itr.next();
            if (p.getRollNumber().equals(rollNumber)) {
                itr.remove();
                registeredRollNumbers.remove(rollNumber);
                removed = true;
                System.out.println("Registration cancelled for: " + p.getName());
                break;
            }
        }

        if (!removed) {
            Iterator<Participant<T>> waitItr = waitingList.iterator();
            while (waitItr.hasNext()) {
                Participant<T> p = waitItr.next();
                if (p.getRollNumber().equals(rollNumber)) {
                    waitItr.remove();
                    System.out.println("Removed from waiting list: " + p.getName());
                    return;
                }
            }
            System.out.println("Roll number not found.");
            return;
        }

        if (!waitingList.isEmpty()) {
            Participant<T> next = waitingList.poll();
            registeredList.add(next);
            registeredRollNumbers.add(next.getRollNumber());
            System.out.println("Moved from waiting list to main: " + next.getName());
        }
    }

    public void displayRegistered() {
        System.out.println("\nRegistered Participants:");
        if (registeredList.isEmpty()) {
            System.out.println("No registered participants.");
        } else {
            for (Participant<T> p : registeredList) {
                p.displayInfo();
            }
        }
    }

    public void displayWaitingList() {
        System.out.println("\nWaiting List:");
        if (waitingList.isEmpty()) {
            System.out.println("No participants in waiting list.");
        } else {
            for (Participant<T> p : waitingList) {
                p.displayInfo();
            }
        }
    }
}

public class StudentEventRegistration {
    public static void main(String[] args) {
        EventRegistration<Integer> event = new EventRegistration<>(3);

        Participant<Integer> p1 = new Participant<>(101, "Ayushi", "CSE");
        Participant<Integer> p2 = new Participant<>(102, "Rohan", "ECE");
        Participant<Integer> p3 = new Participant<>(103, "Neha", "ME");
        Participant<Integer> p4 = new Participant<>(104, "Arjun", "CSE");

        event.registerParticipant(p1);
        event.registerParticipant(p2);
        event.registerParticipant(p3);
        event.registerParticipant(p4); 
        event.displayRegistered();
        event.displayWaitingList();

        System.out.println("\n--- Cancelling Roll No 102 ---");
        event.cancelRegistration(102);

        event.displayRegistered();
        event.displayWaitingList();
    }
}

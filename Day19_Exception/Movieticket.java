import java.util.HashMap;
import java.util.Map;

class InvalidSeatException extends Exception {
    public InvalidSeatException(String msg) {
        super(msg);
    }
}

class SeatAlreadyBookedException extends Exception {
    public SeatAlreadyBookedException(String msg) {
        super(msg);
    }
}

public class Movieticket {

    static Map<Integer, Boolean> seats = new HashMap<>();

    static {
        seats.put(1, false);
        seats.put(2, false);
        seats.put(3, false);
    }

    public static void bookSeat(int seatNo)
            throws InvalidSeatException, SeatAlreadyBookedException {

        if (!seats.containsKey(seatNo))
            throw new InvalidSeatException("Seat does not exist!");

        if (seats.get(seatNo))
            throw new SeatAlreadyBookedException("Seat already booked!");

        seats.put(seatNo, true);
        System.out.println("Seat " + seatNo + " booked successfully!");
    }

    public static void main(String[] args) {
        try {
            bookSeat(2);
            bookSeat(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


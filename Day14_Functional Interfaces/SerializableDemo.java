import java.io.Serializable;

class UserData implements Serializable {
    String name = "Ayushi";
}

public class SerializableDemo {
    public static void main(String[] args) {
        UserData u = new UserData();
        System.out.println("Object ready for serialization: " + u.name);
    }
}


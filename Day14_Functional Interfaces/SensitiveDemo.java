interface Sensitive {}

class Aadhaar implements Sensitive {
    String number = "1234-5678";
}

public class SensitiveDemo {
    public static void main(String[] args) {
        Aadhaar a = new Aadhaar();

        if (a instanceof Sensitive)
            System.out.println("Data is sensitive! Encrypt it.");
    }
}


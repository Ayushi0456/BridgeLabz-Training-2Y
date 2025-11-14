interface UnitConverter {
    static double kmToMiles(double km) { return km * 0.621; }
    static double kgToLbs(double kg) { return kg * 2.205; }
}

public class UnitConverter1 {
    public static void main(String[] args) {
        System.out.println(UnitConverter.kmToMiles(10));
        System.out.println(UnitConverter.kgToLbs(5));
    }
}


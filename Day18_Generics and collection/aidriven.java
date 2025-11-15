import java.util.*;

abstract class JobRole {}
class SoftwareEngineer extends JobRole {}
class DataScientist extends JobRole {}
class ProductManager extends JobRole {}

class Resume<T extends JobRole> {
    private T role;
    public Resume(T role) { this.role = role; }
}

class ScreeningPipeline {
    public static void screen(List<? extends JobRole> roles) {
        for (JobRole r : roles)
            System.out.println("Screening: " + r.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        List<JobRole> list = List.of(new SoftwareEngineer(), new ProductManager());
        screen(list);
    }
}


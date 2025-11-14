interface Exportable {
    void exportCSV();
    void exportPDF();

    default void exportToJSON() {
        System.out.println("Exported to JSON");
    }
}

class Report implements Exportable {
    public void exportCSV() { System.out.println("CSV Exported"); }
    public void exportPDF() { System.out.println("PDF Exported"); }
}

public class ExportDemo {
    public static void main(String[] args) {
        Report r = new Report();
        r.exportToJSON();
    }
}


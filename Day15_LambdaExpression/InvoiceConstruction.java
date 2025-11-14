import java.util.*;
import java.util.stream.Collectors;

class Invoice {
    String transactionId;

    Invoice(String id) {
        this.transactionId = id;
    }

    public String toString() {
        return "Invoice created for Transaction: " + transactionId;
    }
}

public class InvoiceConstruction {
    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList("T1001", "T1002", "T1003");

        List<Invoice> invoices =
                transactionIds.stream()
                              .map(Invoice::new)
                              .collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}


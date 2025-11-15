import java.util.*;

abstract class ProductType {}
class Book extends ProductType {}
class Clothing extends ProductType {}
class Gadget extends ProductType {}

class Catalog<T extends ProductType> {
    private List<T> items = new ArrayList<>();
    public void addItem(T item) { items.add(item); }
}

class Marketplace {
    public static void main(String[] args) {
        Catalog<Book> bookCatalog = new Catalog<>();
        bookCatalog.addItem(new Book());

        Catalog<Gadget> gadgetCatalog = new Catalog<>();
        gadgetCatalog.addItem(new Gadget());
    }
}


import java.util.*;

class Cart<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) { items.add(item); }
    public void removeItem(T item) { items.remove(item); }

    public void displayItems() {
        for (T i : items) System.out.println(i);
    }

    public static void main(String[] args) {
        Cart<String> electronics = new Cart<>();
        electronics.addItem("Mobile");
        electronics.displayItems();

        Cart<String> clothes = new Cart<>();
        clothes.addItem("Shirt");
        clothes.displayItems();
    }
}


import java.util.*;

class MenuItem {
    private String name;
    private double price;
    public MenuItem(String name, double price){ this.name = name; this.price = price; }
    public String toString(){ return name + " (" + price + ")"; }
}

class RestaurantOrder {
    private List<MenuItem> items = new ArrayList<>();
    public void addItem(String name, double price){ items.add(new MenuItem(name, price)); }
    public void printOrder(){
        System.out.println("Order items:");
        items.forEach(i -> System.out.println("- " + i));
    }
    public void clearOrder(){ items.clear(); System.out.println("Order cleared (items removed)."); }
}

public class RestaurantDemo {
    public static void main(String[] args){
        RestaurantOrder order = new RestaurantOrder();
        order.addItem("Paneer Butter Masala", 220);
        order.addItem("Naan", 30);
        order.printOrder();
        order.clearOrder();
        order.printOrder();
    }
}


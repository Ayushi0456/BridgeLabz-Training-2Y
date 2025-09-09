import java.util.ArrayList;

class shoppingcart{
    String itemName;
    double price;
    int quantity;

    shoppingcart(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotalPrice() {
        return price * quantity;
    }
}

class shoppingCart {
    ArrayList<shoppingcart> cart = new ArrayList<>();

  
    void addItem(String name, double price, int qty) {
        cart.add(new shoppingcart(name, price, qty));
        System.out.println(name + " added to cart.");
    }

    
    void removeItem(String name) {
        boolean removed = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).itemName.equalsIgnoreCase(name)) {
                cart.remove(i);
                System.out.println(name + " removed from cart.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println(name + " not found in cart.");
        }
    }

    
    void displayTotalCost() {
        double total = 0;
        for (shoppingcart item : cart) {
            total += item.getTotalPrice();
        }
        System.out.println("Total Cost = " + total);
    }

    public static void main(String[] args) {
        ShoppingCart myCart = new ShoppingCart();

        myCart.addItem("Laptop", 50000, 1);
        myCart.addItem("Mouse", 1500, 2);

        myCart.displayTotalCost();

        myCart.removeItem("Mouse");
        myCart.displayTotalCost();
    }
}


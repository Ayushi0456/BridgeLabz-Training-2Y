class Fruit {}
class Apple extends Fruit {}
class Mango extends Fruit {}
class Car {}

class FruitBox<T extends Fruit> {
    public void add(T fruit) {
        System.out.println("Added: " + fruit.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        FruitBox<Apple> box = new FruitBox<>();
        box.add(new Apple());
        }
}


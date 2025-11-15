interface MealPlan {}
class VegetarianMeal implements MealPlan {}
class VeganMeal implements MealPlan {}
class KetoMeal implements MealPlan {}

class Meal<T extends MealPlan> {
    public void prepare(T meal) {
        System.out.println("Preparing: " + meal.getClass().getSimpleName());
    }
}

class MealGenerator {
    public static <T extends MealPlan> void generate(T meal) {
        System.out.println("Generated: " + meal.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        generate(new VegetarianMeal());
        generate(new KetoMeal());
    }
}


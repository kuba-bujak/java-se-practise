package pl.globallogic.streams;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MenuDataProcessor {

    public static int getTotalCaloriesMenu(Menu menu) {
        return getTotalForMenu(menu, dish -> dish.getCalories());
    }

    public static int getTotalCookingTimeMenu(Menu menu) {
        return getTotalForMenu(menu, dish -> dish.getCookingTime());
    }

    private static int getTotalForMenu(Menu menu, Function<Dish, Integer> extractor) {
        return menu.getDishList()
                .stream()
                .map(extractor)
                .mapToInt(x -> x)
                .sum();
    }

    private static List<Dish> filterMenuBy(Menu menu, Predicate<Dish> tester) {
        return menu.getDishList()
                .stream()
                .filter(dish -> tester.test(dish))
                .toList();
    }

    public static List<Dish> getVeganDishesForMenu(Menu menu) {
        return filterMenuBy(menu, dish -> dish.isVegan());
    }

    public static List<Dish> getDishesWithCaloriesLessThan(int calories, Menu menu) {
        return filterMenuBy(menu, dish -> dish.getCalories() < calories);
    }

    public static List<Dish> getDishesWithCaloriesGreaterThan(int calories, Menu menu) {
        return filterMenuBy(menu, dish -> dish.getCalories() > calories);

    }

    public static List<Dish> getDishesWithCookingTimeGreaterThan(int cookingTime, Menu menu) {
        return filterMenuBy(menu, dish -> dish.getCookingTime() > cookingTime);
    }

    public static List<Dish> getDishesWithSpecifiedIngredient(List<String> specifiedIngredient, Menu menu) {
        return filterMenuBy(menu, dish -> dish.getIngredients().containsAll(specifiedIngredient));
    }

    public static List<Dish> getDishesWithoutSpecifiedIngredient(List<String> specifiedIngredient, Menu menu) {
        List<Dish> dishesWithoutSpecifiedIngredient = new ArrayList<>();
        for (Dish dish : menu.getDishList()) {
            if (dish.getIngredients().containsAll(specifiedIngredient)) {
                continue;
            } else {
                dishesWithoutSpecifiedIngredient.add(dish);
            }
        }
        return dishesWithoutSpecifiedIngredient;
    }

    public static List<Dish> getTop5LessCaloriesDishes(Menu menu) {
        return menu.getDishList()
                .stream()
                .sorted(new DishCaloriesComparator())
                .limit(5)
                .toList();
    }

    public static List<Dish> getTop3VeganDishesLessThan200Calories(Menu menu) {
        Predicate<Dish> vegan = dish -> dish.isVegan();
        Predicate<Dish> veganAndCalories = vegan.and(dish -> dish.getCalories() < 200);
        return menu.getDishList()
                .stream()
                .filter(veganAndCalories)
                .limit(3)
                .toList();
    }
}

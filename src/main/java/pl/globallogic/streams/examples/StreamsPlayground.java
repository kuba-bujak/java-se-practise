package pl.globallogic.streams.examples;

import org.w3c.dom.ls.LSOutput;
import pl.globallogic.streams.Dish;
import pl.globallogic.streams.DishData;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamsPlayground {
    public static void main(String[] args) {
        List<Dish> menu = DishData.getData();
        int maxCookingTime = 20;

        // filter
        System.out.println("Get dishes with cooking time greater than 20 min");
        System.out.println(
                menu.stream()
                        .filter((Dish dish) -> {return dish.getCookingTime() > maxCookingTime;})
                        .toList());

        // map
        System.out.println("Get list of dish names in upper case");
        System.out.println(
                menu.stream()
                        .map((Dish dish) -> {return dish.getTitle().toUpperCase();})
                        .toList()
        );

        // limit & skip
        System.out.println("Get names for 3,4,5 dishes in menu");
        System.out.println(
                menu.stream()
                        .map(Dish::getTitle)
                        .skip(3)
                        .limit(3)
                        .toList()
        );

        // sort
        System.out.println("Get top 3 dishes sorted by cooking time");
        System.out.println(menu.stream()
                .sorted(Comparator.comparingInt(Dish::getCookingTime))
                .limit(3)
                .toList());

        System.out.println("Get  top 5 of high-calories dishes");
        System.out.println(menu.stream()
                .sorted(Comparator.comparingInt(Dish::getCalories).reversed())
                .limit(5)
                .toList());

        // distinc
        System.out.println("Get list of all possible cooking times");
        System.out.println(menu.stream()
                .map(dish -> dish.getCookingTime())
                .distinct()
                .toList());

        // findFirst
        System.out.println("Get first dish which cooking time greater than 15 min");
        System.out.println(menu.stream()
                .filter(dish -> dish.getCookingTime() > 15)
                .findFirst().get());

        // findAny
        System.out.println("Find any non-vegetarian dish");
        System.out.println(menu.stream()
                .filter(Dish::isVegan)
                .findAny().get());

        // allMatch
        System.out.println("Is menu vegetarian friendly (contains only non-meat dishes)");
        System.out.println(menu.stream()
                .allMatch(Dish::isVegan));

        // anyMatch
        System.out.println("Do we have any vegan dish?");
        System.out.println(menu.stream()
                .anyMatch(Dish::isVegan));

        // noneMatch
        System.out.println("Do we have anything with orange?");
        System.out.println(menu.stream()
                .noneMatch(dish -> dish.getIngredients().contains("orange")));

        // max & min
        System.out.println("Find max by calories and min by cooking time dishes");
        System.out.println("Min cooking time: " + menu.stream()
                .map(Dish::getCookingTime)
                .mapToInt(x -> x)
                .min()
                .getAsInt());

        System.out.println("Max calories: " + menu.stream()
                .map(Dish::getCalories)
                .mapToInt(x -> x)
                .max()
                .getAsInt());

        // reduce
        System.out.println("Get sum of calories and total cooking times for non-vegetarian dishes without bread");
        System.out.println("Total menu calories = " + menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum));

        Predicate<Dish> isVegan = Dish::isVegan;
        Predicate<Dish> veganWithoutBread = isVegan.and(dish -> !dish.getIngredients().contains("bread"));
        System.out.println("Total cooking times for non-vegetarian dishes without bread " + menu.stream()
                .filter(veganWithoutBread)
                .map(Dish::getCalories)
                .reduce(0, Integer::sum));

        // flatMap
        System.out.println("Get list of unique ingredients in a menu");
        System.out.println(menu.stream()
                .flatMap(dish -> dish.getIngredients().stream())
                .distinct()
                .sorted()
                .toList());
    }
}

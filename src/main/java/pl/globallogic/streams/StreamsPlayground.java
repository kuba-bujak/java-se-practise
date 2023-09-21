package pl.globallogic.streams;

import java.util.Comparator;
import java.util.List;

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
    }
}

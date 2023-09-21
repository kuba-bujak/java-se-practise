package pl.globallogic.streams;

import java.util.List;

public class DishData {
    public static List<Dish> getData() {
        return List.of(
                new Dish("Pasta", 450, 30, false, List.of("pasta", "cheese", "tomato", "olive oil")),
                new Dish("Pizza", 600, 20, false, List.of("flower", "cheese", "tomato", "ham")),
                new Dish("Hot dog", 300, 15, false, List.of("white bread", "sausage", "mustard")),
                new Dish("Ham sandwich", 270, 10, false, List.of("bread", "ham", "sauce", "salad")),
                new Dish("Pastrami sandwich", 250, 24, false, List.of("bread", "ham", "sauce", "salad")),
                new Dish("Kebab", 250, 13, false, List.of("tortilla", "chicken", "sauce", "tomato", "cucumber", "chili")),
                new Dish("Sushi", 200, 10, false, List.of("rice", "fish", "algi", "avocado")),
                new Dish("Boiled eggs", 130, 10, false, List.of("egg")),
                new Dish("Tofu", 130, 5, true, List.of("tofu")),
                new Dish("Vegetable biryani", 97, 60, true, List.of("rice", "olive oil", "vegetables", "chili")),
                new Dish("Soy burger", 150, 20, true, List.of("soy", "salad", "tomato"))
        );
    }
}

package pl.globallogic.streams;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class MenuDataProcessorTest {

    Menu menu;

    @BeforeClass
    public void testSetUp() {
        List<Dish> dishList = List.of(
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
        menu = new Menu(dishList);
    }

    // get total menu calories
    @Test
    public void shouldReturnTotalCaloriesForMenu(){
        int expectedTotal = 2827;
        int totalCalories = MenuDataProcessor.getTotalCaloriesMenu(menu);
        Assert.assertEquals(expectedTotal, totalCalories);
    }

    // get vegan dishes
    @Test
    public void shouldReturnOnlyVeganDishes() {
        List<String> veganDishesTitle = List.of("Tofu", "Vegetable biryani");
        List<Dish> veganMenu = MenuDataProcessor.getVeganDishesForMenu(menu);
        Assert.assertTrue(veganDishesTitle.contains(veganMenu.get(0).getTitle()));
    }

    // get dishes with calories less than specified value
    @Test
    public void shouldReturnDishesWithCaloriesLessThanSpecifiedValue() {
        int calories = 100;
        List<Dish> dishesWithLT150Calories = MenuDataProcessor.getDishesWithCaloriesLessThan(calories, menu);
        Assert.assertEquals("Vegetable biryani", dishesWithLT150Calories.get(0).getTitle());
    }

    // get dishes with calories greater than specified value
    @Test
    public void shouldReturnDishesWithCaloriesGreaterThanSpecifiedValue() {
        int calories = 200;
        List<Dish> dishesWithGT150Calories = MenuDataProcessor.getDishesWithCaloriesGreaterThan(calories, menu);
        Assert.assertEquals("Pasta", dishesWithGT150Calories.get(0).getTitle());
    }

    // get dishes with cooking time greater than specified value
    @Test
    public void shouldReturnDishesWithCookingTimeGreaterThanSpecifiedValue() {
        int cookingTime = 20;
        List<Dish> dishesWithGT20CookingTime = MenuDataProcessor.getDishesWithCookingTimeGreaterThan(cookingTime, menu);
        Assert.assertEquals("Pasta", dishesWithGT20CookingTime.get(0).getTitle());
    }

    // get dishes with specified ingredient
    @Test
    public void shouldReturnDishesWithSpecifiedIngredient() {
        List<String> expectedIngredients = List.of("bread");
        int expectedNumberOfDishes = 2;
        List<Dish> dishesWithSpecifiedIngredient = MenuDataProcessor.getDishesWithSpecifiedIngredient(expectedIngredients, menu);
        Assert.assertEquals(expectedNumberOfDishes, dishesWithSpecifiedIngredient.size());
    }

    // get dishes without specified ingredient
    @Test
    public void shouldReturnDishesWithoutSpecifiedIngredient() {
        List<String> expectedIngredients = List.of("cheese");
        int expectedNumberOfDishes = 9;
        List<Dish> dishesWithoutSpecifiedIngredient = MenuDataProcessor.getDishesWithoutSpecifiedIngredient(expectedIngredients, menu);
        Assert.assertEquals(expectedNumberOfDishes, dishesWithoutSpecifiedIngredient.size());
    }

    // get top 5 dish calories dishes
    @Test
    public void shouldReturn5LessCaloriesDishes() {
        String expected2ndDishTitle = "Boiled eggs";
        List<Dish> top5LessCaloriesDishes = MenuDataProcessor.getTop5LessCaloriesDishes(menu);
        Assert.assertEquals(expected2ndDishTitle, top5LessCaloriesDishes.get(1).getTitle());
    }
    // get top 3 vegetarian dishes cooking time with calories less than 200
    @Test
    public void shouldReturnTop3VeganDishLessThan200Calories() {
        String expected2ndDishTitle = "Vegetable biryani";
        List<Dish> top3VeganDishesLessThan200Calories = MenuDataProcessor.getTop3VeganDishesLessThan200Calories(menu);
        Assert.assertEquals(expected2ndDishTitle, top3VeganDishesLessThan200Calories.get(1).getTitle());
    }


}

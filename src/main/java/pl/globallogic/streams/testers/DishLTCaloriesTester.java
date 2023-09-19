package pl.globallogic.streams.testers;

import pl.globallogic.streams.Dish;

public class DishLTCaloriesTester implements DishTester {

    private int value;

    public DishLTCaloriesTester(int value) {
        this.value = value;
    }
    @Override
    public boolean test(Dish dish) {
        return dish.getCalories() < this.value;
    }
}

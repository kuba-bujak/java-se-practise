package pl.globallogic.streams.testers;

import pl.globallogic.streams.Dish;

public class DishGTCaloriesTester implements DishTester {

    private int value;

    public DishGTCaloriesTester(int value) {
        this.value = value;
    }
    @Override
    public boolean test(Dish dish) {
        return dish.getCalories() > this.value;
    }
}

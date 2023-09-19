package pl.globallogic.streams.testers;

import pl.globallogic.streams.Dish;
import pl.globallogic.streams.testers.DishTester;

public class DishVeganTester implements DishTester {
    @Override
    public boolean test(Dish dish) {
        return dish.isVegan();
    }
}

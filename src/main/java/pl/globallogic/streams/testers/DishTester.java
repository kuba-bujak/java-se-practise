package pl.globallogic.streams.testers;

import pl.globallogic.streams.Dish;

@FunctionalInterface
public interface DishTester {
    boolean test(Dish dish);
}

package pl.globallogic.streams.extractors;

import pl.globallogic.streams.Dish;
import pl.globallogic.streams.extractors.DishDataExtractor;

public class CaloriesDishExtractor implements DishDataExtractor {
    @Override
    public int extractData(Dish dish) {
        return dish.getCalories();
    }
}

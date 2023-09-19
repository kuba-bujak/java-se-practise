package pl.globallogic.streams.extractors;

import pl.globallogic.streams.Dish;
import pl.globallogic.streams.extractors.DishDataExtractor;

public class CookingTimeDishExtractor implements DishDataExtractor {
    @Override
    public int extractData(Dish dish) {
        return dish.getCookingTime();
    }
}

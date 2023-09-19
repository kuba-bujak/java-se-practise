package pl.globallogic.streams.extractors;

import pl.globallogic.streams.Dish;

@FunctionalInterface
public interface DishDataExtractor {

    int extractData(Dish dish);

}

package pl.globallogic.streams;

import java.util.Comparator;

public class DishCaloriesComparator implements Comparator<Dish> {
    @Override
    public int compare(Dish o1, Dish o2) {
        return Integer.compare(o1.getCalories(), o2.getCalories());
    }
}

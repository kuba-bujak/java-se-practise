package pl.globallogic.streams.testers;

import pl.globallogic.streams.Dish;

import java.util.List;

public class DishIngredientsTester implements DishTester {
    private List<String> ingredients;

    public DishIngredientsTester(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean test(Dish dish) {
        return dish.getIngredients().containsAll(this.ingredients);
    }
}

package pl.globallogic.streams;

import java.util.List;
import java.util.Objects;

public class Dish {
    private String title;
    private int calories;
    private int cookingTime;
    private boolean isVegan;
    private List<String> ingredients;

    public Dish(String title, int calories, int cookingTime, boolean isVegan, List<String> ingredients) {
        this.title = title;
        this.calories = calories;
        this.cookingTime = cookingTime;
        this.isVegan = isVegan;
        this.ingredients = ingredients;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return calories == dish.calories && cookingTime == dish.cookingTime
                && isVegan == dish.isVegan && Objects.equals(title, dish.title) &&
                Objects.equals(ingredients, dish.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, calories, cookingTime, isVegan, ingredients);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "title='" + title + '\'' +
                ", calories=" + calories +
                ", cookingTime=" + cookingTime +
                ", isVegan=" + isVegan +
                ", ingredients=" + ingredients +
                '}';
    }
}

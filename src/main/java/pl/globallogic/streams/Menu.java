package pl.globallogic.streams;

import java.util.List;

public class Menu {

    private List<Dish> dishList;

    public Menu(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }
}

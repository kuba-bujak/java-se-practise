package pl.globallogic.lessons.lesson9;

import java.util.Stack;

public class WorkingWithStactMethods {
    public static void main(String[] args) {
        Fruit apple = new Fruit("Apple", "Poland", 15);
        Fruit bananas = new Fruit("Bananas", "Equador", 25);
        Fruit orange = new Fruit("Orange", "Spain", 18);

        Stack<Fruit> freshAtTheTop = new Stack<>();
        freshAtTheTop.push(apple);
        freshAtTheTop.push(bananas);
        freshAtTheTop.push(orange);

        System.out.println(freshAtTheTop.peek().equals(orange));
        System.out.println(freshAtTheTop.size());
        System.out.println(freshAtTheTop.pop().equals(orange));
        while(!freshAtTheTop.isEmpty()) {
            System.out.println(freshAtTheTop.pop());
        }
    }


}

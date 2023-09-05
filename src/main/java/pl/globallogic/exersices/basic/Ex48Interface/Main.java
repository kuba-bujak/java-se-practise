package pl.globallogic.exersices.basic.Ex48Interface;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Tim", 10, 15);
        Monster monster = new Monster("Werewolf", 20, 40);

        List<ISaveable> saveables = new ArrayList<>();
        saveables.add(player);
        saveables.add(monster);

        System.out.println("Original Player: " + player);
        System.out.println("Original Monster: " + monster);

        List<List<String>> savedData = new ArrayList<>();
        for (ISaveable saveable : saveables) {
            savedData.add(saveable.write());
        }

        for (int i = 0; i < saveables.size(); i++) {
            ISaveable saveable = saveables.get(i);
            List<String> data = savedData.get(i);
            saveable.read(data);
        }

        System.out.println("Restored Player: " + player);
        System.out.println("Restored Monster: " + monster);
    }
}

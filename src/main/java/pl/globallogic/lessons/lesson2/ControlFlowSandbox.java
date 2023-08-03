package pl.globallogic.lessons.lesson2;

import java.util.Objects;
import java.util.Scanner;

public class ControlFlowSandbox {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username");
        String userName = myObj.next();
        System.out.println("Enter number");
        int numberOfGreets = myObj.nextInt();
        String greeting = switch (userName.trim()) {
            case "Kuba", "Maja" -> "Cześć, " + userName;
            case "Chan", "Joe" -> "Hi, " + userName;
            default -> "Good Morning! " + userName;
        };

        for (int i = 0; i < numberOfGreets; i++) {
            System.out.println(greeting);
        }
//        if (Objects.equals(userName, "Kuba")) {
//            greeting = "Cześć, " + userName;
//        } else if (Objects.equals(userName, "Joe")) {
//            greeting = "Good Morning! " + userName;
//        }
//        else {
//            greeting = "Hello, " + userName;
//        }

        System.out.println(greeting);
    }
}

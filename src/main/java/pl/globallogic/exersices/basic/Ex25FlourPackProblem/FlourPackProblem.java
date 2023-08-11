package pl.globallogic.exersices.basic.Ex25FlourPackProblem;

public class FlourPackProblem {
    public static void main(String[] args) {
        System.out.println(canPack(1, 0, 4));   // Output: false
        System.out.println(canPack(1, 0, 5));   // Output: true
        System.out.println(canPack(0, 5, 4));   // Output: true
        System.out.println(canPack(2, 2, 11));  // Output: true
        System.out.println(canPack(-3, 2, 12)); // Output: false
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        int bigKilos = bigCount * 5;
        int totalKilos = bigKilos + smallCount;

        if (totalKilos < goal) {
            return false;
        }

        return goal % 5 <= smallCount;
    }
}


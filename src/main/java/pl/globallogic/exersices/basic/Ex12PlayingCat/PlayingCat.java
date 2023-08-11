package pl.globallogic.exersices.basic.Ex12PlayingCat;

public class PlayingCat {
    public static void main(String[] args) {
        System.out.println(isCatPlaying(true, 10));
        System.out.println(isCatPlaying(false, 36));
        System.out.println(isCatPlaying(false, 35));
    }

    private static boolean isCatPlaying(boolean summer, int temperature) {
        int lowerLimit = 25;
        int upperLimit = (summer) ? 45 : 35;

        return temperature >= lowerLimit && temperature <= upperLimit;
    }
}

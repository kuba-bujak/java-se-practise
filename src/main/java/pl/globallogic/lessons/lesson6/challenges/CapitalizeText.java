package pl.globallogic.lessons.lesson6.challenges;

public class CapitalizeText {
    public static void main(String[] args) {
        String targetText = "i love java programming";
        String expectedResult = "I Love Java Programming";
        System.out.println(expectedResult.contentEquals(process(targetText)));
    }

    private static StringBuilder process(String targetText) {
        String[] tokens = targetText.split(" ");
        StringBuilder result = new StringBuilder("");
        for (String token :
                tokens) {
            result.append(capitalize(token)).append(" ");
        }
        return result;
    }

    private static String capitalize(String token) {
        if (token.isEmpty()) return "";
        String firstLetterCapitalized = token.substring(0, 1).toUpperCase();
        String restOfTheToken = token.substring(1);
        return firstLetterCapitalized + restOfTheToken;
    }
}

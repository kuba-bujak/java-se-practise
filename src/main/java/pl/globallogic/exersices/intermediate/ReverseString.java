package pl.globallogic.exersices.intermediate;

public class ReverseString {
     public static void main(String[] args) {
        String source = "a2224fsd";
        System.out.println(source + " " + reverseRecursive(source));
        System.out.println(source + " " + reverseInplace(source));
    }

    private static String reverseInplace(final String source) {
         final char[] sourceAsChars = source.toCharArray();
         int left = 0;
         int right = source.length() - 1;
         while (left < right) {
             final char leftChar = sourceAsChars[left];
             final char rightChar = sourceAsChars[right];
             sourceAsChars[left] = rightChar;
             sourceAsChars[right] = leftChar;
             left++;
             right--;
         }
         return String.valueOf(sourceAsChars);
    }

    private static String reverseRecursive(String source) {
        if (source.length() <= 1) return source;
        char firstCh = source.charAt(0);
        String remainder = source.substring(1);
        return reverseRecursive(remainder) + firstCh;
    }
}

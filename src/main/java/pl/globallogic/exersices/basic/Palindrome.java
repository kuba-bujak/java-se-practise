package pl.globallogic.exersices.basic;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("dsahf"));
        System.out.println(isPalindrome("abddba"));
        System.out.println(isPalindrome("aaaa"));
        System.out.println(isPalindrome("abccba"));
        System.out.println(isPalindrome("aba"));
    }

    private static boolean isPalindrome(String target) {
        int i = 0, j = target.length() - 1;

        while (i < j) {
            if (target.charAt(i) != target.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

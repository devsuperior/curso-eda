public class Palindromo {
	public static boolean isPalindrome(String text) {
        return isPalindromeTailRecursive(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeTailRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return isPalindromeTailRecursive(text, start + 1, end - 1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("abccba"));
        System.out.println(isPalindrome("abcfba"));
    }
}

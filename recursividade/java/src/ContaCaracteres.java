public class ContaCaracteres {

	public static void main(String[] args) {
        System.out.println(charCount('b', "Batata para o bebê"));
    }

    public static int charCount(char ch, String text) {
        return charCountTailRecursive(Character.toLowerCase(ch), text.toLowerCase(), 0, 0);
    }

    private static int charCountTailRecursive(char ch, String text, int index, int count) {
        if (index >= text.length()) {
            return count;
        }

        int newCount = (text.charAt(index) == ch) ? count + 1 : count;
        return charCountTailRecursive(ch, text, index + 1, newCount);
    }
}

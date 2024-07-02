public class IsBalancedStack2 {
	public static boolean isBalanced(String text) {
        Stack2<Character> stack = new Stack2<>();
        for (char ch : text.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("(())()")); // true
        System.out.println(isBalanced("())("));   // false
    }
}

import java.util.Stack;

public class IsBalanced {
	public static boolean isBalanced(String text) {
        Stack<Character> stack = new Stack<>();
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

import java.util.Stack;

public class ValidParentheses {

	public static boolean validParentheses(String text) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : text.toCharArray()) {
			if (c == '(') {
				stack.push(')');				
			}
			else if (c == '{') {
				stack.push('}');				
			}
			else if (c == '[') {
				stack.push(']');				
			}
			else if (stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		System.out.println(validParentheses("()([]{})"));
		System.out.println(validParentheses("(){]{}"));
	}
}

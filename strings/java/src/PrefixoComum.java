import java.util.Arrays;

public class PrefixoComum {

	public static void main(String[] args) {
		System.out.println("\"" + longestCommonPrefix(new String[] { "flower", "flow", "flight" }) + "\"");
		System.out.println("\"" + longestCommonPrefix(new String[] { "dog","racecar","car" }) + "\"");
	}

	public static String longestCommonPrefix(String[] v) {

		StringBuilder result = new StringBuilder();

		Arrays.sort(v);
		String first = v[0];
		String last = v[v.length - 1];

		for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
			if (first.charAt(i) != last.charAt(i)) {
				return result.toString();
			}
			result.append(first.charAt(i));
		}

		return result.toString();
	}
}

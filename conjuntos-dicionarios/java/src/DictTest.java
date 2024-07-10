import java.util.HashMap;
import java.util.Map;

public class DictTest {

	public static void main(String[] args) {
		Map<String, String> cookies = new HashMap<>();
		
		cookies.put("user", "maria34");
		cookies.put("email", "ana@gmail.com");
		cookies.put("email", "maria@gmail.com");
		cookies.put("last-login", "2024-07-04T21:42:40.353283800Z");

		System.out.println("Values:");
		for (String value : cookies.values()) {
			System.out.println(value);
		}
		
		System.out.println("\nKeys & values:");
		for (String key : cookies.keySet()) {
			System.out.println(key + ": " + cookies.get(key));
		}
		
		System.out.println("\nIs empty: " + cookies.isEmpty());
		System.out.println("Size: " + cookies.size());
		
		System.out.println("\nContains 'email': " + cookies.containsKey("email"));
		String obj = cookies.remove("email");
		System.out.println("Remove: " + obj);

		System.out.println("\nContains 'email': " + cookies.containsKey("email"));
		obj = cookies.remove("email");
		System.out.println("Remove: " + obj);
	}
}

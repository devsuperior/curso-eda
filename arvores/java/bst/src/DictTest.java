import bst.BinarySearchTreeMap;

public class DictTest {

	public static void main(String[] args) {
		BinarySearchTreeMap<String, String> cookies = new BinarySearchTreeMap<>();
		
		cookies.put("user", "maria34");
		cookies.put("email", "ana@gmail.com");
		cookies.put("email", "maria@gmail.com");
		cookies.put("last-login", "2024-07-04T21:42:40.353283800Z");
		
		System.out.println("Values:");
		for (String value : cookies.values()) {
			System.out.println(value);
		}
		
		System.out.println("\nKeys & values:");
		for (String key : cookies.keys()) {
			System.out.println(key + ": " + cookies.get(key));
		}
		
		System.out.println("\ntoString:");
		System.out.println(cookies);
		
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

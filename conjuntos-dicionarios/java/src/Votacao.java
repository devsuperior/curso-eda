import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Votacao {

	public static List<String> counting(List<String> votes) {

		Map<String, Integer> dict = new HashMap<>();

		for (String s : votes) {
			String name = s.split(",")[0];
			Integer count = Integer.parseInt(s.split(",")[1]);
			if (!dict.containsKey(name)) {
				dict.put(name, count);
			} else {
				dict.put(name, count + dict.get(name));
			}
		}

		List<String> result = new ArrayList<>();
		for (String key : dict.keySet()) {
			result.add(key + "," + dict.get(key));
		}

		return result;
	}

	public static void main(String[] args) {
		List<String> input = Arrays.asList(
			"Alex Blue,15", 
			"Maria Green,22", 
			"Bob Brown,21", 
			"Alex Blue,30",
			"Bob Brown,15", 
			"Maria Green,27", 
			"Maria Green,22", 
			"Bob Brown,25", 
			"Alex Blue,31"
			);

		List<String> result = counting(input);
		for (String s : result) {
			System.out.println(s);
		}
	}
}

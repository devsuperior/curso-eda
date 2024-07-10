import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transacoes {
	public static void main(String[] args) {
		System.out.println(invalidTransactions(new String[] { "alice,20,800,mtv", "alice,50,100,beijing" }));
		System.out.println(invalidTransactions(new String[] { "alice,20,800,mtv", "alice,50,1200,mtv" }));
		System.out.println(invalidTransactions(new String[] { "alice,20,800,mtv", "bob,50,1200,mtv" }));
	}

	public static List<String> invalidTransactions(String[] transactions) {
		class Transaction {
			String name;
			int time;
			int money;
			String city;
			String csv;

			public Transaction(String csv) {
				String[] parts = csv.split(",");
				name = parts[0];
				time = Integer.parseInt(parts[1]);
				money = Integer.parseInt(parts[2]);
				city = parts[3];
				this.csv = csv;
			}
		}

		Map<String, List<Transaction>> dict = new HashMap<>();
		List<Transaction> allTransactions = new ArrayList<>();

		List<String> result = new ArrayList<>();

		for (String s : transactions) {

			Transaction t = new Transaction(s);

			allTransactions.add(t);

			if (dict.containsKey(t.name)) {
				dict.get(t.name).add(t);
			} 
			else {
				dict.put(t.name, new ArrayList<>(Arrays.asList(t)));
			}
		}

		for (Transaction t : allTransactions) {
			if (t.money > 1000) {
				result.add(t.csv);
			} 
			else {
				for (Transaction t2 : dict.get(t.name)) {
					if (Math.abs(t.time - t2.time) <= 60 && !t.city.equals(t2.city)) {
						result.add(t.csv);
						break;
					}
				}
			}
		}

		return result;
	}
}

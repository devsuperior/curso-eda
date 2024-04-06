import java.util.ArrayList;
import java.util.List;

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

			public Transaction(String csv) {
				String[] parts = csv.split(",");
				name = parts[0];
				time = Integer.parseInt(parts[1]);
				money = Integer.parseInt(parts[2]);
				city = parts[3];
			}
		}

		List<String> result = new ArrayList<>();
		boolean[] invalidArray = new boolean[transactions.length];

		for (int i = 0; i < transactions.length; i++) {

			Transaction ti = new Transaction(transactions[i]);

			if (ti.money > 1000) {
				invalidArray[i] = true;
			}

			for (int j = i + 1; j < transactions.length; j++) {

				Transaction tj = new Transaction(transactions[j]);

				if (ti.name.equals(tj.name) && Math.abs(ti.time - tj.time) <= 60 && !ti.city.equals(tj.city)) {
					invalidArray[i] = true;
					invalidArray[j] = true;
				}
			}
		}

		for (int i = 0; i < transactions.length; i++) {
			if (invalidArray[i])
				result.add(transactions[i]);
		}
		return result;
	}
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Rank {
	public String word;
	public Integer count;

	public Rank(String word, Integer count) {
		this.word = word;
		this.count = count;
	}
}

public class WordCount {

	public static String normalize(String text) {
		String noPunctuation = text.replaceAll("[\\p{Punct}]", " ");
		return noPunctuation.replaceAll("\\s+", " ").trim().toLowerCase();
	}

	public static List<Rank> wordCount(String text) {

		Map<String, Integer> dict = new HashMap<>();

		String[] words = normalize(text).split(" ");

		for (String word : words) {
			if (!dict.containsKey(word)) {
				dict.put(word, 1);
			} else {
				dict.put(word, 1 + dict.get(word));
			}
		}

		List<Rank> ranks = new ArrayList<>();
		for (String word : dict.keySet()) {
			ranks.add(new Rank(word, dict.get(word)));
		}

		ranks.sort((a, b) -> {
			int countComparison = b.count.compareTo(a.count);
            if (countComparison != 0) {
                return countComparison;
            }
            return a.word.compareTo(b.word);
		});

		return ranks;
	}

	public static void main(String[] args) {
		String inputText = """
			O vento sussurra sons entre as árvores, sons que fazem animais 
			correrem. A floresta e a natureza vibram com segredos e sons.
			""";
		
		List<Rank> result = wordCount(inputText);
		for (Rank obj : result) {
			System.out.println(obj.word + ": " + obj.count);
		}
	}
}

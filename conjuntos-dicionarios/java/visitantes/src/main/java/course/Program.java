package course;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Program {

	public static int total(List<String> visitors) {

		Set<String> uniqueVisitors = new HashSet<>();

		for (String visitor : visitors) {
			String name = visitor.split(",")[0];
			uniqueVisitors.add(name);
		}

		return uniqueVisitors.size();
	}

	public static int totalNaive(List<String> visitors) {

		List<String> uniqueVisitors = new ArrayList<>();

		for (String visitor : visitors) {
			String name = visitor.split(",")[0];
			if (!uniqueVisitors.contains(name)) {
				uniqueVisitors.add(name);
			}
		}

		return uniqueVisitors.size();
	}

	public static void main(String[] args) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		File jsonFile = new File("c:/temp/visitantes-input.json");
		List<String> visitors = objectMapper.readValue(jsonFile, new TypeReference<List<String>>() {});

		Instant start1 = Instant.now();
		int result1 = total(visitors);
		Instant end1 = Instant.now();
		double time1 = Duration.between(start1, end1).toMillis() / 1000.0;
		System.out.printf("RESULT = %d. Time = %.3fs\n", result1, time1);

		Instant start2 = Instant.now();
		int result2 = totalNaive(visitors);
		Instant end2 = Instant.now();
		double time2 = Duration.between(start2, end2).toMillis() / 1000.0;
		System.out.printf("RESULT = %d. Time = %.3fs%n", result2, time2);

		double quo = time2 / time1;
		System.out.printf("Segundo algoritmo %.1f vezes mais lento%n", quo);
	}
}

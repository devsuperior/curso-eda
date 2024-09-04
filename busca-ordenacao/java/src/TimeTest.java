import java.time.Duration;
import java.time.Instant;

public class TimeTest {

	static void myFunction() {
		double x = 10;
		for (long i = 0; i < 100000000L; i++) {
			x = -x;
		}
	}
	
	public static void main(String[] args) {
		Instant start = Instant.now();
		myFunction();
		Instant end = Instant.now();
		long time = Duration.between(start, end).toMillis();
		System.out.printf("Duration: %dms\n", time);
	}
}

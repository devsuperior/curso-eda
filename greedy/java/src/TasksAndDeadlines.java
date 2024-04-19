import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TasksAndDeadlines {
	public static void main(String[] args) {
		System.out.println(maximumReward(3, Arrays.asList(
	            new SimpleEntry<>(6, 10),
	            new SimpleEntry<>(8, 15),
	            new SimpleEntry<>(5, 12)
	    )));
		
		System.out.println(maximumReward(10, Arrays.asList(
	            new SimpleEntry<>(3, 47),
	            new SimpleEntry<>(5, 11),
	            new SimpleEntry<>(1, 70),
	            new SimpleEntry<>(2, 100),
	            new SimpleEntry<>(2, 41),
	            new SimpleEntry<>(2, 66),
	            new SimpleEntry<>(5, 80),
	            new SimpleEntry<>(4, 84),
	            new SimpleEntry<>(5, 81),
	            new SimpleEntry<>(5, 40)
	    )));
		
		System.out.println(maximumReward(10, Arrays.asList(
	            new SimpleEntry<>(80, 55),
	            new SimpleEntry<>(29, 46),
	            new SimpleEntry<>(58, 5),
	            new SimpleEntry<>(92, 80),
	            new SimpleEntry<>(62, 68),
	            new SimpleEntry<>(64, 20),
	            new SimpleEntry<>(78, 56),
	            new SimpleEntry<>(41, 66),
	            new SimpleEntry<>(62, 44),
	            new SimpleEntry<>(32, 80)
	    )));
	}

    public static long maximumReward(int n, List<SimpleEntry<Integer, Integer>> tasks) {
        // Ordena as tarefas pelo primeiro elemento do par
        Collections.sort(tasks, (a, b) -> a.getKey().compareTo(b.getKey()));

        long reward = 0, time = 0;
        for (SimpleEntry<Integer, Integer> task : tasks) {
            time += task.getKey();
            reward += (task.getValue() - time);
        }

        return reward;
    }
}


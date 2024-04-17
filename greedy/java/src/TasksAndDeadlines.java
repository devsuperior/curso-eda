import java.util.ArrayList;
import java.util.Collections;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

public long maximumReward(int n, List<SimpleEntry<Integer, Integer>> tasks) {
    // Ordena as tarefas pelo primeiro elemento do par
    Collections.sort(tasks, (a, b) -> a.getKey().compareTo(b.getKey()));

    long reward = 0, time = 0;
    for (SimpleEntry<Integer, Integer> task : tasks) {
        time += task.getKey();
        reward += (task.getValue() - time);
    }

    return reward;
}
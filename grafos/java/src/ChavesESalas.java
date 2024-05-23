import java.util.List;
import java.util.Stack;

public class ChavesESalas {

    public static boolean visitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            for (int neighbour : rooms.get(current)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    stack.push(neighbour);
                }
            }
        }

        // Se alguma sala não foi visitada, retorna False
        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Exemplo 1
        List<List<Integer>> rooms1 = List.of(List.of(1), List.of(2), List.of(3), List.of());
        System.out.println(visitAllRooms(rooms1));

        // Exemplo 2
        List<List<Integer>> rooms2 = List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0));
        System.out.println(visitAllRooms(rooms2));
    }
}

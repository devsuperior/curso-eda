import java.util.ArrayList;
import java.util.List;

public class Requisitos {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            graph[prereq].add(course);
        }

        int[] visited = new int[numCourses];

        // Perform DFS on each course
        for (int course = 0; course < numCourses; course++) {
            if (visited[course] == 0) { // Unvisited node
                if (!DFS(course, graph, visited)) {
                    return false;
                }
            }
        }

        return true;
    }

    // DFS function
    private static boolean DFS(int node, List<Integer>[] graph, int[] visited) {
        if (visited[node] == 1) {
            // Node is being visited, hence a cycle is detected
            return false;
        }
        if (visited[node] == 2) {
            // Node has been completely visited
            return true;
        }

        // Mark the node as visiting
        visited[node] = 1;

        // Visit all the neighbors
        for (int neighbor : graph[node]) {
            if (!DFS(neighbor, graph, visited)) {
                return false;
            }
        }

        // Mark the node as completely visited
        visited[node] = 2;
        return true;
    }

    public static void main(String[] args) {
        // Exemplo 1
        int numCourses1 = 2;
        int[][] prerequisites1 = new int[][] { { 0, 1 } };
        System.out.println(canFinish(numCourses1, prerequisites1));

        // Exemplo 2
        int numCourses2 = 2;
        int[][] prerequisites2 = new int[][] { { 0, 1 }, { 1, 0 } };
        System.out.println(canFinish(numCourses2, prerequisites2));
    }
}

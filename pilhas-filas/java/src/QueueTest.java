import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        System.out.println("queue.size(): " + queue.size());
        System.out.println("queue.isEmpty(): " + queue.isEmpty());

        queue.add("Maria");
        queue.add("Joao");
        queue.add("Ana");
        System.out.println("Adicionados: Maria, Joao, Ana");

        System.out.println("queue.size(): " + queue.size());
        System.out.println("queue.isEmpty(): " + queue.isEmpty());
        System.out.println("queue.peek(): " + queue.peek());

        System.out.println("Itens:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll()); // Usando poll ao invés de remove para evitar exceção se a fila estiver vazia
        }
    }
}

public class Queue1Test {
    public static void main(String[] args) {
        Queue1<String> queue = new Queue1<>();

        System.out.println("queue.count(): " + queue.count());
        System.out.println("queue.isEmpty(): " + queue.isEmpty());

        queue.add("Maria");
        queue.add("Joao");
        queue.add("Ana");
        System.out.println("Adicionados: Maria, Joao, Ana");

        System.out.println("queue.count(): " + queue.count());
        System.out.println("queue.isEmpty(): " + queue.isEmpty());
        System.out.println("queue.peek(): " + queue.peek());

        System.out.println("Itens:");
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}

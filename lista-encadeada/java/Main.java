package lists.linkedlist;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.addAtStart(10);

        System.out.println("Tamanho da lista = " + list.getSize());
        System.out.println(list);

        list.addAtStart(20);
        System.out.println(list);

        list.addAtEnd(30);
        System.out.println(list);

        list.addAtEnd(40);
        System.out.println(list);

        list.addAtPosition(1, 50);
        System.out.println(list);

        System.out.println("Elemento 50 está contido? " + list.contains(50));
        System.out.println("Elemento -4 está contido? " + list.contains(-4));

        list.remove(30);
        System.out.println(list);

        list.remove(100);
        System.out.println(list);

        list.removeAtPosition(2);
        System.out.println(list);

        list.removeAtPosition(-1);
        System.out.println(list);
    }
    
}

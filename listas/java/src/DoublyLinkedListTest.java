public class DoublyLinkedListTest {

	public static void main(String[] args) {

		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		
		// 1 - Add at start
		list.addAtStart(2);
		list.addAtStart(9);
		printArray(list.toArray());

		list.clear();

		// 2 - Add at end
		list.addAtEnd(2);
		list.addAtEnd(4);
		list.addAtEnd(8);
		list.addAtEnd(32);
		list.addAtEnd(128);
		printArray(list.toArray());

		// 3 - Obter o tamanho da lista
		System.out.println("Tamanho da lista igual a: " + list.getSize());

		// 4 - Add at position
		list.addAtPosition(3, 16);
		System.out.println("Adicionado 16 à posição 3:");
		printArray(list.toArray());

		System.out.println("Adicionado 64 à posição 5:");
		list.addAtPosition(5, 64);
		printArray(list.toArray());

		// 5 - Remove head
		list.removeHead();
		System.out.println("Removido primeiro elemento:");
		printArray(list.toArray());

		// 6 - Remove tail
		list.removeTail();
		System.out.println("Removido último elemento:");
		printArray(list.toArray());

		// 7 - Remove at position
		list.removeAtPosition(4);
		System.out.println("Removido elemento da posição 4:");
		printArray(list.toArray());

		// 8 - Remove
		list.remove(32);
		System.out.println("Removido elemento 32:");
		printArray(list.toArray());

		list.remove(4);
		System.out.println("Removido elemento 4:");
		printArray(list.toArray());

		// 9 - Reverse list
		list.reverse();
		System.out.println("Lista reversa:");
		printArray(list.toArray());		
	}

    public static void printArray(Object[] items) {
    	System.out.print("[");
    	for (int i = 0; i < items.length - 1; i++) {
            System.out.print(items[i] + ", ");
    	}
    	if (items.length > 0) {
    		System.out.print(items[items.length - 1]);
    	}
    	System.out.println("]");
    }
}

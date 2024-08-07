import java.util.Arrays;
import java.util.List;

import bst.BinarySearchTreeSet;

public class AddRemoveTest {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(52, 17, 67, 11, 33, 55, 83, 14, 31, 46, 23, 26);
		BinarySearchTreeSet<Integer> tree = new BinarySearchTreeSet<>(list);

		System.out.println(tree);

		System.out.println("\nOriginal:");
		System.out.println(tree.toStringFormat());

		tree.add(58);
		
		System.out.println("\nAdd test:");
		System.out.println(tree.toStringFormat());

		tree.remove(31);
		
		System.out.println("\nRemove test:");
		System.out.println(tree.toStringFormat());
	}
}

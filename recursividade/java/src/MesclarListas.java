import java.util.ArrayList;
import java.util.List;

public class MesclarListas {
	public static void main(String[] args) {
        List<Integer> list1 = List.of(10, 20, 30);
        List<Integer> list2 = List.of(5, 8, 7);
        System.out.println(mergeLists(list1, list2));

        List<String> list3 = List.of("ana", "maria");
        List<String> list4 = List.of("joao", "bob", "alex", "leo");
        System.out.println(mergeLists(list3, list4));
    }

    public static <T> List<T> mergeLists(List<T> a, List<T> b) {
        if (a.isEmpty()) {
            return b;
        }
        if (b.isEmpty()) {
            return a;
        }

        T head1 = a.get(0);
        List<T> tail1 = a.subList(1, a.size());

        T head2 = b.get(0);
        List<T> tail2 = b.subList(1, b.size());

        List<T> result = new ArrayList<>();
        result.add(head1);
        result.add(head2);
        result.addAll(mergeLists(tail1, tail2));
        return result;
    }
}

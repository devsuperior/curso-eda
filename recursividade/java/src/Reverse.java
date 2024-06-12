import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reverse {

	public static void main(String[] args) {
        List<String> list = Arrays.asList("azul", "verde", "preto", "rosa");
        List<String> result = reverse(list);
        System.out.println(result);
    }

    public static <T> List<T> reverse(List<T> list) {
        if (list.size() <= 1) {
            return new ArrayList<>(list);
        }
        
        T head = list.get(0);
        List<T> tail = list.subList(1, list.size());
        
        List<T> newList = reverse(tail);
        newList.add(head);
        
        return newList;
    }
}

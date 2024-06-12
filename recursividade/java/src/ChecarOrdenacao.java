import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChecarOrdenacao {
	
	public static boolean isSorted(List<Double> list) {
        if (list.size() <= 1) {
            return true;
        }

        if (list.get(0) > list.get(1)) {
            return false;
        }

        List<Double> tail = list.subList(1, list.size());
        return isSorted(tail);
    }

    public static void main(String[] args) {
        System.out.println(isSorted(new ArrayList<>()));
        System.out.println(isSorted(Arrays.asList(15.0, 20.0, 22.0, 31.0, 40.0)));
        System.out.println(isSorted(Arrays.asList(15.0, 20.0, 22.0, 21.0, 40.0)));
    }
}

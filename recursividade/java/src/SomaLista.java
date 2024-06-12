import java.util.Arrays;
import java.util.List;

public class SomaLista {
	public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(4.0, 5.0, 3.0);
        double result = sumList(numbers);
        System.out.println("RESULTADO = " + result);
    }

    public static double sumList(List<Double> list) {
        if (list.isEmpty()) {
            return 0;
        }

        double head = list.get(0);
        List<Double> tail = list.subList(1, list.size());

        return head + sumList(tail);
    }
}

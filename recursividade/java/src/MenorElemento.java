import java.util.ArrayList;
import java.util.List;

public class MenorElemento {
	public static double minor(List<Double> list) {
        if (list.size() == 1) {
            return list.get(0);
        }

        double head = list.get(0);
        List<Double> tail = list.subList(1, list.size());

        double tailMinor = minor(tail);

        return (head < tailMinor) ? head : tailMinor;
    }

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>(List.of(10.0, 15.0, 20.0, 8.0, 30.0, 17.0));
        double result = minor(list);
        System.out.println("MENOR = " + result);
    }
}

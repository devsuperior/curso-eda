public class Potencia {
	public static void main(String[] args) {
        System.out.println(power(5, 0));
        System.out.println(power(3, 4));
    }

    public static int power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        return a * power(a, b - 1);
    }
}

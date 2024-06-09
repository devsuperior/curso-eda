package aula;

public class Fatorial {

    public static void main(String[] args) {
        int result = factorial(4);
        System.out.println("RESULTADO: " + result);
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}

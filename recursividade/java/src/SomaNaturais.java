public class SomaNaturais {

    public static void main(String[] args) {
        int result = sum(4);
        System.out.println("RESULTADO: " + result);
    }

    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }
}

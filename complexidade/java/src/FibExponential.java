public class FibExponential {
	
	public static int fibExponential(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibExponential(n - 1) + fibExponential(n - 2);
    }

    public static void main(String[] args) {
        int result = fibExponential(40);
        System.out.println(result);
    }
}

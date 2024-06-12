public class SomaNaturais {

    public static void main(String[] args) {
        int result = sumNaturals(4);
        System.out.println("RESULTADO: " + result);
    }

    public static int sumNaturals(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumNaturals(n - 1);
    }
}

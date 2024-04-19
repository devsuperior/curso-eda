import java.util.Arrays;

public class GarrafasOasis {
	public static void main(String[] args) {
		System.out.println(maximumBottles(5, 10, new int[] {8, 5, 4, 3, 2}));
		System.out.println(maximumBottles(3, 10, new int[] {6, 3, 2}));
	}
	
    public static int maximumBottles(int n, int x, int[] v) {
        Arrays.sort(v);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            // Se houver água suficiente para encher uma garrafa completamente
            if (x - v[i] >= 0) {
                x -= v[i];
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}

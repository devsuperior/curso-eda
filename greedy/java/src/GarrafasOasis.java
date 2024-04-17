import java.util.Arrays;

public class GarrafasOasis {
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

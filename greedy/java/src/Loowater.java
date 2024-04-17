import java.util.Arrays;

public class Loowater {
    public static int minimumCoins(int n, int[] heads, int m, int[] knights) {
        Arrays.sort(heads);
        Arrays.sort(knights);

        int k = 0, coins = 0;
        boolean saved = true;
        for (int i = 0; i < n; i++) {
            // Seleciona cavaleiro k para cortar cabeça i
            while (k < m && knights[k] < heads[i]) {
                k++;
            }

            if (k < m) {
                coins += knights[k];
                k++;
            } else {
                saved = false;
                break;
            }
        }

        if (!saved) return -1;
        else return coins;
    }
}

import java.util.Arrays;

class Solution {
    public int minimumRooms(int[] start, int[] end, int n) {
        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0, j = 0, ans = 0, rooms = 0;

        // Aloca salas conforme necessário e mantém o máximo que precisamos
        while (i < n || j < n) {
            if (i < n && (j == n || start[i] <= end[j])) {
                i++;
                rooms++;
            } else {
                j++;
                rooms--;
            }

            ans = Math.max(ans, rooms);
        }

        return ans;
    }
}
import java.util.Arrays;

class MinimumRooms {
	public static void main(String[] args) {
		System.out.println(minimumRooms(
							new int[] {900, 940, 950, 1100, 1500, 1800},
							new int[] {910, 1200, 1120, 1130, 1900, 2000},
							6));
		
		System.out.println(minimumRooms(
				new int[] {900, 1100, 1235},
				new int[] {1000, 1200, 1240},
				3));
	}
	
    public static int minimumRooms(int[] start, int[] end, int n) {
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
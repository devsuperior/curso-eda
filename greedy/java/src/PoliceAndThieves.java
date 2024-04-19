import java.util.ArrayList;
import java.util.List;

public class PoliceAndThieves {
	public static void main(String[] args) {
		System.out.println(catchThieves(new char[] {'P', 'T', 'T', 'P', 'T'}, 5, 1));
		System.out.println(catchThieves(new char[] {'T', 'T', 'P', 'P', 'T', 'P'}, 6, 2));
	}
	
    public static int catchThieves(char[] arr, int n, int k) {
        List<Integer> thievesIndex = new ArrayList<>();
        List<Integer> policeIndex = new ArrayList<>();
        
        // Obtém os índices para ladrões e policiais
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'T')
                thievesIndex.add(i);
            else if (arr[i] == 'P')
                policeIndex.add(i);
        }
        
        int t = 0, p = 0, ans = 0;
        // Enquanto houver ladrões ou policiais restantes
        while (t < thievesIndex.size() && p < policeIndex.size()) {
            
            int dist = Math.abs(thievesIndex.get(t) - policeIndex.get(p));
            if (dist <= k) {
                ans++;
                t++;
                p++;
            }
            else if (thievesIndex.get(t) < policeIndex.get(p)) {
                t++;
            }
            else {
                p++;
            }
        }
        
        return ans;
    }
}

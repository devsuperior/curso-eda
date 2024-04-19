import java.util.Arrays;

class Cookies {
	public static void main(String[] args) {
		System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[] {1, 1}));
		System.out.println(findContentChildren(new int[]{1, 2}, new int[] {2, 3}));
	}
	
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int j = 0, ans = 0;
        // for each child
        for(int i = 0; i < g.length; i++) {
            // try to find a cookie that fits
            while(j < s.length && s[j] < g[i]){
                j++;
            }
            // if there's no more cookies
            if(j == s.length)
                break;
            else {
                ans++;
                j++;
            }
        }

        return ans;   
    }
}
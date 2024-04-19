public class Scarecrow {
	public static void main(String[] args) {
		System.out.println(minimumScarecrows(3, ".#."));
		System.out.println(minimumScarecrows(11, "...##....##"));
		System.out.println(minimumScarecrows(2, "##"));
	}
	
    public static int minimumScarecrows(int n, String field) {
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(field.charAt(i) == '.'){
                i += 2;
                ans++;
            }
        }
        return ans;
    }
}

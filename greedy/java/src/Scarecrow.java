public class Solution {
    int minimumScarecrows(int n, String field) {
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

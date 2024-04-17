class Solution{
    static String findLargest(int N, int S){
        String ans = "";
        
        // if we put the maximum digits we still can't make S
        if(9 * N < S || (S == 0 && N > 1))
            return "-1";
        
        char digit;
        while(S > 0) {
            // greedily fit as many '9' digits as we can
            if(S - 9 >= 0) {
                S -= 9;
                digit = '9';
            }
            // fit the rest of the sum
            else{
                digit = (char)S;
                digit += '0';
                S = 0;
            }
            ans += digit;
        }
        
        // reach N digits if we haven't
        while(ans.length() < N){
            ans += '0';
        }
        
        return ans;
    }
}
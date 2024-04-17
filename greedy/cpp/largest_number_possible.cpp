#include <bits/stdc++.h>
using namespace std;

class Solution{
public:
    string findLargest(int N, int S){
        string ans = "";
        
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
                digit = '0' + S;
                S = 0;
            }
            ans += digit;
        }
        
        // reach N digits if we haven't
        while(ans.size() < N){
            ans += '0';
        }
        
        return ans;
    }
};

int main(){
    int n, s;
    cin >> n >> s;

    Solution solve;
    cout << solve.findLargest(n, s) << endl;
}
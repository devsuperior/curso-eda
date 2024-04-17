#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minimumScarecrows(int n, string field) {
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(field[i] == '.'){
                i += 2;
                ans++;
            }
        }
        return ans;
    }
};

int main(){
    int t;
    cin >> t;

    int n;
    string s;
    Solution solve;
    for(int i = 1; i <= t; i++){
        cin >> n >> s;
        cout << "Case " << i << ": " << solve.minimumScarecrows(n, s) << endl;
    }
}
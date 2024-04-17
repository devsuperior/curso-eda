#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());

        int j = 0, ans = 0;
        // for each child
        for(int i = 0; i < g.size(); i++) {
            // try to find a cookie that fits
            while(j < s.size() && s[j] < g[i]){
                j++;
            }
            // if there's no more cookies
            if(j == s.size())
                break;
            else {
                ans++;
                j++;
            }
        }

        return ans;
    }
};

int main() {
    // read children
    int n_children;
    cin >> n_children;
    vector<int> g(n_children);
    for(int i = 0; i < n_children; i++) {
        cin >> g[i];
    }

    // read cookies
    int n_cookies;
    cin >> n_cookies;
    vector<int> s(n_cookies);
    for(int i = 0; i < n_cookies; i++) {
        cin >> s[i];
    }

    Solution solve;
    cout << solve.findContentChildren(g, s) << endl;
}
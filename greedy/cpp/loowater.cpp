#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minimumCoins(int n, vector<int> &heads, int m, vector<int> &knights) {
        sort(heads.begin(), heads.end());
        sort(knights.begin(), knights.end());

        int k = 0, coins = 0;
        bool saved = true;
        for(int i = 0; i < n; i++){
            // seleciona cavaleiro k para cortar cabeca i
            while(knights[k] < heads[i] && k < m){
                k++;
            }

            coins += knights[k];
            
            if(k < m) k++;
            else{
                saved = false;
                break;
            }
        }

        if(!saved) return -1;
        else return coins;
    }
};

int main(){
    int n, m;
    
    while(cin >> n >> m && n+m != 0){
        vector<int> heads(n), knights(m);

        for(int i = 0; i < n; i++)
            cin >> heads[i];
        for(int i = 0; i < m; i++)
            cin >> knights[i];

        Solution solve;
        int ans = solve.minimumCoins(n, heads, m, knights);
        
        if(ans == -1)
            cout << "Loowater is doomed!\n";
        else
            cout << ans << endl;
    }
}
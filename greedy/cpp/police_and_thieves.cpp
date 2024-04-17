#include <bits/stdc++.h>
using namespace std;

class Solution{
    public:
    int catchThieves(char arr[], int n, int k) 
    {
        vector<int> thieves_index, police_index;
        
        // get the indices for thieves and police
        for(int i = 0; i < n; i++){
            if(arr[i] == 'T')
                thieves_index.push_back(i);
            else if(arr[i] == 'P')
                police_index.push_back(i);
        }
        
        int t = 0, p = 0, ans = 0;
        // while there's thieves or police left
        while(t < thieves_index.size() && p < police_index.size()){
            
            int dist = abs(thieves_index[t] - police_index[p]);
            if(dist <= k) {
                ans++;
                t++;
                p++;
            }
            else if(thieves_index[t] < police_index[p]){
                t++;
            }
            else{
                p++;
            }
        }
        
        return ans;
    }
};

int main() {
    int n, k;
    cin >> n >> k;

    char arr[n];
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    Solution s;
    cout << s.catchThieves(arr, n, k);
}


/*
    - Erros que podem ocorrer: iterar em p e t em vez de no índice police_index[p]
    - Não verificar que ponteiro está andando primeiro
    - Não fazer distância absoluta
*/
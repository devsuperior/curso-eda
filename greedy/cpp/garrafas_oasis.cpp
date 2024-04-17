#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumBottles(int n, int x, vector<int>& v) {
        sort(v.begin(), v.end());

		int ans = 0;
		for(int i = 0; i < n; i++){
			// if there's water left to fill a full bottle
			if(x - v[i] >= 0){
				x -= v[i];
				ans++;
			}
			else
				break;
		}
        return ans;
    }
};

int main() {
	int t;

	cin >> t;

	int n, x;
	Solution solve;
	while(t--){
		cin >> n >> x;

		vector<int> v(n);

		for(int i = 0; i < n; i++)
			cin >> v[i];

		cout << solve.maximumBottles(n, x, v) << endl;
	}
}
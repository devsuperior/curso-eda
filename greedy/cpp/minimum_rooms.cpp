#include <bits/stdc++.h>
using namespace std;

class Solution{
    public:
    int minimumRooms(int start[], int end[], int n)
    {
    	vector<pair<int, string>> transactions;
    	
    	// make a vector ordered by time containing all transactions
    	for(int i = 0; i < n; i++){
    	    transactions.push_back({start[i], "start"});
    	    transactions.push_back({end[i], "end"});
    	}
    	
    	sort(transactions.begin(), transactions.end());
    	
    	// allocate rooms as need them, and keep the maximum we needed
    	int rooms = 0, ans = 0;
    	for(int i = 0; i < transactions.size(); i++){
    	    if(transactions[i].second == "start") {
    	        rooms++;
    	    }
    	    else if(transactions[i].second == "end"){
    	        rooms--;
    	    }
    	    ans = max(ans, rooms);
    	}
    	

    	return ans;
    }
};

int main() {
    int n;
	cin >> n;

	int start[n], end[n];
	for(int i, a, b; i < n; i++) {
		cin >> start[i] >> end[i];
	}

	Solution solve;
	cout << solve.minimumRooms(start, end, n) << endl;
}
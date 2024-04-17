#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        int l = 0, r = people.size() - 1;

        sort(people.begin(), people.end());

        int boats = 0;
        while(l <= r) {
            // fit two people in one boat
            if(people[r] + people[l] <= limit){
                l++;
                r--;
            }
            // only fit the heaviest
            else if(people[r] <= limit){
                r--;
            }
            else{
                l++;
            }
            boats++;
        }

        return boats;
    }
};

int main() {
    int n, limit;
    cin >> n >> limit;

    vector<int> people;
    people.resize(n);
    for(int i = 0; i < n; i++){
        cin >> people[i];
    }

    Solution s;
    cout << s.numRescueBoats(people, limit) << endl;
}
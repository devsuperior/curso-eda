#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long int maximumReward(int n, vector<pair<int, int>> &tasks)
    {
        sort(tasks.begin(), tasks.end());

        long long int reward = 0, time = 0;
        for(int i = 0; i < tasks.size(); i++){
            time += tasks[i].first;
            reward += (tasks[i].second - time);
        }

        return reward;
    }
};

int main(){
    int n;
    cin >> n;

    vector<pair<int, int>> tasks;
    int duration, deadline;
    for(int i = 0; i < n; i++) {
        cin >> duration >> deadline;
        tasks.push_back({duration, deadline});
    }

    Solution solve;
    cout << solve.maximumReward(n, tasks) << endl;
}
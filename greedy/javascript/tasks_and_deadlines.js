/**
 * @param {number} n
 * @return {number}
 */
var maximumReward = function(n, tasks) {
    tasks.sort((a, b) => a.first - b.first);
    
    let reward = 0, time = 0;
    for(let i = 0; i < tasks.length; i++){
        time += tasks[i].first;
        reward += (tasks[i].second - time);
    }

    return reward;
}

tasks1 = [
    {first: 6, second: 10},
    {first: 8, second: 15},
    {first: 5, second: 12}
]

console.log(maximumReward(3, tasks1))

tasks2 = [
    {first: 3, second: 47},
    {first: 5, second: 11},
    {first: 1, second: 70},
    {first: 2, second: 100},
    {first: 2, second: 41},
    {first: 2, second: 66},
    {first: 5, second: 80},
    {first: 4, second: 84},
    {first: 5, second: 81},
    {first: 5, second: 40}
]

console.log(maximumReward(10, tasks2))

tasks3 = [
    {first: 80, second: 55},
    {first: 29, second: 46},
    {first: 58, second: 5},
    {first: 92, second: 80},
    {first: 62, second: 68},
    {first: 64, second: 20},
    {first: 78, second: 56},
    {first: 41, second: 66},
    {first: 62, second: 44},
    {first: 32, second: 80}
]

console.log(maximumReward(10, tasks3))

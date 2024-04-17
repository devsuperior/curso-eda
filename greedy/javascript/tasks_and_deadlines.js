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
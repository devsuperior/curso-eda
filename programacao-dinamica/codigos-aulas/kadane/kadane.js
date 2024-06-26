const kadane = function(v) {
    let maxSum = v[0], currentSum = 0;

    for(let i = 0; i < v.length; i++){
        currentSum = Math.max(v[i], v[i] + currentSum);
        if(currentSum > maxSum) {
            maxSum = currentSum;
        }
    }

    return maxSum;
}

console.log(kadane([5, -10, 2, 3, 6, -5, 7, -20, 10]));
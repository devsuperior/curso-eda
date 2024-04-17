/**
 * @param {number} n
 * @param {number} x
 * @param {number[]} bottles
 * @return {number}
 */
var minimumBottles = function(n, x, bottles) {
    bottles.sort((a, b) => a - b);
    
    let ans = 0;
    for(let i = 0; i < n; i++){
        // if there's water left to fill a full bottle
        if(x - bottles[i] >= 0){
            x -= bottles[i];
            ans++;
        }
        else
            break;
    }
    return ans;
};

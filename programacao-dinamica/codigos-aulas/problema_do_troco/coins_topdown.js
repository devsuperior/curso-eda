let memo = [];

const min_coins = function(v, c) {
    if(memo[v] != null)
        return memo[v];

    if(v == 0)
        return 0;

    let result = Infinity;

    for(let coin of c){
        let subproblem = v - coin;
        if(subproblem >= 0) {
            result = Math.min(result, min_coins(subproblem, c) + 1);
        }
    }

    memo[v] = result;
    return memo[v];
}

console.log(min_coins(15, [10, 7]));
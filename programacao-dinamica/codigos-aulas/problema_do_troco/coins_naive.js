const min_coins = function(v, c) {
    if(v == 0)
        return 0;

    let result = Infinity;

    for(let coin of c){
        let subproblem = v - coin;
        if(subproblem >= 0) {
            result = Math.min(result, min_coins(subproblem, c) + 1);
        }
    }

    return result;
}

console.log(min_coins(14, [10, 7, 1]));
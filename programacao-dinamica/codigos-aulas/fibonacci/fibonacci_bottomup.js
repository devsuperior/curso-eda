const fib = function(n) {
    let memo = []

    // casos base
    memo[1] = memo[2] = 1;

    // iteração + tabulação
    for(let i = 3; i <= n; i++){
        memo[i] = memo[i - 1] + memo[i - 2];
    }

    return memo[n];
}

console.log(fib(300));
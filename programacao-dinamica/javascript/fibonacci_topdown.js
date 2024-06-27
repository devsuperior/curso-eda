let dp = []

const fib = function(n) {
    // memoização - se já calculei, posso consultar
    if(dp[n] != null)
        return dp[n];

    // casos base
    if (n <= 2)
        return 1;

    // memoização - armazenar resposta para consultar depois
    dp[n] = fib(n - 2) + fib(n - 1);
    return dp[n];
}

console.log(fib(300));
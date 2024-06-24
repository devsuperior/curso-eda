const fib = function(n) {
    // casos base
    if (n <= 2)
        return 1;

    // recursão
    return fib(n - 1) + fib(n - 2);
}

console.log(fib(50));
function fib(n) {
  return fibTailRecursive(n, 0, 1);
}

function fibTailRecursive(n, a, b) {
  if (n == 0) {
    return a;
  }
  if (n == 1) {
    return b;
  }
  return fibTailRecursive(n - 1, b, a + b);
}

const result = fib(6);
console.log("RESULTADO = " + result);

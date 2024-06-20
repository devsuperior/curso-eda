function fibExponential(n) {
  if (n == 0) {
    return 0;
  }
  if (n == 1) {
    return 1;
  }
  return fibExponential(n - 1) + fibExponential(n - 2);
}

const result = fibExponential(40);
console.log(result);

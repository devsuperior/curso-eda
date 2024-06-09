function sum(n) {
  if (n == 0) {
    return 0;
  }
  return n + sum(n - 1);
}

let result = sum(4);
console.log("RESULTADO: " + result);

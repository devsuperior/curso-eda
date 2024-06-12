function sumNaturals(n) {
  if (n == 0) {
    return 0;
  }
  return n + sumNaturals(n - 1);
}

let result = sumNaturals(4);
console.log("RESULTADO: " + result);

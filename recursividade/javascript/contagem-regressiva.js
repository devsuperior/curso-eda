function countdown(n) {
  console.log(n);
  if (n > 0) {
    countdown(n - 1);
  }
}

countdown(5);

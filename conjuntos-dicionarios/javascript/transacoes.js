function invalidTransactions(transactions) {
  function Transaction(csv) {
    const parts = csv.split(",");
    this.name = parts[0];
    this.time = parseInt(parts[1]);
    this.money = parseInt(parts[2]);
    this.city = parts[3];
    this.csv = csv;
  }

  let dict = {};
  let allTransactions = [];
  let result = [];

  transactions.forEach((s) => {
    let t = new Transaction(s);
    allTransactions.push(t);

    if (dict[t.name]) {
      dict[t.name].push(t);
    } else {
      dict[t.name] = [t];
    }
  });

  allTransactions.forEach((t) => {
    if (t.money > 1000) {
      result.push(t.csv);
    } else {
      for (let t2 of dict[t.name]) {
        if (Math.abs(t.time - t2.time) <= 60 && t.city !== t2.city) {
            result.push(t.csv);
            break;
        }
      }
    }
  });

  return result;
}

console.log(invalidTransactions(["alice,20,800,mtv", "alice,50,100,beijing"]));
console.log(invalidTransactions(["alice,20,800,mtv", "alice,50,1200,mtv"]));
console.log(invalidTransactions(["alice,20,800,mtv", "bob,50,1200,mtv"]));


function invalidTransactions(transactions) {
  function Transaction(csv) {
    const parts = csv.split(",");
    this.name = parts[0];
    this.time = Number(parts[1]);
    this.money = Number(parts[2]);
    this.city = parts[3];
    this.csv = csv;
  }

  let dict = new Map();
  let allTransactions = [];
  let result = [];

  transactions.forEach((s) => {
    let t = new Transaction(s);
    allTransactions.push(t);

    if (!dict.has(t.name)) {
      dict.set(t.name, [t]);
    } else {
      dict.get(t.name).push(t);
    }
  });

  allTransactions.forEach((t) => {
    if (t.money > 1000) {
      result.push(t.csv);
    } else {
      for (let t2 of dict.get(t.name)) {
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

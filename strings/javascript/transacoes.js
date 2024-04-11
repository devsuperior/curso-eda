function invalidTransactions(transactions) {

    function Transaction(csv) {
        const parts = csv.split(",");
        this.name = parts[0];
        this.time = Number(parts[1]);
        this.amount = Number(parts[2]);
        this.city = parts[3];
    }

    const result = [];
    const invalidArray = new Array(transactions.length).fill(false);

    for (let i = 0; i < transactions.length; i++) {
        const ti = new Transaction(transactions[i]);
        
        if (ti.amount > 1000) {
            invalidArray[i] = true;
        }

        for (let j = i + 1; j < transactions.length; j++) {

            const tj = new Transaction(transactions[j]);

            if (ti.name === tj.name && Math.abs(ti.time - tj.time) <= 60 && ti.city !== tj.city) {
                invalidArray[i] = true;
                invalidArray[j] = true;
            } 
        }
    }

    for (let i = 0; i < transactions.length; i++) {
        if (invalidArray[i]) {
            result.push(transactions[i]);
        }
    }
    return result;
}

console.log(invalidTransactions(["alice,20,800,mtv","alice,50,100,beijing"]));
console.log(invalidTransactions(["alice,20,800,mtv","alice,50,1200,mtv"]));
console.log(invalidTransactions(["alice,20,800,mtv","bob,50,1200,mtv"]));

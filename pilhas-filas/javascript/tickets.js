function timeRequiredToBuy(tickets, k) {
    let queue = [];
    let n = tickets.length;

    for (let i = 0; i < n; i++) {
        queue.push(i);
    }

    let result = 0;
    while (true) {
        let i = queue.shift();
        tickets[i]--;
        result++;
        if (tickets[i] > 0) {
            queue.push(i);
        } else if (i === k) {
            return result;
        }
    }
}

console.log(timeRequiredToBuy([2, 3, 2], 2));
console.log(timeRequiredToBuy([5, 1, 1, 1], 0));

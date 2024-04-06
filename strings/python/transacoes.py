def invalid_transactions(transactions):

    class Transaction:
        def __init__(self, csv):
            parts = csv.split(",")
            self.name = parts[0]
            self.time = int(parts[1])
            self.money = int(parts[2])
            self.city = parts[3]

    result = []
    invalid_array = [False] * len(transactions)

    for i in range(len(transactions)):
        ti = Transaction(transactions[i])

        if ti.money > 1000:
            invalid_array[i] = True

        for j in range(i + 1, len(transactions)):
            tj = Transaction(transactions[j])

            if ti.name == tj.name and abs(ti.time - tj.time) <= 60 and ti.city != tj.city:
                invalid_array[i] = True
                invalid_array[j] = True

    for i in range(len(transactions)):
        if invalid_array[i]:
            result.append(transactions[i])

    return result


print(invalid_transactions(["alice,20,800,mtv", "alice,50,100,beijing"]))
print(invalid_transactions(["alice,20,800,mtv", "alice,50,1200,mtv"]))
print(invalid_transactions(["alice,20,800,mtv", "bob,50,1200,mtv"]))

def invalid_transactions(transactions):

    class Transaction:
        def __init__(self, csv):
            parts = csv.split(',')
            self.name = parts[0]
            self.time = int(parts[1])
            self.money = int(parts[2])
            self.city = parts[3]
            self.csv = csv

    dictionary = {}
    all_transactions = []
    result = []

    for s in transactions:
        t = Transaction(s)
        all_transactions.append(t)

        if t.name in dictionary:
            dictionary[t.name].append(t)
        else:
            dictionary[t.name] = [t]

    for t in all_transactions:
        if t.money > 1000:
            result.append(t.csv)
        else:
            for t2 in dictionary[t.name]:
                if abs(t.time - t2.time) <= 60 and t.city != t2.city:
                    result.append(t.csv)
                    break

    return result


print(invalid_transactions(["alice,20,800,mtv", "alice,50,100,beijing"]))
print(invalid_transactions(["alice,20,800,mtv", "alice,50,1200,mtv"]))
print(invalid_transactions(["alice,20,800,mtv", "bob,50,1200,mtv"]))

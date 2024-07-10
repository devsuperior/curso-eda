def counting(votes):
    dictionary = {}

    for s in votes:
        name, count = s.split(",")
        count = int(count)
        if name not in dictionary:
            dictionary[name] = count
        else:
            dictionary[name] += count

    result = []
    for key, value in dictionary.items():
        result.append(f"{key},{value}")

    return result


input_values = [
    "Alex Blue,15",
    "Maria Green,22",
    "Bob Brown,21",
    "Alex Blue,30",
    "Bob Brown,15",
    "Maria Green,27",
    "Maria Green,22",
    "Bob Brown,25",
    "Alex Blue,31"
]

for st in counting(input_values):
    print(st)

def minor(lst):
    if len(lst) == 1:
        return lst[0]

    head = lst[0]
    tail = lst[1:]

    tail_minor = minor(tail)

    return head if head < tail_minor else tail_minor


result = minor([10, 15, 20, 8, 30, 17])
print("MENOR =", result)

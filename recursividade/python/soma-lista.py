def sum_list(lst):
    if not lst:
        return 0

    head, *tail = lst
    return head + sum_list(tail)


result = sum_list([4, 5, 3])
print("RESULTADO =", result)

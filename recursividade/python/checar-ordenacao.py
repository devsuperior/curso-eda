def is_sorted(lst):
    if len(lst) <= 1:
        return True

    if lst[0] > lst[1]:
        return False

    tail = lst[1:]
    return is_sorted(tail)


print(is_sorted([]))
print(is_sorted([15.0, 20.0, 22.0, 31.0, 40.0]))
print(is_sorted([15.0, 20.0, 22.0, 21.0, 40.0]))

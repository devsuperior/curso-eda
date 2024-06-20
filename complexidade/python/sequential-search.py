def sequential_search(elem, lst):
    for i in range(len(lst)):
        if lst[i] == elem:
            return i
    return -1


result = sequential_search(32, [15, 82, 79, 32, 41, 28])
print(result)

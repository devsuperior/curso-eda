def binary_search(elem, arr):
    return binary_search_tail_recursive(elem, arr, 0, len(arr) - 1)


def binary_search_tail_recursive(elem, arr, start, finish):
    if start > finish:
        return -1
    middle = (start + finish) // 2
    if elem == arr[middle]:
        return middle
    elif elem < arr[middle]:
        return binary_search_tail_recursive(elem, arr, start, middle - 1)
    else:
        return binary_search_tail_recursive(elem, arr, middle + 1, finish)


v = [7, 13, 20, 25, 28, 31, 35, 39, 40, 45, 46, 48, 57, 59, 63, 71]
print(binary_search(39, v))
print(binary_search(46, v))
print(binary_search(22, v))

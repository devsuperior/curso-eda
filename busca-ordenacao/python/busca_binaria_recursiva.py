def binary_search(nums, key):
    return binary_search_tail_recursive(nums, key, 0, len(nums) - 1)


def binary_search_tail_recursive(nums, key, low, high):
    if low > high:
        return -1

    middle = (low + high) // 2
    if key == nums[middle]:
        return middle
    elif key < nums[middle]:
        return binary_search_tail_recursive(nums, key, low, middle - 1)
    else:
        return binary_search_tail_recursive(nums, key, middle + 1, high)


print(binary_search([-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38], 34)) # 9
print(binary_search([-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38], 10)) # -1
print(binary_search([-10, -3, 4, 11, 13, 18, 44, 64, 91, 225, 431], 11)) # 3

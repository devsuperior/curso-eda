def binary_search(nums, key):
    low = 0
    high = len(nums) - 1

    while low <= high:
        middle = (low + high) // 2
        if key < nums[middle]:
            high = middle - 1
        elif key > nums[middle]:
            low = middle + 1
        else:
            return middle

    return -1


arr1 = [-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38]
print(binary_search(arr1, 34))  # 9
print(binary_search(arr1, 10))  # -1
arr2 = [-10, -3, 4, 11, 13, 18, 44, 64, 91, 225, 431]
print(binary_search(arr2, 11)) # 3

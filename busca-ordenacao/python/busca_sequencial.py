def sequential_search(nums, key):
    for i, num in enumerate(nums):
        if num == key:
            return i
    return -1


print(sequential_search([28, 6, -2, 9, 16, 20, 23, 8], 20))  # 5
print(sequential_search([4, 6, -3, 21, 55, 91, 2], 11))  # -1

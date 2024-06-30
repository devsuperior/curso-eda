def insertion_sort(nums):
    n = len(nums)
    for i in range(1, n):
        aux = nums[i]
        j = i - 1
        while j >= 0 and nums[j] > aux:
            nums[j + 1] = nums[j]
            j -= 1
        nums[j + 1] = aux
    return nums


print(insertion_sort([20, 9, 86, -2, 16]))
print(insertion_sort([5, 4, 3, 2, 1]))
print(insertion_sort([-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38]))

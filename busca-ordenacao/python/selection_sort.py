def selection_sort(nums):
    n = len(nums)
    for i in range(n - 1):
        min_index = i
        for j in range(i + 1, n):
            if nums[j] < nums[min_index]:
                min_index = j
        if min_index != i:
            swap(nums, i, min_index)
    return nums


def swap(nums, a, b):
    nums[a], nums[b] = nums[b], nums[a]


print(selection_sort([20, 9, 86, -2, 16]))
print(selection_sort([5, 4, 3, 2, 1]))
print(selection_sort([-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38]))

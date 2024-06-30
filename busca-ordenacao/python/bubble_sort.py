def bubble_sort(nums):
    n = len(nums)
    for i in range(n):
        swapped = False
        for j in range(n - 1 - i):
            if nums[j] > nums[j + 1]:
                swap(nums, j, j + 1)
                swapped = True
        if not swapped:
            break
    return nums


def swap(nums, a, b):
    aux = nums[a]
    nums[a] = nums[b]
    nums[b] = aux


print(bubble_sort([20, 9, 86, -2, 16]))
print(bubble_sort([5, 4, 3, 2, 1]))
print(bubble_sort([-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38]))

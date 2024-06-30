def quick_sort(nums):
    quick_sort_tail_recursive(nums, 0, len(nums) - 1)
    return nums


def quick_sort_tail_recursive(nums, left, right):
    if left < right:
        pivot = partition(nums, left, right)
        quick_sort_tail_recursive(nums, left, pivot - 1)
        quick_sort_tail_recursive(nums, pivot + 1, right)


def partition(nums, left, right):
    pivot = nums[right]
    i = left
    for j in range(left, right):
        if nums[j] <= pivot:
            swap(nums, j, i)
            i += 1
    swap(nums, i, right)
    return i


def swap(nums, a, b):
    nums[a], nums[b] = nums[b], nums[a]


print(quick_sort([20, 9, 86, -2, 16]))
print(quick_sort([30, 24, -2, 2, -4, -2, 2, 8, 10, 9, -4]))
print(quick_sort([1, 1, 1, 2, 2, 4, 8, 8, 16, 32]))

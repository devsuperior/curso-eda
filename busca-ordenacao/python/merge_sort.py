def merge_sort(nums):
    merge_sort_tail_recursive(nums, 0, len(nums) - 1)
    return nums


def merge_sort_tail_recursive(nums, left, right):
    if left < right:
        middle = (left + right) // 2
        merge_sort_tail_recursive(nums, left, middle)
        merge_sort_tail_recursive(nums, middle + 1, right)
        merge(nums, left, middle, right)


def merge(nums, left, middle, right):
    result = []
    i, j = left, middle + 1
    while i <= middle and j <= right:
        if nums[i] < nums[j]:
            result.append(nums[i])
            i += 1
        else:
            result.append(nums[j])
            j += 1

    while i <= middle:
        result.append(nums[i])
        i += 1

    while j <= right:
        result.append(nums[j])
        j += 1

    for index, value in enumerate(result):
        nums[left + index] = value


print(merge_sort([20, 9, 86, -2, 16]))
print(merge_sort([30, 24, -2, 2, -4, -2, 2, 8, 10, 9, -4]))
print(merge_sort([1, 1, 1, 2, 2, 4, 8, 8, 16, 32]))

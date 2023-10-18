from typing import List

#   Problema: Bubble Sort
#
#   n = number of elements array
#
#   tempo: O(nˆ2)
#   space: O(1)
#

def bubble_sort(nums: List[int]) -> int:
    N = len(nums)
    for i in range(N):
        swapped = False
        for j in range(0, N - 1 - i):
            if nums[j] > nums[j + 1]:
                nums[j], nums[j+1] = nums[j+1], nums[j]
                swapped = True

        if not swapped:
            break

    return nums

nums = [23, 4, 67, -8, 21]
print(bubble_sort(nums))

nums = [-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38]
print(bubble_sort(nums))
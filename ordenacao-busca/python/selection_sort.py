from typing import List

#   Problema: Selection Sort
#
#   n = number of elements array
#
#   tempo: O(nˆ2)
#   space: O(1)
#

def selection_sort(nums: List[int]) -> int:
    N = len(nums)
    for i in range(N):
        minIndex = i
        for j in range(i + 1, N):
            if nums[j] < nums[minIndex]:
                minIndex = j

        if minIndex != i:
            nums[i], nums[minIndex] = nums[minIndex], nums[i]

    return nums

nums = [20, 9, 86, -2, 16]
print(selection_sort(nums))

nums = [-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38]
print(selection_sort(nums))
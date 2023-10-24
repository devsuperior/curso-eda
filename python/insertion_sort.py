from typing import List

#   Problema: Insertion Sort
#
#   n = number of elements array
#
#   tempo: O(nˆ2)
#   space: O(1)
#

def insertion_sort(nums: List[int]) -> int:
    for i in range(1, len(nums)):
        aux = nums[i]
        j = i - 1

        while j >= 0 and nums[j] > aux:
            nums[j + 1] = nums[j]
            j -= 1

        nums[j + 1] = aux

    return nums

nums = [20, 9, 86, -2, 16]
print(insertion_sort(nums))

nums = [-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38]
print(insertion_sort(nums))
from typing import List

def merge(nums1: List[int], m: int, nums2: List[int], n: int) -> None:
    for i in range(n):
        nums1[m + i] = nums2[i]
    nums1.sort()

# Exemplo de uso
nums1 = [1, 2, 3, 0, 0, 0]
nums2 = [2, 5, 6]
merge(nums1, 3, nums2, 3)
print(nums1)

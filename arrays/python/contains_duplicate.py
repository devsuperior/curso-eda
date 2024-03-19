from typing import List

def contains_duplicate(nums: List[int]) -> bool:
    is_duplicate = False
    for i in range(len(nums) - 1):
        for j in range(i + 1, len(nums)):
            if nums[i] == nums[j]:
                return not is_duplicate
    return is_duplicate

# Exemplo de uso
nums1 = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
print(f"Array {nums1}, contém valores duplicados? {contains_duplicate(nums1)}")

nums2 = [1, 2, 3, 4, 5, 10, 9, 8, 7, 6]
print(f"Array {nums2}, contém valores duplicados? {contains_duplicate(nums2)}")

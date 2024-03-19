from typing import List

def dot_product(nums1: List[int], nums2: List[int]) -> int:
    product = 0
    for i in range(len(nums1)):
        product += nums1[i] * nums2[i]
    return product

nums1 = [1, 0, 0, 2, 3]
nums2 = [0, 3, 0, 4, 0]
print(dot_product(nums1, nums2)) # = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8

nums1 = [0, 1, 0, 0, 0]
nums2 = [0, 0, 0, 0, 2]
print(dot_product(nums1, nums2)) # = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0

nums1 = [0, 1, 0, 0, 2, 0, 0]
nums2 = [1, 0, 0, 0, 3, 0, 4]
print(dot_product(nums1, nums2)) # = 0*1 + 1*0 + 0*0 + 0*0 + 2*3 + 0*0 + 0*4


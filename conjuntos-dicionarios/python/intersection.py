def intersection(nums1, nums2):
    set1 = set(nums1)
    set2 = set(nums2)

    result = list(set1 & set2)
    return result


result1 = intersection([1, 2, 2, 1], [2, 2])
result2 = intersection([4, 9, 5], [9, 4, 9, 8, 4])
print(result1)  # Output: [2]
print(result2)  # Output: [9, 4]

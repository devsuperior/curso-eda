def two_sum(nums, target):
    dictionary = {}
    result = [0, 0]

    for i in range(len(nums)):
        remainder = target - nums[i]
        if remainder in dictionary:
            index = dictionary[remainder]
            result[0] = index
            result[1] = i
            return result
        dictionary[nums[i]] = i

    return result


print(two_sum([2, 7, 11, 15], 9))
print(two_sum([3, 2, 4], 6))
print(two_sum([3, 5, 7, 2, 4, 8, 1, 6], 15))

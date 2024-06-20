def higher_values(arr):
    new_array = [0] * len(arr)

    for i in range(len(arr)):
        for j in range(len(arr)):
            if arr[j] > arr[i]:
                new_array[i] += 1

    return new_array


result = higher_values([7, 3, 8, 7, 5])
print(result)

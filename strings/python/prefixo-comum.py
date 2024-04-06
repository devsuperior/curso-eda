def longest_common_prefix(v):
    v.sort()
    first = v[0]
    last = v[-1]
    result = []

    for i in range(min(len(first), len(last))):
        if first[i] != last[i]:
            return ''.join(result)
        result.append(first[i])

    return ''.join(result)


print(f'"{longest_common_prefix(["flower", "flow", "flight"])}"')
print(f'"{longest_common_prefix(["dog", "racecar", "car"])}"')

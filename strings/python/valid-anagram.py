def is_anagram(s, t):
    return sorted(s) == sorted(t)


def is_anagram2(s, t):
    count = [0] * 26

    for char in s:
        count[ord(char) - ord('a')] += 1

    for char in t:
        count[ord(char) - ord('a')] -= 1

    for val in count:
        if val != 0:
            return False
    return True


print(is_anagram("anagram", "nagaram"))
print(is_anagram("batata", "attaba"))
print(is_anagram("rat", "car"))

print(is_anagram2("anagram", "nagaram"))
print(is_anagram2("batata", "attaba"))
print(is_anagram2("rat", "car"))

def is_palindrome(text):
    return is_palindrome_tail_recursive(text, 0, len(text) - 1)


def is_palindrome_tail_recursive(text, start, end):
    if start >= end:
        return True

    if text[start] != text[end]:
        return False

    return is_palindrome_tail_recursive(text, start + 1, end - 1)


print(is_palindrome(""))
print(is_palindrome("aba"))
print(is_palindrome("abccba"))
print(is_palindrome("abcfba"))

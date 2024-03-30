import re


def remove_non_digits(string):
    char_array = []

    for char in string:
        if char.isdigit():
            char_array.append(char)

    return ''.join(char_array)


def remove_non_digits2(string):
    regex = r'\D'
    return re.sub(regex, '', string)


print(remove_non_digits("949.237.847-99"))
print(remove_non_digits2("949.237.847-99"))

def remove_duplicates(text):
    stack = []
    for char in text:
        if stack and stack[-1] == char:
            stack.pop()
        else:
            stack.append(char)
    return ''.join(stack)


print(remove_duplicates("abbaca"))
print(remove_duplicates("azxxzy"))

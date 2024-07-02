def is_balanced(text):
    stack = []
    for char in text:
        if char == '(':
            stack.append(char)
        elif char == ')':
            if len(stack) == 0:
                return False
            stack.pop()
    return len(stack) == 0


print(is_balanced("(())()"))  # true
print(is_balanced("())("))    # false

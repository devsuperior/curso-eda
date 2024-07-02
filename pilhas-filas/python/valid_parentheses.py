def valid_parentheses(text):
    stack = []
    for c in text:
        if c == '(':
            stack.append(')')
        elif c == '{':
            stack.append('}')
        elif c == '[':
            stack.append(']')
        elif len(stack) == 0 or stack.pop() != c:
            return False
    return len(stack) == 0


print(valid_parentheses("()([]{})"))  # True
print(valid_parentheses("(){]{}"))  # False

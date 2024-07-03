from collections import deque


def count_students(students, sandwiches):
    queue = deque(students)

    for sandwich in sandwiches:
        eat = False
        count = len(queue)

        while not eat and count > 0:
            student = queue.popleft()
            if student == sandwich:
                eat = True
            else:
                queue.append(student)
                count -= 1

        if count == 0:
            return len(queue)

    return 0


print(count_students([1, 1, 0, 0], [0, 1, 0, 1]))
print(count_students([1, 1, 1, 0, 0, 1], [1, 0, 0, 0, 1, 1]))

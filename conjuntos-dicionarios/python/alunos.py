def students_count(courses):
    all_students = set()

    for course in courses:
        all_students.update(course)

    return len(all_students)


course_list = [
    [15, 21, 80, 42],
    [21, 80, 47],
    [12, 21, 47, 35]
]

result = students_count(course_list)
print("Total students =", result)

from task import Task, TaskStatus
from task_list import TaskList

# def show_tasks(task_list):
#     for item in task_list.get_tasks():
#         show_task(item)

# def show_task(item):
#     if item is None:
#         print("Task not found")
#         return
#     print(f"""
#     Task {item.get_id()}:
#       desc: {item.get_description()},
#       tag: {item.get_tag()},
#       status: {item.get_status()}
#     """)

def show_tasks(list):
    if list is None:
        print("Tasks not found")
        return
    for item in list:
        print(item)

task1 = Task(1, "Daily with the team", "meeting")
task2 = Task(2, "Implement some feature", "job")
task3 = Task(3, "Reeding a book", "study", TaskStatus.COMPLETED)
task4 = Task(4, "Review a documentation", "job")
task5 = Task(5, "Review a project", "meeting")
task6 = Task(6, "Deploy a project", "job")
task7 = Task(7, "Reeding article", "study")

task_list = TaskList()

task_list.add_task(task1)
task_list.add_task(task2)
task_list.add_task(task3, 0)
task_list.add_task(task4, 10)
task_list.add_task(task4)
task_list.add_task(task5, 2)
task_list.add_task(task6)
task_list.add_task(task7)

# 1 - Obter todas as tarefas
print(task_list.get_tasks())

# 2 - Obter tarefas por tag
# print("Show tasks by job:")
# show_tasks(task_list.get_tasks_by_tag("job"))

# print("\nShow tasks by study:")
# show_tasks(task_list.get_tasks_by_tag("study"))

# 3 - Obter tarefa por Id
# print("Get task by id: 2")
# print(task_list.get_task_by_id(2))

# print("\nGet task by id: 120")
# print(task_list.get_task_by_id(120))

# 4 - Remover tarefa por Id
# id_to_remove = 3
# print(f"Remove task {id_to_remove}...")
# task_list.remove_task_by_id(id_to_remove)
# print(task_list.get_tasks())

# 5 - Marcar uma tarefa como concluída por Id
# id_to_complete = 1
# print(f"Set task {id_to_complete} to completed...")
# print(task_list.set_task_to_completed(id_to_complete))
# id_to_complete_nonexistent = 152
# print(f"Set task {id_to_complete_nonexistent} to completed...")
# print(task_list.set_task_to_completed(id_to_complete_nonexistent))

# 6 - Atualizar dados de uma tarefa
# task_update = Task(None, "Reeding working article", "job")
# print(task_list.set_task_data_by_id(7, task_update))
# print(task_list.get_tasks())

# 7 - Reposicionar uma tarefa
# print(task_list.move(7, 1))
# print(task_list.move(3, 5))
# print(task_list.get_tasks())

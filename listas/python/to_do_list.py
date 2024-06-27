from task import Task, TaskStatus
from task_list import TaskList


def show_tasks(items):
    for item in items:
        print(item)


task1 = Task(1, "Daily with the team", "meeting")
task2 = Task(2, "Implement some feature", "job")
task3 = Task(3, "Reading a book", "study", TaskStatus.COMPLETED)
task4 = Task(4, "Review a documentation", "job")
task5 = Task(5, "Review a project", "meeting")
task6 = Task(6, "Deploy a project", "job")
task7 = Task(7, "Reading article", "study")

task_list = TaskList()

task_list.add_task(task1)
task_list.add_task(task2)
task_list.add_task(task3, 0)
task_list.add_task(task4, 10)
task_list.add_task(task4)
task_list.add_task(task5, 2)
task_list.add_task(task6)
task_list.add_task(task7)

# 1 - Get all tasks
print("Tarefas:")
show_tasks(task_list.get_tasks())

# 2 - Get tasks by tag
print("\nTarefas da tag 'job':")
show_tasks(task_list.get_tasks_by_tag("job"))

print("\nTarefas da tag 'study':")
show_tasks(task_list.get_tasks_by_tag("study"))

# 3 - Get tasks by Id
print("\nTarefa de id 2:")
print(task_list.get_task_by_id(2))

print("\nTarefa de id 120 (inexistente):")
print(task_list.get_task_by_id(120))

# 4 - Remove tasks by Id
print("\nRemovida tarefa de id 3:")
task_list.remove_task_by_id(3)
show_tasks(task_list.get_tasks())

# 5 - Marcar uma tarefa como concluída por id
print("\nTarefa 1 marcada como concluída:")
task_list.set_task_to_completed(1)
show_tasks(task_list.get_tasks())

print("\nTarefa 152 (inexistente) marcada como concluída:")
task_list.set_task_to_completed(152)
show_tasks(task_list.get_tasks())

# 6 - Atualizar dados de uma task
task_update = Task(None, "Reading working article", "job")
task_list.set_task_data_by_id(7, task_update)
print("\nTarefa 7 com dados atualizados:")
show_tasks(task_list.get_tasks())

# 7 - Reposicionar uma tarefa
task_list.move(7, 1)
print("\nTarefa 7 movida para posição 1:")
show_tasks(task_list.get_tasks())

task_list.move(3, 5)
print("\nTarefa 3 (inexistente) movida para posição 5:")
show_tasks(task_list.get_tasks())

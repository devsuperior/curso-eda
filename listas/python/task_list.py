from task import TaskStatus
from linked_list import LinkedList


class TaskList:
    def __init__(self):
        self.tasks = LinkedList()

    def get_tasks(self):
        return self.tasks.to_array()

    def add_task(self, task, index=None):
        if index is None:
            self.tasks.add_at_end(task)
            return
        if not self.tasks.get(index):
            return
        self.tasks.add_at_position(index, task)

    def get_tasks_by_tag(self, tag):
        current = self.tasks.head
        tasks_by_tag = []
        while current:
            if current.value.tag == tag:
                tasks_by_tag.append(current.value)
            current = current.next
        return tasks_by_tag

    def get_task_by_id(self, cod):
        current = self.tasks.head
        while current:
            if current.value.id == cod:
                return current.value
            current = current.next
        return None

    def remove_task_by_id(self, cod):
        task_item = self.get_task_by_id(cod)
        if task_item:
            return self.tasks.remove(task_item)
        return None

    def set_task_to_completed(self, cod):
        task_item = self.get_task_by_id(cod)
        if task_item:
            task_item.set_status(TaskStatus.COMPLETED)
        return task_item

    def set_task_data_by_id(self, cod, task):
        task_item = self.get_task_by_id(cod)
        if task_item:
            task_item.set_description(task.description)
            task_item.set_status(task.status)
            task_item.set_tag(task.tag)
        return task_item

    def move(self, cod, target_index):
        if target_index < 0 or target_index > self.tasks.get_size():
            return None
        task_item = self.get_task_by_id(cod)
        source_index = self.tasks.index_of(task_item)
        if task_item and source_index != target_index:
            self.tasks.remove_at_position(source_index)
            self.tasks.add_at_position(target_index, task_item)
        return None

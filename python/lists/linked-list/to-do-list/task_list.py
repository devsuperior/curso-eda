import sys
sys.path.append('..')

from task import Task, TaskStatus
from linked_list import LinkedList

class TaskList:
    def __init__(self):
        self.tasks = LinkedList()

    def get_tasks(self):
        return self.tasks
    
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
            if current.value.get_tag() == tag:
                tasks_by_tag.append(current.value)
            current = current.next

        return tasks_by_tag
    
    def get_task_by_id(self, id):
        current = self.tasks.head
        while current:
            if current.value.get_id() == id:
                return current.value
            current = current.next
        return None
    
    def remove_task_by_id(self, id):
        task_item = self.get_task_by_id(id)
        if task_item:
            return self.tasks.remove(task_item)
        return None
    
    def set_task_to_completed(self, id):
        task_item = self.get_task_by_id(id)
        if task_item:
            task_item.set_status(TaskStatus.COMPLETED)
        return task_item
    
    def set_task_data_by_id(self, id, task):
        task_item = self.get_task_by_id(id)
        if task_item:
            task_item.set_description(task.get_description())
            task_item.set_status(task.get_status())
            task_item.set_tag(task.get_tag())
        return task_item
    
    def move(self, id, target_index):
        if target_index < 0 or target_index > self.tasks.get_size():
            return None
        task_item = self.get_task_by_id(id)
        source_index = self.tasks.index_of(task_item)
        if task_item and source_index != target_index:
            self.tasks.remove_at_position(source_index)
            self.tasks.add_at_position(target_index, task_item)
            return
        return None
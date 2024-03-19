using System;
using System.Collections.Generic;

namespace Lists.LinkedList.TodoList
{
    public class TaskList {
        private LinkedList<Task> tasks;

        public TaskList() {
            this.tasks = new LinkedList<Task>();
        }

        public List<Task> GetTasks() {
            return tasks.ToArray();
        }

        public void AddTask(Task task) {
            tasks.AddAtEnd(task);
        }

        public void AddTask(Task task, int? index) {
            if (index == null) {
                tasks.AddAtEnd(task);
                return;
            }
            if (tasks.Get(index.Value) == null) {
                return;
            }
            tasks.AddAtPosition(index.Value, task);
        }

        public List<Task> GetTasksByTag(string tag) {
            Node<Task> current = tasks.GetHead();
            List<Task> tasksByTag = new List<Task>();

            while (current != null) {
                if (current.Value.Tag.Equals(tag)) {
                    tasksByTag.Add(current.Value);
                }
                current = current.Next;
            }
            return tasksByTag;
        }

        public Task GetTaskById(int id) {
            Node<Task> current = tasks.GetHead();
            while (current != null) {
                if (current.Value.Id == id) {
                    return current.Value;
                }
                current = current.Next;
            }
            return null;
        }

        public Task RemoveTaskById(int id) {
            Task taskItem = GetTaskById(id);
            if (taskItem != null) {
                tasks.Remove(taskItem);
            }
            return taskItem;
        }

        public Task SetTaskToCompleted(int id) {
            Task taskItem = GetTaskById(id);
            if (taskItem != null) {
                taskItem.Status = TaskStatus.Completed;
            }
            return taskItem;
        }

        public Task SetTaskDataById(int id, Task task) {
            Task taskItem = GetTaskById(id);
            if (taskItem != null) {
                taskItem.Description = task.Description;
                taskItem.Status = task.Status;
                taskItem.Tag = task.Tag;
            }
            return taskItem;
        }

        public void Move(int id, int targetIndex) {
            if (targetIndex < 0 || targetIndex >= tasks.GetSize()) {
                return;
            }
            Task taskItem = GetTaskById(id);
            int sourceIndex = tasks.IndexOf(taskItem);
            if (taskItem != null && sourceIndex != targetIndex) {
                tasks.RemoveAtPosition(sourceIndex);
                tasks.AddAtPosition(targetIndex, taskItem);
            }
        }
    }
}

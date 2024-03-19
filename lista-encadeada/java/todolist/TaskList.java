package lists.linkedlist.todolist;

import java.util.ArrayList;
import java.util.List;

import lists.linkedlist.LinkedList;
import lists.linkedlist.Node;

public class TaskList {
    
    private LinkedList<Task> tasks;

    public TaskList() {
        this.tasks = new LinkedList<>();
    }

    public List<Task> getTasks() {
        return tasks.toArray();
    }

    public void addTask(Task task) {
        tasks.addAtEnd(task);
    }

    public void addTask(Task task, Integer index) {
        if (index == null) {
            tasks.addAtEnd(task);
            return;
        }
        if (tasks.get(index) == null) {
            return;
        }
        tasks.addAtPosition(index, task);
    }

    public List<Task> getTasksByTag(String tag) {
        Node<Task> current = tasks.getHead();
        List<Task> tasksByTag = new ArrayList<>();

        while (current != null) {
            if (current.getValue().getTag().equals(tag)) {
                tasksByTag.add(current.getValue());
            }
            current = current.getNext();
        }

        return tasksByTag;
    }

    public Task getTaskById(Integer id) {
        Node<Task> current = tasks.getHead();
        while (current != null) {
            if (current.getValue().getId() == id) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    public Task removeTaskById(Integer id) {
        Task taskItem = getTaskById(id);
        if (taskItem != null) {
            tasks.remove(taskItem);
        }
        return taskItem;
    }

    public Task setTaskToCompleted(Integer id) {
        Task taskItem = getTaskById(id);
        if (taskItem != null) {
            taskItem.setStatus(TaskStatus.COMPLETED);
        }
        return taskItem;
    }

    public Task setTaskDataById(Integer id, Task task) {
        Task taskItem = getTaskById(id);
        if (taskItem != null) {
            taskItem.setDescription(task.getDescription());
            taskItem.setStatus(task.getStatus());
            taskItem.setTag(task.getTag());
        }
        return taskItem;
    }

    public void move(Integer id, int targetIndex) {
        if (targetIndex < 0 || targetIndex >= tasks.getSize()) {
            return;
        }
        Task taskItem = getTaskById(id);
        int sourceIndex = tasks.indexOf(taskItem);
        if (taskItem != null && sourceIndex != targetIndex) {
            tasks.removeAtPosition(sourceIndex);
            tasks.addAtPosition(targetIndex, taskItem);
        }
    } 
}

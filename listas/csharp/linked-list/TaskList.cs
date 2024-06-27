using System.Linq;

public class TaskList
{
    private LinkedList<Task> tasks = new LinkedList<Task>();

    public Task[] Tasks => tasks.ToArray().Cast<Task>().ToArray();

	public void AddTask(Task task) {
		tasks.AddAtEnd(task);
	}

	public void AddTask(Task task, int? index) {
		if (index == null) {
			tasks.AddAtEnd(task);
			return;
		}
		if (tasks.Get((int)index) == null) {
			return;
		}
		tasks.AddAtPosition((int)index, task);
	}

    public TaskList GetTasksByTag(string tag)
    {
        TaskList tasksByTag = new TaskList();
        Node<Task>? current = tasks.Head;
        while (current != null)
        {
            if (current.Value.Tag == tag)
                tasksByTag.AddTask(current.Value);
            current = current.Next;
        }
        return tasksByTag;
    }

    public Task GetTaskById(int id)
    {
#pragma warning disable CS8603 // Possible null reference return.
        return tasks.ToArray().Cast<Task>().FirstOrDefault(t => t.Id == id);
#pragma warning restore CS8603 // Possible null reference return.
    }

    public Task? RemoveTaskById(int id)
    {
        Task task = GetTaskById(id);
        if (task != null && tasks.Remove(task))
            return task;
        return null;
    }

    public Task? SetTaskToCompleted(int id)
    {
        Task task = GetTaskById(id);
        if (task != null)
        {
            task.Status = TaskStatus.COMPLETED;
            return task;
        }
        return null;
    }

    public Task? SetTaskDataById(int id, Task newTaskData)
    {
        Task task = GetTaskById(id);
        if (task != null)
        {
            task.Description = newTaskData.Description;
            task.Tag = newTaskData.Tag;
            task.Status = newTaskData.Status;
            return task;
        }
        return null;
    }

    public void Move(int id, int targetIndex)
    {
        if (targetIndex < 0 || targetIndex >= tasks.Size) return;
        int sourceIndex = tasks.IndexOf(GetTaskById(id));
        if (sourceIndex != -1 && sourceIndex != targetIndex)
        {
            Task? task = tasks.RemoveAtPosition(sourceIndex);
            if (task != null)
            {
                tasks.AddAtPosition(targetIndex, task);
            }
        }
    }
}

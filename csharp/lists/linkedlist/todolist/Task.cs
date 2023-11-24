using System;

namespace Lists.LinkedList.TodoList
{
    public enum TaskStatus {
        Pending,
        Completed
    }

    public class Task {
        private int id;
        private string description;
        private string tag;
        private TaskStatus status;

        public Task(int id, string description, string tag, TaskStatus status) {
            this.id = id;
            this.description = description;
            this.tag = tag;
            this.status = status;
        }

        public Task(int id, string description, string tag)
            : this(id, description, tag, TaskStatus.Pending)
        {
        }

        public int Id {
            get { return id; }
        }

        public string Description {
            get { return description; }
            set { description = value; }
        }

        public string Tag {
            get { return tag; }
            set { tag = value; }
        }

        public TaskStatus Status {
            get { return status; }
            set { status = value; }
        }

        public override string ToString() {
            return $"Task {id}: {description} | Tag: {tag} | Status: {status}";
        }

        // public static void Main(string[] args) {
        //     // Example instance
        //     Task task = new Task(1, "Example Task", "Work", TaskStatus.Pending);
        //     Console.WriteLine(task);

        //     // Access enum
        //     Console.WriteLine($"Status: {TaskStatus.Pending}");
        // }
    }
}

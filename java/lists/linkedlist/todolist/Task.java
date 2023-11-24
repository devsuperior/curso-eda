package lists.linkedlist.todolist;

public class Task {

    private Integer id;
    private String description;
    private String tag;
    private TaskStatus status;

    public Task(Integer id, String description, String tag, TaskStatus status) {
        this.id = id;
        this.description = description;
        this.tag = tag;
        this.status = status;
    }

    public Task(Integer id, String description, String tag) {
        this(id, description, tag, TaskStatus.PENDING);
    }

    // public Task(String description, String tag) {
    //     this.description = description;
    //     this.tag = tag;
    //     this.status = TaskStatus.PENDING;
    // }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Task %d: %s | Tag: %s | Status: %s", id, description, tag, status);
    }

    // public static void main(String[] args) {
    //     // Example instance
    //     Task task = new Task(1, "Example Task", "Work");
    //     System.out.println(task);
    // }
}

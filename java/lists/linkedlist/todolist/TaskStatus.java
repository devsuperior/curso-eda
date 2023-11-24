package lists.linkedlist.todolist;

public enum TaskStatus {
    PENDING("Pending"),
    COMPLETED("Completed");

    private final String status;

    TaskStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

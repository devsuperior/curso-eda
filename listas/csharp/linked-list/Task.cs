public class Task
{
    public int Id { get; }
    public string Description { get; set; }
    public string Tag { get; set; }
    public TaskStatus Status { get; set; }

    public Task(int id, string description, string tag, TaskStatus status = TaskStatus.PENDING)
    {
        Id = id;
        Description = description;
        Tag = tag;
        Status = status;
    }

    public override string ToString() => $"Task {Id}: {Description} | Tag: {Tag} | Status: {Status}";
}

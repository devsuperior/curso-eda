public class ToDoList
{
    public static void ShowTasks(Task[] taskList)
    {
        foreach (var item in taskList)
        {
            Console.WriteLine(item);
        }
    }

    public static void Main(string[] args)
    {
        Task task1 = new Task(1, "Daily with the team", "meeting");
        Task task2 = new Task(2, "Implement some feature", "job");
        Task task3 = new Task(3, "Reeding a book", "study", TaskStatus.COMPLETED);
        Task task4 = new Task(4, "Review a documentation", "job");
        Task task5 = new Task(5, "Review a project", "meeting");
        Task task6 = new Task(6, "Deploy a project", "job");
        Task task7 = new Task(7, "Reeding article", "study");

        TaskList taskList = new TaskList();

        taskList.AddTask(task1);
        taskList.AddTask(task2);
        taskList.AddTask(task3, 0);
        taskList.AddTask(task4, 10);
        taskList.AddTask(task4);
        taskList.AddTask(task5, 2);
        taskList.AddTask(task6);
        taskList.AddTask(task7);

        // 1 - Obter todas as tarefas
        Console.WriteLine("Tarefas:");
        ShowTasks(taskList.Tasks);

        // 2 - Obter tarefas por tag
        Console.WriteLine("\nTarefas da tag 'job':");
        ShowTasks(taskList.GetTasksByTag("job").Tasks);

        Console.WriteLine("\nTarefas da tag 'study':");
        ShowTasks(taskList.GetTasksByTag("study").Tasks);

        // 3 - Obter tarefa por Id
        Console.WriteLine("\nTarefa de id 2:");
        Console.WriteLine(taskList.GetTaskById(2));

        Console.WriteLine("\nTarefa de id 120 (inexistente):");
        Console.WriteLine(taskList.GetTaskById(120));

        // 4 - Remover tarefa por Id
        taskList.RemoveTaskById(3);
        Console.WriteLine("\nRemovida tarefa de id 3:");
        ShowTasks(taskList.Tasks);

        // 5 - Marcar uma tarefa como concluída por Id
        Console.WriteLine("\nTarefa 1 marcada como concluída:");
        taskList.SetTaskToCompleted(1);
        ShowTasks(taskList.Tasks);

        Console.WriteLine("\nTarefa 152 (inexistente) marcada como concluída:");
        taskList.SetTaskToCompleted(152);
        ShowTasks(taskList.Tasks);

        // 6 - Atualizar dados de uma tarefa
        Task taskUpdate = new Task(0, "Reading working article", "job");
        taskList.SetTaskDataById(7, taskUpdate);
        Console.WriteLine("\nTarefa 7 com dados atualizados:");
        ShowTasks(taskList.Tasks);

        // 7 - Reposicionar uma tarefa
        taskList.Move(7, 1);
        Console.WriteLine("\nTarefa 7 movida para posição 1:");
        ShowTasks(taskList.Tasks);
        
        taskList.Move(3, 5);
        Console.WriteLine("\nTarefa 3 (inexistente) movida para posição 5:");
        ShowTasks(taskList.Tasks);
    }
}

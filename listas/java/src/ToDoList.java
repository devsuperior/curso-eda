public class ToDoList {

    public static void showTasks(Task[] taskList) {
        for (Task item : taskList) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Task task1 = new Task(1, "Daily with the team", "meeting");
        Task task2 = new Task(2, "Implement some feature", "job");
        Task task3 = new Task(3, "Reeding a book", "study", TaskStatus.COMPLETED);
        Task task4 = new Task(4, "Review a documentation", "job");
        Task task5 = new Task(5, "Review a project", "meeting");
        Task task6 = new Task(6, "Deploy a project", "job");
        Task task7 = new Task(7, "Reeding article", "study");

        TaskList taskList = new TaskList();

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3, 0);
        taskList.addTask(task4, 10);
        taskList.addTask(task4);
        taskList.addTask(task5, 2);
        taskList.addTask(task6);
        taskList.addTask(task7);

        // 1 - Obter todas as tarefas
        System.out.println("Tarefas:");
        showTasks(taskList.getTasks());

        // 2 - Obter tarefas por tag
        System.out.println("\nTarefas da tag 'job':");
        showTasks(taskList.getTasksByTag("job").getTasks());

        System.out.println("\nTarefas da tag 'study':");
        showTasks(taskList.getTasksByTag("study").getTasks());

        // 3 - Obter tarefa por Id
        System.out.println("\nTarefa de id 2:");
        System.out.println(taskList.getTaskById(2));

        System.out.println("\nTarefa de id 120 (inexistente):");
        System.out.println(taskList.getTaskById(120));

        // 4 - Remover tarefa por Id
        taskList.removeTaskById(3);
        System.out.println("\nRemovida tarefa de id 3:");
        showTasks(taskList.getTasks());

        // 5 - Marcar uma tarefa como concluída por Id
        System.out.println("\nTarefa 1 marcada como concluída:");
        taskList.setTaskToCompleted(1);
        showTasks(taskList.getTasks());

        System.out.println("\nTarefa 152 (inexistente) marcada como concluída:");
        taskList.setTaskToCompleted(152);
        showTasks(taskList.getTasks());

        // 6 - Atualizar dados de uma tarefa
        Task taskUpdate = new Task(null, "Reading working article", "job");
        taskList.setTaskDataById(7, taskUpdate);
        System.out.println("\nTarefa 7 com dados atualizados:");
        showTasks(taskList.getTasks());

        // 7 - Reposicionar uma tarefa
        taskList.move(7, 1);
        System.out.println("\nTarefa 7 movida para posição 1:");
        showTasks(taskList.getTasks());
        
        taskList.move(3, 5);
        System.out.println("\nTarefa 3 (inexistente) movida para posição 5:");
        showTasks(taskList.getTasks());
    }
}

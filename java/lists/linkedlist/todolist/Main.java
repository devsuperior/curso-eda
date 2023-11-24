package lists.linkedlist.todolist;

import java.util.List;

public class Main {

    public static void showTasks(List<Task> taskList) {
        if (taskList == null || taskList.isEmpty()) {
            System.out.println("Tasks not found");
            return;
        }
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
        showTasks(taskList.getTasks());

        // 2 - Obter tarefas por tag
        // System.out.println("\nShow tasks by job:");
        // showTasks(taskList.getTasksByTag("job"));

        // System.out.println("\nShow tasks by study:");
        // showTasks(taskList.getTasksByTag("study"));

        // 3 - Obter tarefa por Id
        // System.out.println("\nGet task by id: 2");
        // System.out.println(taskList.getTaskById(2));

        // System.out.println("\nGet task by id: 120");
        // System.out.println(taskList.getTaskById(120));

        // 4 - Remover tarefa por Id
        // int idToRemove = 3;
        // System.out.println("\nRemove task " + idToRemove + "...");
        // taskList.removeTaskById(idToRemove);
        // showTasks(taskList.getTasks());

        // 5 - Marcar uma tarefa como concluída por Id
        // int idToComplete = 1;
        // System.out.println("\nSet task " + idToComplete + " to completed...");
        // System.out.println(taskList.setTaskToCompleted(idToComplete));

        // int idToCompleteNonexistent = 152;
        // System.out.println("\nSet task " + idToCompleteNonexistent + " to completed...");
        // System.out.println(taskList.setTaskToCompleted(idToCompleteNonexistent));

        // 6 - Atualizar dados de uma tarefa
        // Task taskUpdate = new Task(null, "Reading working article", "job");
        // System.out.println(taskList.setTaskDataById(7, taskUpdate));
        // showTasks(taskList.getTasks());

        // 7 - Reposicionar uma tarefa
        // System.out.println("Moving the tasks...");
        // taskList.move(7, 1);
        // taskList.move(3, 5);
        // showTasks(taskList.getTasks());
    }
    
}

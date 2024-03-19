using System;
using System.Collections.Generic;

namespace Lists.LinkedList.TodoList
{
    public class Main
    {
        public static void ShowTasks(List<Task> taskList) {
            if (taskList == null || taskList.Count == 0) {
                Console.WriteLine("Tasks not found");
                return;
            }
            foreach (Task item in taskList) {
                Console.WriteLine(item);
            }
        }

        public static void Main(string[] args)
        {
            Task task1 = new Task(1, "Daily with the team", "meeting");
            Task task2 = new Task(2, "Implement some feature", "job");
            Task task3 = new Task(3, "Reeding a book", "study", TaskStatus.Completed);
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
            ShowTasks(taskList.GetTasks());

            // 2 - Obter tarefas por tag
            // Console.WriteLine("\nShow tasks by job:");
            // ShowTasks(taskList.GetTasksByTag("job"));

            // Console.WriteLine("\nShow tasks by study:");
            // ShowTasks(taskList.GetTasksByTag("study"));

            // 3 - Obter tarefa por Id
            // Console.WriteLine("\nGet task by id: 2");
            // Console.WriteLine(taskList.GetTaskById(2));

            // Console.WriteLine("\nGet task by id: 120");
            // Console.WriteLine(taskList.GetTaskById(120));

            // 4 - Remover tarefa por Id
            // int idToRemove = 3;
            // Console.WriteLine("\nRemove task " + idToRemove + "...");
            // taskList.RemoveTaskById(idToRemove);
            // ShowTasks(taskList.GetTasks());

            // 5 - Marcar uma tarefa como concluída por Id
            // int idToComplete = 1;
            // Console.WriteLine("\nSet task " + idToComplete + " to completed...");
            // Console.WriteLine(taskList.SetTaskToCompleted(idToComplete));

            // int idToCompleteNonexistent = 152;
            // Console.WriteLine("\nSet task " + idToCompleteNonexistent + " to completed...");
            // Console.WriteLine(taskList.SetTaskToCompleted(idToCompleteNonexistent));

            // 6 - Atualizar dados de uma tarefa
            // Task taskUpdate = new Task(null, "Reading working article", "job");
            // Console.WriteLine(taskList.SetTaskDataById(7, taskUpdate));
            // ShowTasks(taskList.GetTasks());

            // 7 - Reposicionar uma tarefa
            // Console.WriteLine("Moving the tasks...");
            // taskList.Move(7, 1);
            // taskList.Move(3, 5);
            // ShowTasks(taskList.GetTasks());
        }
    }
}

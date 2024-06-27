import { Task, TaskStatus } from "./task.js";
import TaskList from "./task-list.js";

const showTasks = (taskList) => {
  taskList.forEach((item) => {
    console.log(item.toString());
  });
};

const task1 = new Task(1, "Daily with the team", "meeting");
const task2 = new Task(2, "Implement some feature", "job");
const task3 = new Task(3, "Reeding a book", "study", TaskStatus.COMPLETED);
const task4 = new Task(4, "Review a documentation", "job");
const task5 = new Task(5, "Review a project", "meeting");
const task6 = new Task(6, "Deploy a project", "job");
const task7 = new Task(7, "Reeding article", "study");

const taskList = new TaskList();

taskList.addTask(task1);
taskList.addTask(task2);
taskList.addTask(task3, 0);
taskList.addTask(task4, 10);
taskList.addTask(task4);
taskList.addTask(task5, 2);
taskList.addTask(task6);
taskList.addTask(task7);

// 1 - Get all tasks
console.log("Tarefas:");
showTasks(taskList.getTasks());

// 2 - Get tasks by tag
console.log("\nTarefas da tag 'job':");
showTasks(taskList.getTasksByTag("job"));

console.log("\nTarefas da tag 'study':");
showTasks(taskList.getTasksByTag("study"));

// 3 - Get tasks by Id
console.log("\nTarefa de id 2:");
console.log(taskList.getTaskById(2)?.toString());

console.log("\nTarefa de id 120 (inexistente):");
console.log(taskList.getTaskById(120)?.toString());

// 4 - Remove tasks by Id
console.log("\nRemovida tarefa de id 3:");
taskList.removeTaskById(3);
showTasks(taskList.getTasks());

// 5 - Marcar uma tarefa como concluída por id
console.log("\nTarefa 1 marcada como concluída:");
taskList.setTaskToCompleted(1);
showTasks(taskList.getTasks());

console.log("\nTarefa 152 (inexistente) marcada como concluída:");
taskList.setTaskToCompleted(152);
showTasks(taskList.getTasks());

// 6 - Atualizar dados de uma task
const taskUpdate = new Task(null, "Reeding working article", "job");
taskList.setTaskDataById(7, taskUpdate);
console.log("\nTarefa 7 com dados atualizados:");
showTasks(taskList.getTasks());


// 7 - Reposicionar uma tarefa
taskList.move(7, 1);
console.log("\nTarefa 7 movida para posição 1:");
showTasks(taskList.getTasks());

taskList.move(3, 5);
console.log("\nTarefa 3 (inexistente) movida para posição 5:");
showTasks(taskList.getTasks());

import { Task, TaskStatus } from "./task.js";
import TaskList from "./task-list.js"

/* funcao que interage com UI nao deve estar na classe de dominio */
const showTasks = (taskList) => {
    taskList.forEach((item) => {
        showTask(item);
    });
};

const showTask = (item) => {
    if (item == null) {
        console.log(`Task not found`);
        return;
    }
    console.log(`Task ${item.id}: ${item.description} | Tag: ${item.tag} | Status: ${item.status}`);
};

const task1 = new Task(1, "Daily with the team", "meeting");
const task2 = new Task(2, "Implement some feature", "job");
const task3 = new Task(3, "Reeding a book", "study", TaskStatus.COMPLETED);
const task4 = new Task(4, "Review a documentation", "job");
const task5 = new Task(5, "Review a project", "meeting");
const task6 = new Task(6, "Deploy a project", "job");
const task7 = new Task(7, "Reeding article", "study");

const taskList = new TaskList();
showTasks(taskList.getTasks());

taskList.addTask(task1);
taskList.addTask(task2);
taskList.addTask(task3, 0);
taskList.addTask(task4, 10);
taskList.addTask(task4);
taskList.addTask(task5, 2);
taskList.addTask(task6);
taskList.addTask(task7);

// 1 - Get all tasks
// showTasks(taskList.getTasks());

// 2 - Get tasks by tag
// console.log("Show tasks by job:");
// showTasks(taskList.getTasksByTag("job"));

// console.log("Show tasks by study:");
// showTasks(taskList.getTasksByTag("study"));

// 3 - Get tasks by Id
// print("Get task by id: 2")
// showTask(taskList.getTaskById(2));

// print("Get task by id: 120")
// showTask(taskList.getTaskById(120));

// 4 - Remove tasks by Id
// let id = 3;
// console.log(`Remove task ${id}...`);
// taskList.removeTaskById(id);
// showTasks(taskList.getTasks());

// 5 - Marcar uma tarefa como concluída por id
// let id = 1;
// console.log(`Set task ${id} to completed...`);
// showTask(taskList.setTaskToCompleted(id));

// id = 152;
// console.log(`Set task ${id} to completed...`);
// showTask(taskList.setTaskToCompleted(id));

// 6 - Atualizar dados de uma task
// const taskUpdate = new Task(null, "Reeding working article", "job");
// showTask(taskList.setTaskDataById(7, taskUpdate));

// 7 - Reposicionar uma tarefa
// console.log(taskList.move(7, 1));
// console.log(taskList.move(3, 5));
// showTasks(taskList.getTasks());

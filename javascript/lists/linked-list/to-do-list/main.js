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
    console.log(`
        Task ${item.id}:
        desc: ${item.description},
        tag: ${item.tag},
        status: ${item.status}
    `);
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
showTasks(taskList.getTasks());

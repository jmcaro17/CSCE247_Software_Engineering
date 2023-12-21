package model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * The TaskList class manages a list of tasks in the system.
 */
public class TaskList {

    // Singleton instance of TaskList
    private static TaskList taskList;

    // List of tasks
    private ArrayList<Task> tasks;

    /**
     * Private constructor to initialize the TaskList with data from DataLoader.
     */
    private TaskList() {
        tasks = DataLoader.getTasks();
    }

    /**
     * Get the singleton instance of TaskList.
     *
     * @return The singleton TaskList instance.
     */
    public static TaskList getInstance() {
        if (taskList == null) {
            taskList = new TaskList();
        }
        return taskList;
    }

    /**
     * Get a task by its unique ID.
     *
     * @param id The unique task ID to look for.
     * @return The task with the specified ID, or null if not found.
     */
    public Task getTask(UUID id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

    /**
     * Get the list of all tasks in the system.
     *
     * @return ArrayList containing all the tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void SaveTasks() {
        DataWriter.saveTasks();
    }
}

package model;

import java.util.ArrayList;

/**
 * The Column class represents a column in a task management system.
 */
public class Column {
    private String title;
    private ArrayList<Task> tasks = new ArrayList<Task>();

    /**
     * Constructor to create a new Column with a specified title.
     *
     * @param title The title of the column.
     */
    public Column(String title) {
        this.title = title;
    }

    /**
     * Constructor to create a new Column with a specified title and a list of
     * tasks.
     *
     * @param title The title of the column.
     * @param tasks The list of tasks in the column.
     */
    public Column(String title, ArrayList<Task> tasks) {
        this.title = title;
        this.tasks = tasks;
    }

    /**
     * Add a task to the column.
     *
     * @param task The task to be added to the column.
     * @return The added task.
     */
    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    /**
     * Remove a task from the column.
     *
     * @param task The task to be removed from the column.
     * @return true if the task was removed successfully, false otherwise.
     */
    public boolean removeTask(Task task) {
        return tasks.remove(task);
    }

    /**
     * Edit the title of the column.
     *
     * @param title The new title for the column.
     * @return The updated title.
     */
    public String editTitle(String title) {
        this.title = title;
        return title;
    }

    /**
     * Get the title of the column.
     *
     * @return The title of the column.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the list of tasks in the column.
     *
     * @return ArrayList containing all the tasks in the column.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}

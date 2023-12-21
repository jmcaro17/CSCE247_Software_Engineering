package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/*
class Project holds the information for the SCRUM board including columns, admins, and taskTypes
 */
public class Project {
    private UUID id;
    private String title;
    private ArrayList<Column> columns = new ArrayList<Column>();
    private ArrayList<User> admins = new ArrayList<User>();
    private ArrayList<String> taskTypes = new ArrayList<>(Arrays.asList("BUG", "NEWFEATURE", "DOCUMENTATION", "TESTING", "WONTFIX"));

    /*
    method Project gives String title an ID and assigns a title to a project
    @param String title is what is getting a String assigned
     */
    public Project(String title) {
        this.id = UUID.randomUUID();
        this.title = title;
    }

    /*
    Project method holds the information that will be put in when a project is created
    @param UUID id
    @param String title
    @param ArrayList<Column> columns
    @param ArrayList<User> admins
     */
    public Project(UUID id, String title, ArrayList<Column> columns, ArrayList<User> admins) {
        this.id = id;
        this.title = title;
        this.columns = columns;
        this.admins = admins;
    }

    /*
    @return id - returns the id assigned to the project
     */
    public UUID getId() {
        return id;
    }

    /*
    @return title - returns the title of the project
     */
    public String getTitle() {
        return title;
    }

    /*

     */
    public String editTitle(String title) {
        this.title = title;
        return title;
    }

    public ArrayList<Column> getColumns() {
        return columns;
    }

    public ArrayList<User> getAdmins() {
        return admins;
    }

    public Column addColumn(Column column) {
        columns.add(column);
        return column;
    }

    public boolean removeColumn(Column column) {
        return columns.remove(column);
    }

    public User addAdmin(User user) {
        admins.add(user);
        return user;
    }

    public boolean removeAdmin(User user) {
        return admins.remove(user);
    }

    public boolean isAdmin(User user) {
        return admins.contains(user);
    }

    public String addTaskType(String taskType) {
        if(taskTypes.contains(taskType)) {
            return null;
        }
        taskTypes.add(taskType);
        return taskType;
    }

    public boolean removeTaskType(String taskType) {
        return taskTypes.remove(taskType);
    }

    public ArrayList<String> getTaskTypes() {
        return taskTypes;
    }
}

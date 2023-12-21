package model;

import java.util.Date;

/**
 * This class represents the facade for the Project Management System.
 */
public class ProjectSystemFACADE {
    protected User user;
    protected Project project;
    private static ProjectSystemFACADE facade;

    public static ProjectSystemFACADE getInstance(){
        if(facade == null){
            facade = new ProjectSystemFACADE();
        }
        return facade;
    }

    private ProjectSystemFACADE(){
        
    }

    /**
     * Gets the currently logged-in user.
     *
     * @return The user currently logged in.
     */
    public User getUser() {
        return user;
    }

    /**
     * Gets the currently selected project.
     *
     * @return The selected project.
     */
    public Project getProject() {
        return project;
    }

    public User signUp(String userName, String password, String email, String firstName, String lastName) {
        if(userName == null || password == null || email == null || firstName == null || lastName == null) {
            return null;
        }
        if(userName == "" || password == "" || email == "" || firstName == "" || lastName == "") {
            return null;
        }
        this.user = new User(firstName, lastName, email, userName, password);
        UserList.getInstance().addUser(user);
        return setUser(user);
    }

    /**
     * Logs in a user with the provided username and password.
     *
     * @param userName The username to log in with.
     * @param password The password for authentication.
     * @return The logged-in user, or null if login fails.
     */
    public User login(String userName, String password) {
        UserList userList = UserList.getInstance();
        return userList.login(userName, password);
    }

    /**
     * Logs out the currently logged-in user.
     *
     * @return True if logout is successful, false if no user is logged in.
     */
    public boolean logout() {
        if (this.user == null) {
            return false;
        }
        this.user = null;
        return true;
    }

    /**
     * Sets the current project for the logged-in user.
     *
     * @param project The project to set as current.
     * @return The selected project.
     */
    public Project setProject(Project project) {
        this.project = project;
        return project;
    }

    public User setUser(User user) {
        this.user = user;
        return user;
    }

     /**
     * Creates a new project with the given title.
     *
     * @param title The title of the new project.
     * @return The newly created project.
     */
    public Project createProject(String title) {
        return new Project(title);
    }

    /**
     * Edits the title of the current project if the logged-in user is an admin.
     *
     * @param title The new title to set for the project.
     * @return The updated project title, or null if the user is not an admin.
     */
    public String editProjectTitle(String title) {
        if (!project.isAdmin(user)) {
            return null;
        }
        if (title == null || title == "") {
            return null;
        }
        return project.editTitle(title);
    }

    /**
     * Archives the current project if it belongs to the logged-in user's current projects.
     *
     * @return The archived project.
     */
    public Project archiveProject() {
        if (user.getCurrentProjects().contains(project)) {
            user.addArchivedProject(project);
            user.removeCurrentProject(project);
        }
        return project;
    }

    /**
     * Adds a team member to the current project if the logged-in user is an admin.
     *
     * @param user The user to be added as a team member.
     * @return True if the user is added, false if the user is not an admin.
     */
    public boolean addTeamMember(User user) {
        if (!project.isAdmin(this.user)) {
            return false;
        }
        user.addCurrentProject(project);
        return true;
    }

    /**
     * Removes a team member from the current project if the logged-in user is an admin.
     *
     * @param user The user to be removed as a team member.
     * @return True if the user is removed, false if the user is not an admin.
     */
    public boolean removeTeamMember(User user) {
        if (!project.isAdmin(this.user)) {
            return false;
        }
        user.removeCurrentProject(project);
        return true;
    }

    public boolean addAdmin(User user) {
        if(!project.isAdmin(this.user)) {
            return false;
        }
        this.project.addAdmin(user);
        return true;
    }

    public boolean removeAdmin(User user) {
        if(!project.isAdmin(this.user)) {
            return false;
        }
        this.project.removeAdmin(user);
        return true;
    }

    public Column createColumn(String title) {
        return new Column(title);
    }

    /**
     * Adds a column to the specified project.
     *
     * @param column The column to add.
     * @param project The project to which the column should be added.
     * @return The project with the added column.
     */
    public Column addColumn(Column column, Project project) {
        return project.addColumn(column);
    }

    /**
     * Removes a column from the specified project.
     *
     * @param column The column to remove.
     * @param project The project from which the column should be removed.
     * @return True if the column is successfully removed, false otherwise.
     */
    public boolean removeColumn(Column column, Project project) {
        return project.removeColumn(column);
    }

    /**
     * Assigns a user to a task.
     *
     * @param task The task to which the user should be assigned.
     * @param assignee The user to be assigned to the task.
     * @return The updated user assigned to the task.
     */
    public User assignUser(Task task, User assignee) {
        return task.editAssignee(assignee);
    }

    /**
     * Creates a new task with the specified attributes.
     *
     * @param title The title of the task.
     * @param priority The priority of the task.
     * @param taskType The type of the task.
     * @param details Additional details about the task.
     * @param assignee The user to be assigned to the task.
     * @return The newly created task.
     */
    public Task createTask(String title, int priority, String taskType, String details, User assignee) {
        if(title == null) {
            return null;
        }
        return new Task(title, priority, taskType, details, assignee);
    }

    /**
     * Adds a task to a column.
     *
     * @param task The task to be added.
     * @param column The column to which the task should be added.
     * @return The column with the added task.
     */
    public Task addTask(Task task, Column column) {
        return column.addTask(task);
    }

    /**
     * Removes a task from a column.
     *
     * @param task The task to be removed.
     * @param column The column from which the task should be removed.
     * @return True if the task is successfully removed, false otherwise.
     */
    public boolean removeTask(Task task, Column column) {
        return column.removeTask(task);
    }

    /**
     * Moves a task from one column to another.
     *
     * @param task The task to be moved.
     * @param moveFrom The source column from which the task should be removed.
     * @param moveTo The destination column to which the task should be added.
     * @return The task after the move, or null if the task cannot be removed from the source column.
     */
    public Task moveTask(Task task, Column moveFrom, Column moveTo) {
        if (!moveFrom.removeTask(task)) {
            return null;
        }
        return moveTo.addTask(task);
    }

     /**
     * Creates a new comment with the specified note, user, and date.
     *
     * @param note The content of the comment.
     * @param user The user who created the comment.
     * @param date The date and time when the comment was created.
     * @return The newly created comment.
     */
    public Comment createComment(String note, User user, Date date) {
        return new Comment(note, user, date);
    }

    /**
     * Adds a comment to a task.
     *
     * @param comment The comment to be added.
     * @param task The task to which the comment should be added.
     * @return The task with the added comment.
     */
    public Comment addComment(Comment comment, Task task) {
        return task.addComment(comment);
    }

    /**
     * Creates a reply to an existing comment.
     *
     * @param reply The content of the reply.
     * @param user The user who created the reply.
     * @param date The date and time when the reply was created.
     * @param comment The parent comment to which the reply is added.
     * @return The newly created reply.
     */
    public Comment createReply(String reply, User user, Date date, Comment comment) {
        return comment.addReply(new Comment(reply, user, date));
    }

    /**
     * Edits an existing comment's content and date.
     *
     * @param note The updated content of the comment.
     * @param date The updated date and time of the comment.
     * @param comment The comment to be edited.
     * @return The comment after editing.
     */
    public Comment editComment(String note, Date date, Comment comment) {
        comment.editNote(note);
        comment.editDate(date);
        return comment;
    }

    public void setUpEnvironment() {
        User user1 = signUp("preed", "password", "preed@email.com", "paul", "reed");
        Project project1 = new Project("Building Rocket Ship's!");
        Project project2 = new Project("Scanning Space Rocks");
        Column column1 = new Column("To do");
        Column column2 = new Column("In Progress");
        Column column3 = new Column("Done");
        Task task1 = new Task("working on engines", 3,"NEWFEATURE", "details for task", user1);
        Task task2 = new Task("fueling rocket", 2, "NEWFEATURE", "details for task", user1);
        Task task3 = new Task("Secondary testing all rocks", 2, "NEWFEATURE", "details for task", user1);
        Task task4 = new Task("Primary testing all rocks", 3, "NEWFEATURE", "details for task", user1);
        Task task5 = new Task("Secondary testing all rocks", 2, "NEWFEATURE", "details for task", user1);
        Task task6 = new Task("Primary testing all rocks", 3, "NEWFEATURE", "details for task", user1);

        user1.addCurrentProject(project1);
        user1.addCurrentProject(project2);
        project1.addColumn(column1);
        project1.addColumn(column2);
        project1.addColumn(column3);
        column1.addTask(task1);
        column1.addTask(task2);
        column2.addTask(task3);
        column2.addTask(task4);
        column3.addTask(task5);
        column3.addTask(task6);

    }
}

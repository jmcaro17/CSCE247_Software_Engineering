package model;

/**
 * The DataConstants class contains constant strings used for data management in
 * the project management system.
 */
public abstract class DataConstants {
    // User-related constants
    protected static final String USER_FILE_NAME = "src/main/java/data/users.json";
    protected static final String USER_ID = "id";
    protected static final String USER_USER_NAME = "userName";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_EMAIL = "email";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_CURRENT_PROJECTS = "currentProjects";
    protected static final String USER_ARCHIVED_PROJECTS = "archivedProjects";

    // Project-related constants
    protected static final String PROJECT_FILE_NAME = "src/main/java/data/projects.json";
    protected static final String PROJECT_ID = "id";
    protected static final String PROJECT_TITLE = "title";
    protected static final String PROJECT_COLUMNS = "columns";
    protected static final String PROJECT_ADMINS = "admins";

    // Task-related constants
    protected static final String TASK_FILE_NAME = "src/main/java/data/taskstest.json";
    protected static final String TASK_TITLE = "title";
    protected static final String TASK_ID = "id";
    protected static final String TASK_PRIORITY = "priority";
    protected static final String TASK_PROGRESS = "progress";
    protected static final String TASK_TYPE = "taskType";
    protected static final String TASK_DETAILS = "details";
    protected static final String TASK_ASSIGNEE = "assignee";
    protected static final String TASK_COMMENTS = "userComments";
    protected static final String TASK_HISTORY = "taskHistory";

    // Column-related constants
    protected static final String COLUMN_NAME = "name";
    protected static final String COLUMN_TASKS = "tasks";
    protected static final String COLUMN_HEAD = "columns";

    // Comment-related constants
    protected static final String COMMENT_NOTE = "note";
    protected static final String COMMENT_USER = "user";
    protected static final String COMMENT_DATE = "date";
    protected static final String COMMENT_REPLIES = "replies";
    protected static final String COMMENT_HEAD = "userComments";

    // Task history-related constants
    protected static final String TASK_HISTORY_NOTE = "note";
    protected static final String TASK_HISTORY_DATE = "date";
    protected static final String TASK_HISTORY_HEAD = "taskHistory";
}

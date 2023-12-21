package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * ANY EDIT METHODS NEED TO UPDATE TASK HISTORY!!!
 */
public class Task {
    private UUID id;
    private String title;
    private int priority;
    private int progress;
    private String taskType;
    private String details;
    private User assignee;
    private ArrayList<Comment> userComments = new ArrayList<Comment>();
    private ArrayList<Change> taskHistory = new ArrayList<Change>();

    public Task(String title, int priority, String taskType, String details, User assginee) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.priority = priority;
        this.progress = 0;
        this.taskType = taskType;
        this.details = details;
        this.assignee = assginee;
    }

    public Task(UUID id, String title, int priority, int progress, String taskType, String details, User assignee,
            ArrayList<Comment> userComments, ArrayList<Change> taskHistory) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.progress = progress;
        this.taskType = taskType;
        this.details = details;
        this.assignee = assignee;
        this.userComments = userComments;
        this.taskHistory = taskHistory;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String editTitle(String title, Date date) {
        addChange(new Change("Title changed from " + this.title + " to " + title, date));
        this.title = title;
        return title;
    }

    public int getPriority() {
        return priority;
    }

    public int editPriority(int priority, Date date) {
        if (priority < 1 || priority > 3) {
            return this.priority;
        }
        addChange(new Change("Priority changed from " + this.priority + " to " + priority, date));
        this.priority = priority;
        return priority;
    }

    public int getProgress() {
        return progress;
    }

    public int editProgress(int progress, Date date) {
        if (progress < 0 || progress > 100) {
            return this.progress;
        }
        addChange(new Change("Progress changed from " + this.progress + " to " + progress, date));
        this.progress = progress;
        return progress;
    }

    public String getTaskType() {
        return taskType;
    }

    public boolean editTaskType(String taskType, Project project) {
        if (project.getTaskTypes().contains(taskType)) {
            this.taskType = taskType;
            return true;
        }
        return false;
    }

    public String getDetails() {
        return details;
    }

    public String editDetails(String details, Date date) {
        addChange(new Change("Details changed from " + this.details + " to " + details, date));
        this.details = details;
        return details;
    }

    public User getAssignee() {
        return assignee;
    }

    public User editAssignee(User assignee) {
        this.assignee = assignee;
        return assignee;
    }

    public ArrayList<Change> getTaskHistory() {
        return taskHistory;
    }

    public ArrayList<Comment> getComments() {
        return userComments;
    }

    public Comment addComment(Comment comment) {
        addChange(new Change("Comment added: " + comment.getNote(), comment.getDate()));
        userComments.add(comment);
        return comment;
    }

    public boolean deleteComment(Comment comment, Date date) {
        if (userComments.remove(comment) == false) {
            return false;
        }
        addChange(new Change("Comment removed: " + comment.getNote(), date));
        return true;
    }

    public Change addChange(Change change) {
        taskHistory.add(change);
        return change;
    }
}

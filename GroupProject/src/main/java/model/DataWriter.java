package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

	public static void main(String args[]) {
		saveTasks();
	}

	public static void saveUsers() {
		UserList userList = UserList.getInstance();
		ArrayList<User> users = userList.getUsers();
		JSONArray jsonUsers = new JSONArray();

		// creating all the json objects
		for (int i = 0; i < users.size(); i++) {
			jsonUsers.add(getUserJSON(users.get(i)));
		}

		// Write JSON file
		try (FileWriter file = new FileWriter(USER_FILE_NAME)) {

			file.write(jsonUsers.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_ID, user.getId().toString());
		userDetails.put(USER_USER_NAME, user.getUsername());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_EMAIL, user.getEmail());
		userDetails.put(USER_PASSWORD, user.getPassword());
		userDetails.put(USER_CURRENT_PROJECTS, user.getCurrentProjects());
		userDetails.put(USER_ARCHIVED_PROJECTS, user.getArchivedProjects());

		return userDetails;
	}

	public static void saveProjects() {
		ProjectList projectList = ProjectList.getInstance();
		ArrayList<Project> projects = projectList.getProjects();
		JSONArray jsonProjects = new JSONArray();

		// creating all the json objects
		for (int i = 0; i < projects.size(); i++) {
			jsonProjects.add(getProjectJSON(projects.get(i)));
		}

		// Write JSON file
		try (FileWriter file = new FileWriter(PROJECT_FILE_NAME)) {

			file.write(jsonProjects.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getProjectJSON(Project project) {
		JSONObject projectDetails = new JSONObject();
		projectDetails.put(PROJECT_ID, project.getId().toString());
		projectDetails.put(PROJECT_TITLE, project.getTitle());
		projectDetails.put(COLUMN_HEAD, project.getColumns());
		projectDetails.put(PROJECT_ADMINS, project.getAdmins());

		return projectDetails;
	}

	public static void saveTasks() {
		TaskList taskList = TaskList.getInstance();
		ArrayList<Task> tasks = taskList.getTasks();
		JSONArray jsonTasks = new JSONArray();

		// creating all the json objects
		for (int i = 0; i < tasks.size(); i++) {
			jsonTasks.add(getTaskJSON(tasks.get(i)));
		}

		// Write JSON file
		try (FileWriter file = new FileWriter(TASK_FILE_NAME)) {

			file.write(jsonTasks.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getTaskJSON(Task task) {
		JSONObject taskDetails = new JSONObject();
		taskDetails.put(TASK_TITLE, task.getTitle());
		taskDetails.put(TASK_PRIORITY, task.getPriority());
		taskDetails.put(TASK_PROGRESS, task.getProgress());
		taskDetails.put(TASK_TYPE, task.getTaskType());
		taskDetails.put(TASK_DETAILS, task.getDetails());
		taskDetails.put(TASK_ASSIGNEE, task.getAssignee());
		taskDetails.put(COMMENT_HEAD, task.getComments());
		taskDetails.put(TASK_HISTORY_HEAD, task.getTaskHistory());

		return taskDetails;
	}

	public static void saveColumns(ArrayList<Column> columns) {

		JSONArray jsonColumns = new JSONArray();

		// creating all the json objects
		for (int i = 0; i < columns.size(); i++) {
			jsonColumns.add(getColumnJSON(columns.get(i)));
		}

		// Write JSON file
		try (FileWriter file = new FileWriter(PROJECT_FILE_NAME)) {

			file.write(jsonColumns.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getColumnJSON(Column column) {
		JSONObject columnDetails = new JSONObject();
		columnDetails.put(COLUMN_NAME, column.getTitle());
		columnDetails.put(COLUMN_TASKS, column.getTasks());

		return columnDetails;
	}

	public static void saveComments(ArrayList<Comment> comment) {

		JSONArray jsonComments = new JSONArray();

		// creating all the json objects
		for (int i = 0; i < comment.size(); i++) {
			jsonComments.add(getCommentJSON(comment.get(i)));
		}

		// Write JSON file
		try (FileWriter file = new FileWriter(TASK_FILE_NAME)) {

			file.write(jsonComments.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getCommentJSON(Comment comment) {
		JSONObject commentDetails = new JSONObject();
		commentDetails.put(COMMENT_NOTE, comment.getNote());
		commentDetails.put(COMMENT_USER, comment.getUser());
		commentDetails.put(COMMENT_DATE, comment.getDate());
		commentDetails.put(COMMENT_REPLIES, comment.getReplies());

		return commentDetails;
	}

	public static void saveTaskHistories(ArrayList<Change> taskHistory) {

		JSONArray jsonTaskHistories = new JSONArray();

		// creating all the json objects
		for (int i = 0; i < taskHistory.size(); i++) {
			jsonTaskHistories.add(getTaskHistoryJSON(taskHistory.get(i)));
		}

		// Write JSON file
		try (FileWriter file = new FileWriter(TASK_FILE_NAME)) {

			file.write(jsonTaskHistories.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getTaskHistoryJSON(Change change) {
		JSONObject taskHistoryDetails = new JSONObject();
		taskHistoryDetails.put(TASK_HISTORY_NOTE, change.getNote());
		taskHistoryDetails.put(TASK_HISTORY_DATE, change.getDate());

		return taskHistoryDetails;
	}
}
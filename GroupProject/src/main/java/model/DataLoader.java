package model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class DataLoader extends DataConstants {

	public static void main(String[] args) {
		getProjects();
	}

	public static ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();

		try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray peopleJSON = (JSONArray) new JSONParser().parse(reader);

			for (int i = 0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject) peopleJSON.get(i);
				UUID id = UUID.fromString((String) personJSON.get(USER_ID));
				String firstName = (String) personJSON.get(USER_FIRST_NAME);
				String lastName = (String) personJSON.get(USER_LAST_NAME);
				String email = (String) personJSON.get(USER_EMAIL);
				String userName = (String) personJSON.get(USER_USER_NAME);
				String password = (String) personJSON.get(USER_PASSWORD);
				ArrayList<Project> currentProjects = (ArrayList<Project>) personJSON.get(USER_CURRENT_PROJECTS);
				ArrayList<Project> archivedProjects = (ArrayList<Project>) personJSON.get(USER_ARCHIVED_PROJECTS);
				users.add(new User(id, firstName, lastName, email, userName, password, currentProjects,
						archivedProjects));
			}

			return users;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static ArrayList<Project> getProjects() {
		ArrayList<Project> projects = new ArrayList<Project>();

		try {
			FileReader reader = new FileReader(PROJECT_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray projectsJSON = (JSONArray) parser.parse(reader);

			for (int i = 0; i < projectsJSON.size(); i++) {
				JSONObject projectJSON = (JSONObject) projectsJSON.get(i);
				System.out.println(projectJSON.get(PROJECT_ID));
				UUID id = UUID.fromString((String) projectJSON.get(PROJECT_ID));
				// something in the json object above^
				String title = (String) projectJSON.get(PROJECT_TITLE);
				ArrayList<Column> columns = getColumns(PROJECT_COLUMNS); // Use your existing method
				ArrayList<User> admins = (ArrayList<User>) projectJSON.get(PROJECT_ADMINS);
				projects.add(new Project(id, title, columns, admins));
			}

			return projects;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static ArrayList<Task> getTasks() {
		ArrayList<Task> tasks = new ArrayList<Task>();

		try {
			FileReader reader = new FileReader(TASK_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray tasksJSON = (JSONArray) parser.parse(reader);

			for (int i = 0; i < tasksJSON.size(); i++) {
				JSONObject taskJSON = (JSONObject) tasksJSON.get(i);
				UUID id = UUID.fromString((String) taskJSON.get(TASK_ID));
				String title = (String) taskJSON.get(TASK_TITLE);
				int priority = ((Long) taskJSON.get(TASK_PRIORITY)).intValue();
				int progress = ((Long) taskJSON.get(TASK_PROGRESS)).intValue();
				String type = (String) taskJSON.get(TASK_TYPE);
				String details = (String) taskJSON.get(TASK_DETAILS);
				User assignee = (User) taskJSON.get(TASK_ASSIGNEE);

				ArrayList<Comment> comments = getComments(TASK_COMMENTS); // Use your existing method
				ArrayList<Change> taskHistory = getTaskHistory(TASK_HISTORY); // Use your existing method
				tasks.add(new Task(id, title, priority, progress, type, details, assignee, comments, taskHistory));
			}

			return tasks;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static ArrayList<Column> getColumns(String PROJECT_FILE_NAME) {
		ArrayList<Column> columns = new ArrayList<Column>();

		try {
			JSONParser parser = new JSONParser();
			JSONArray columnsArray = (JSONArray) parser.parse(new FileReader(PROJECT_FILE_NAME));

			for (Object columnsObj : columnsArray) {
				JSONObject columnsJSON = (JSONObject) columnsObj;
				JSONArray columnArray = (JSONArray) columnsJSON.get(COLUMN_HEAD);

				for (Object valueColumnObj : columnArray) {
					JSONObject valueColumnJson = (JSONObject) valueColumnObj;
					String title = (String) valueColumnJson.get(COLUMN_NAME);
					ArrayList<Task> tasks = (ArrayList<Task>) valueColumnJson.get(COLUMN_TASKS);

					columns.add(new Column(title, tasks));
				}
			}

			return columns;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static ArrayList<Comment> getComments(String TASK_FILE_NAME) {
		ArrayList<Comment> comments = new ArrayList<>();

		try {
			// Read the JSON file
			JSONParser parser = new JSONParser();
			JSONArray commentsArray = (JSONArray) parser.parse(new FileReader(TASK_FILE_NAME));
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

			for (Object commentObj : commentsArray) {
				JSONObject commentJson = (JSONObject) commentObj;
				JSONArray userCommentsArray = (JSONArray) commentJson.get(COMMENT_HEAD);

				for (Object userCommentObj : userCommentsArray) {
					JSONObject userCommentJson = (JSONObject) userCommentObj;
					String note = (String) userCommentJson.get(COMMENT_NOTE);
					System.out.println("NOTE: " + note);

					String user = (String) userCommentJson.get(COMMENT_USER);
					String userNum = null; // Default value in case "user" is missing or null

					if (user != null) {
						userNum = user;
					}
					String dateStr = (String) userCommentJson.get(COMMENT_DATE);

					JSONArray userRepliesArray = userCommentJson.containsKey(COMMENT_REPLIES)
							? (JSONArray) userCommentJson.get(COMMENT_REPLIES)
							: new JSONArray(); // Create an empty array if "replies" doesn't exist

					for (Object repliesObj : userRepliesArray) {
						JSONObject userRepliesJson = (JSONObject) repliesObj;
						String replyNote = (String) userRepliesJson.get(COMMENT_NOTE);
						String replyUser = (String) userRepliesJson.get(COMMENT_USER);
						String replydateStr = (String) userRepliesJson.get(COMMENT_DATE);
					}
				}
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return comments;
	}

	public static ArrayList<Change> getTaskHistory(String TASK_FILE_NAME) {
		ArrayList<Change> taskHistoryList = new ArrayList<>();

		try {
			// Read the JSON file
			JSONParser parser = new JSONParser();
			JSONArray tasksArray = (JSONArray) parser.parse(new FileReader(TASK_FILE_NAME));

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

			for (Object taskObj : tasksArray) {
				JSONObject taskJson = (JSONObject) taskObj;
				JSONArray taskHistoryArray = (JSONArray) taskJson.get(TASK_HISTORY_HEAD);

				for (Object historyObj : taskHistoryArray) {
					JSONObject historyJson = (JSONObject) historyObj;
					String note = (String) historyJson.get(TASK_HISTORY_NOTE);
					String dateStr = (String) historyJson.get(TASK_HISTORY_DATE);

					Date date;

					if (dateStr.equals(TASK_HISTORY_DATE)) {
						// If the date is "date," use the current date and time
						date = new Date();
					} else {
						// Otherwise, parse the date string
						date = dateFormat.parse(dateStr);
					}

					// Create a new Change object and add it to the task history list
					Change change = new Change(note, date);
					taskHistoryList.add(change);
				}
			}
		} catch (IOException | ParseException | java.text.ParseException e) {
			e.printStackTrace();
		}

		return taskHistoryList;
	}

}
package model;

import java.util.ArrayList;
import java.util.UUID;

/*
public class User includes the user's first and last name, email, username, password, and both projects both current and archived
 */
public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private ArrayList<Project> currentProjects = new ArrayList<Project>();
    private ArrayList<Project> archivedProjects = new ArrayList<Project>();

    /*
     * User method holds the information that will be put in when the user is
     * signing up
     * 
     * @param String firstName
     * 
     * @param String lastName
     * 
     * @param String email
     * 
     * @param String userName
     * 
     * @param String password
     */
    public User(String firstName, String lastName, String email, String userName, String password) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    /*
     * This is the information that is saved to the JSON file
     * 
     * @param id - the random uuid that is given when the user signs up is saved
     * 
     * @param currentProjects - the user's current projects are saved to the JSON
     * file
     * 
     * @param archivedProjects - the user's archived projects are saved to the JSON
     * file
     */
    public User(UUID id, String firstName, String lastName, String email, String userName, String password,
            ArrayList<Project> currentProjects, ArrayList<Project> archivedProjects) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.currentProjects = currentProjects;
        this.archivedProjects = archivedProjects;
    }

    /*
     * method addCurrentProject uses ArrayList currentProject and stores a project
     * in it
     * 
     * @param Project project - takes a project from the object Project
     * 
     * @return project - returns the project that was just stored in the ArrayList
     * currentProject
     */
    public Project addCurrentProject(Project project) {
        currentProjects.add(project);
        return project;
    }

    /*
     * method removeCurrentProject uses ArrayList currentProject and removes a
     * project from it
     * 
     * @param Project project - takes a project from the object Project
     * 
     * @return currentProjects - returns the currentProjects ArrayList updated
     */
    public boolean removeCurrentProject(Project project) {
        return currentProjects.remove(project);
    }

    /*
     * method addArchivedProject uses ArrayList archivedProject and stores a project
     * in it
     * 
     * @param Project project - takes a project from the object Project
     * 
     * @return project - returns the project that was just stored in the ArrayList
     * archivedProject
     */
    public Project addArchivedProject(Project project) {
        archivedProjects.add(project);
        return project;
    }

    /*
     * method removeArchivedProject uses ArrayList archivedProject and removes a
     * project from it
     * 
     * @param Project project - takes a project from the object Project
     * 
     * @return currentProjects - returns the archivedProjects ArrayList updated
     */
    public boolean removeArchivedProject(Project project) {
        return archivedProjects.remove(project);
    }

    /*
     * method editFirstName allows edits to be made to String name
     * 
     * @param String name - the string that is being edited
     * 
     * @return name - firstName is equal to the String name
     */
    public String editFirstName(String name) {
        this.firstName = name;
        return name;
    }

    /*
     * method editLastName allows edits to be made to String name
     * 
     * @param String name - the string that is being edited
     * 
     * @return name - lastName is equal to the String name
     */
    public String editLastName(String name) {
        this.lastName = name;
        return name;
    }

    /*
     * method editEmail allows edits to be made to String email
     * 
     * @param String email - the string that is being edited
     * 
     * @return name - email is equal to the String email
     */
    public String editEmail(String email) {
        this.email = email;
        return email;
    }

    /*
     * method editUsername allows edits to be made to String username
     * 
     * @param String username - the string that is being edited
     * 
     * @return username - userName is equal to the String username
     */
    public String editUsername(String username) {
        this.userName = username;
        return username;
    }

    /*
     * method editPassword allows edits to be made to String password
     * 
     * @param String password - the string that is being edited
     * 
     * @return password - password is equal to the String password
     */
    public String editPassword(String password) {
        this.password = password;
        return password;
    }

    /*
     * method getID allows a user to get an ID
     * 
     * @return id - id is being saved to the JSON file
     */
    public UUID getId() {
        return id;
    }

    /*
     * @return firstName - returns the firstName String for the user
     */
    public String getFirstName() {
        return firstName;
    }

    /*
     * @return lastName - returns the lastName String for the user
     */
    public String getLastName() {
        return lastName;
    }

    /*
     * @return email - returns the email String for the user
     */
    public String getEmail() {
        return email;
    }

    /*
     * @return userName - returns the userName String for the user
     */
    public String getUsername() {
        return userName;
    }

    /*
     * @return password - returns the password String for the user
     */
    public String getPassword() {
        return password;
    }

    /*
     * @return currentProjects - returns the currentProjects array for the user
     */
    public ArrayList<Project> getCurrentProjects() {
        return currentProjects;
    }

    /*
     * @return archivedProjects - returns the archivedProjects array for the user
     */
    public ArrayList<Project> getArchivedProjects() {
        return archivedProjects;
    }

}

package model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * The UserList class manages a list of users in the system.
 */
public class UserList {

    // Singleton instance of UserList
    protected static UserList userList;

    // List of users
    protected ArrayList<User> users;

    /**
     * Private constructor to initialize the UserList with data from DataLoader.
     */
    private UserList() {
        //users = DataLoader.getUsers();
        users = new ArrayList<>();
    }

    /**
     * Get the singleton instance of UserList.
     *
     * @return The singleton UserList instance.
     */
    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    /**
     * Get a user by their unique ID.
     *
     * @param id The unique user ID to look for.
     * @return The user with the specified ID, or null if not found.
     */
    public User getUser(UUID id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Get the list of all users in the system.
     *
     * @return ArrayList containing all the users.
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Authenticate a user by their username and password.
     *
     * @param username The username to check.
     * @param password The password to check.
     * @return The authenticated user, or null if not authenticated.
     */
    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void SaveUsers() {
        DataWriter.saveUsers();
    }

    public void addUser(User user) {
        users.add(user);
    }
}

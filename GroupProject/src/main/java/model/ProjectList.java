package model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This class represents a list of projects in the Project Management System.
 */
public class ProjectList {

    private static ProjectList projectList;
    private ArrayList<Project> projects;

    /**
     * Private constructor to initialize the ProjectList with data from DataLoader.
     */
    private ProjectList() {
        projects = DataLoader.getProjects();
    }

    /**
     * Get the instance of the ProjectList using the Singleton pattern.
     *
     * @return The singleton instance of the ProjectList.
     */
    public static ProjectList getInstance() {
        if (projectList == null) {
            projectList = new ProjectList();
        }

        return projectList;
    }

    /**
     * Retrieve a project by its unique identifier.
     *
     * @param UUID The unique identifier of the project to retrieve.
     * @return The project with the specified identifier, or null if not found.
     */
    public Project getProject(UUID id) {
        for (Project project : projects) {
            if (project.getId().equals(id)) {
                return project;
            }
        }
        return null;
    }

    /**
     * Get the list of all projects.
     *
     * @return The list of all projects.
     */
    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void SaveProjects() {
        DataWriter.saveProjects();
    }
}

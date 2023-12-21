package library;

import java.util.ArrayList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import model.*;

public class HomeController implements Initializable{
    @FXML
    private TextArea projectArea1;

    @FXML
    private TextArea projectArea2;
    
    @FXML
    private void btnProject1Clicked(MouseEvent event) throws IOException{
        App.setRoot("project");
    }

    @FXML
    private void btnProject2Clicked(MouseEvent event) throws IOException{
        App.setRoot("project");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ProjectSystemFACADE facade = ProjectSystemFACADE.getInstance();
        User user = facade.getUser();
        ArrayList<Project> projects = user.getCurrentProjects();
        projectArea1.appendText(projects.get(0).getTitle());
        projectArea2.appendText(projects.get(1).getTitle());
        facade.setProject(projects.get(0));
    }
}
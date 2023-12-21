package library;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Column;
import model.ProjectSystemFACADE;

public class ProjectController implements Initializable{
    @FXML
    private TextArea column1;

    @FXML
    private TextArea column2;

    @FXML
    private TextArea column3;

    @FXML
    private TextArea projectTitle;
    
    @FXML
    private TextField task1title;
        
    @FXML
    private TextField task2title;
        
    @FXML
    private TextField task3title;
        
    @FXML
    private TextField task4title;
        
    @FXML
    private TextField task5title;
        
    @FXML
    private TextField task6title;

    @FXML
    private void btnHomeClicked(MouseEvent event) throws IOException{
        App.setRoot("home");
    }

    @FXML
    private void btnTask1Clicked(MouseEvent event) throws IOException{
        App.setRoot("addTask");
    }

    @FXML
    private void btnTask2Clicked(MouseEvent event) throws IOException{
        App.setRoot("addTask");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ProjectSystemFACADE facade = ProjectSystemFACADE.getInstance();
        ArrayList<Column> columns = facade.getProject().getColumns();
        column1.appendText(columns.get(0).getTitle());
        column2.appendText(columns.get(1).getTitle());
        column3.appendText(columns.get(2).getTitle());
        task1title.appendText(columns.get(0).getTasks().get(0).getTitle());
        task2title.appendText(columns.get(0).getTasks().get(1).getTitle());
        task3title.appendText(columns.get(1).getTasks().get(0).getTitle());
        task4title.appendText(columns.get(1).getTasks().get(1).getTitle());
        task5title.appendText(columns.get(2).getTasks().get(0).getTitle());
        task6title.appendText(columns.get(2).getTasks().get(1).getTitle());
        projectTitle.appendText(facade.getProject().getTitle());
    }
}

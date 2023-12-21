package library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

public class AddTaskController implements Initializable {

    @FXML
    private void btnHomeClicked(MouseEvent event) throws IOException{
        App.setRoot("home");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}

package library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.*;

public class LoginController implements Initializable{
    @FXML
    private TextField userNameTextBox;
    @FXML
    private TextField passwordTextBox;
    @FXML
    private Label lbl_error;
     
    @FXML
    private void btnLoginClicked(MouseEvent event) throws IOException{
        String username = userNameTextBox.getText();
        String password = passwordTextBox.getText();

        ProjectSystemFACADE FACADE = ProjectSystemFACADE.getInstance();
 
        if (FACADE.login(username, password) == null) {
            lbl_error.setText("Invalid login credentials.");
            return;
        }

        App.setRoot("home");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}


module library {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens library to javafx.fxml;
    exports library;
}

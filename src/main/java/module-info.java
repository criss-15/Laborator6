module com.example.laborator6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.example.laborator6 to javafx.fxml;
    exports com.example.laborator6;
}
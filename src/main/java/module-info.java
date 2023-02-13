module com.example.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens com to javafx.fxml;
    exports com;
}
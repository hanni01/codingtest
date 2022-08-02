module com.example.withjava {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.withjava to javafx.fxml;
    exports com.example.withjava;
}
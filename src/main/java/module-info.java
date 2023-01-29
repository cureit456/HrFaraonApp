module com.example.hrfaraonapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires junit;


    opens com.example.hrfaraonapp to javafx.fxml;
    exports com.example.hrfaraonapp;
    exports com.example.hrfaraonapp.entity;
    exports com.example.hrfaraonapp.utils;
    exports tests;
    opens com.example.hrfaraonapp.entity to javafx.fxml;
}
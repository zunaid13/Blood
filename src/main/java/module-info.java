module com.example.blood {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.mail;


    opens com.example.blood to javafx.fxml;
    exports com.example.blood;
}
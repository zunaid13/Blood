module com.example.blood {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.blood to javafx.fxml;
    exports com.example.blood;
}
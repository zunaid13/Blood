module com.example.blood {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.blood to javafx.fxml;
    exports com.example.blood;
}
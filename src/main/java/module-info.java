module com.example.transport3crearebd {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.transport3crearebd to javafx.fxml;
    exports com.example.transport3crearebd;
}
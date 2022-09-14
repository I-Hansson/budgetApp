module org.chalmers {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens org.chalmers to javafx.fxml;
    exports org.chalmers;
}

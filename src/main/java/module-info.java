module org.chalmers {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.chalmers to javafx.fxml;
    exports org.chalmers;
}

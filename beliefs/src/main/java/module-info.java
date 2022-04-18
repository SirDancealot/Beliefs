module ai.gr64 {
    requires javafx.controls;
    requires javafx.fxml;

    opens ai.gr64 to javafx.fxml;
    exports ai.gr64;
}

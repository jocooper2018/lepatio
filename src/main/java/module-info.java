module lepatio {
    requires javafx.controls;
    requires javafx.fxml;

    opens lepatio to javafx.fxml;
    exports lepatio;
}

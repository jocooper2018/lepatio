module lepatio {
    requires javafx.controls;
    requires javafx.fxml;

    opens lepatio to javafx.fxml, java.graphics, java.base;
    opens main to javafx.fxml, java.graphics, java.base;
    opens modele to javafx.fxml, java.graphics, java.base;
    exports lepatio;

}

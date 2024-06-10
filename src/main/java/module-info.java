module lepatio {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    
    opens lepatio to javafx.fxml, java.graphics, java.base, javafx.controls;
    opens main to javafx.fxml, java.graphics, java.base, javafx.controls;
    opens modele to javafx.fxml, java.graphics, java.base, javafx.controls;
    exports lepatio;
    exports main;
    exports modele;

}

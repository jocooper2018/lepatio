package modele;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.event.*;

public class CtrlFenListeSpec {

    @FXML
    private ListView<?> ListeFiltre;

    @FXML
    private ListView<?> ListeSpectacle;

    @FXML
    private Button bnCreerGenre;

    @FXML
    private Button bnFermer;

    @FXML
    private TextField txtFiltre;

    @FXML
    void Fermer(ActionEvent event) {
        System.exit(0);
    }

}

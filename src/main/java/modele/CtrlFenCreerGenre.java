package modele;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;

public class CtrlFenCreerGenre {

    @FXML
    private Button bnAnnuler;

    @FXML
    private Button bnCreerGenre;

    @FXML
    private Label lbNom;

    @FXML
    private TextField txtNom;

    @FXML
    void CreerGenre(ActionEvent event) {
        Main.ouvrirCreerGenre();
    }

    @FXML
    void Fermer(ActionEvent event) {
        Main.fermerPopup();
    }
}

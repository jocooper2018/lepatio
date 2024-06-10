package modele;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import main.Main;

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
        Main.fermerAppli();
    }

}
        
package modele;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import main.Main;
import lepatio.*;

public class CtrlFenListeSpec {

    @FXML
    private ListView<Genre> listeFiltre;

    @FXML
    private ListView<?> listeSpectacle;

    @FXML
    private Button bnCreerGenre;

    @FXML
    private Button bnFermer;

    @FXML
    private Button bnSelectionner;

    @FXML
    private TextField txtFiltre;

    @FXML
    void fermer(ActionEvent event) {
        Main.fermerAppli();
    }
    
    public ListView<Genre> getListeFiltre() {
        return listeFiltre;
    }

    public ListView<?> getListeSpectacle() {
        return listeSpectacle;
    }

    public Button getBnCreerGenre() {
        return bnCreerGenre;
    }

    public Button getBnFermer() {
        return bnFermer;
    }

    public Button getBnSelectionner() {
        return bnSelectionner;
    }

    public TextField getTxtFiltre() {
        return txtFiltre;
    }

    @FXML
    void creerGenre(ActionEvent event) {
        Main.ouvrirCreerGenre();
    }

    public void initialize() {
        listeFiltre = new ListView<Genre>();

    }

}

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
    private ListView<Genre> ListeFiltre;

    @FXML
    private ListView<?> ListeSpectacle;

    @FXML
    private Button bnCreerGenre;

    @FXML
    private Button bnFermer;

    @FXML
    private Button bnSelectionner;


    @FXML
    private TextField txtFiltre;

    @FXML
    void Fermer(ActionEvent event) {
        Main.fermerAppli();
    }

    @FXML
    void CreerGenre(ActionEvent event) {
        Main.ouvrirCreerGenre();
    }

    public void addGenreToListView(Genre genre) {
        ListeFiltre.getItems().add(genre);
    }

}

package modele;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lepatio.Artiste;
import lepatio.Representation;
import lepatio.Spectacle;
import lepatio.Donnees;
import lepatio.Genre;
import lepatio.Zone;
import main.Main;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CtrlFenStatistique {

    @FXML
    private Button bnRetour;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TableView<Map<String, String>> tableau;

    @FXML
    private TextField txtCASaison;

    @FXML
    private TextField txtNbVendu;

    private ObservableList<Spectacle> spectacles;

    public void initialize() {
        spectacles = FXCollections.observableArrayList(Donnees.getListeSpectacle());

        // Configuration de la ChoiceBox
        choiceBox.getItems().addAll("Spectacle", "Représentation", "Artiste");
        choiceBox.setValue("Spectacle"); // Valeur par défaut
    }
    
    @FXML
    void fermerFenetre(ActionEvent event) {
        Main.fermerStat();
    }
}

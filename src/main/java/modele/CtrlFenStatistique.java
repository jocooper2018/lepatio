package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lepatio.Spectacle;
import main.Main;
import modele.test;

public class CtrlFenStatistique {

    @FXML
    private Button bnRetour;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private RadioButton rdButtonNomArt;

    @FXML
    private RadioButton rdButtonNomSpec;

    @FXML
    private TableView<test> tableau;

    @FXML
    private TextField txtCASaison;

    @FXML
    private TextField txtNbVendu;

    private ObservableList<test> data;

    @FXML
    void fermerFenetre(ActionEvent event) {
        Main.fermerStat();
    }

    @FXML
    public void initialize() {
        // Créer les colonnes
        TableColumn<test, String> colonneNomSpectacle = new TableColumn<>("Nom du Spectacle");
        colonneNomSpectacle.setCellValueFactory(new PropertyValueFactory<>("nomSpectacle"));

        TableColumn<test, String> colonneNomArtiste = new TableColumn<>("Nom de l'Artiste");
        colonneNomArtiste.setCellValueFactory(new PropertyValueFactory<>("nomArtiste"));

        TableColumn<test, Integer> colonneCaTotal = new TableColumn<>("CA Total");
        colonneCaTotal.setCellValueFactory(new PropertyValueFactory<>("caTotal"));

        // Ajouter les colonnes au tableau
        tableau.getColumns().add(colonneNomSpectacle);
        tableau.getColumns().add(colonneNomArtiste);
        tableau.getColumns().add(colonneCaTotal);

        // Initialiser les données
        data = FXCollections.observableArrayList(
                new test("Spectacle A", "Artiste X", 5000),
                new test("Spectacle B", "Artiste Y", 3000),
                new test("Spectacle C", "Artiste X", 2000)
        );

        tableau.setItems(data);

        choiceBox.setItems(FXCollections.observableArrayList("Spectacle", "Représentation", "Artiste"));
        choiceBox.setValue("Spectacle");
    }


    
}

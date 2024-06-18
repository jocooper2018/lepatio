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

        // Initialisation du TableView
        initialiserTableauSpectacles();

        // Actualisation des données à afficher en fonction de la sélection dans la ChoiceBox
        choiceBox.setOnAction(event -> actualiserStatistiques());
        actualiserStatistiques();
    }

    @FXML
    void fermerFenetre(ActionEvent event) {
        Main.fermerStat();
    }

    private void initialiserTableauSpectacles() {
        TableColumn<Map<String, String>, String> colonne1 = new TableColumn<>("Nom");
        colonne1.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("Nom")));

        TableColumn<Map<String, String>, String> colonne2 = new TableColumn<>("Durée");
        colonne2.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("Durée")));

        TableColumn<Map<String, String>, String> colonne3 = new TableColumn<>("Nombre Max Spectateurs");
        colonne3.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("Nombre Max Spectateurs")));

        TableColumn<Map<String, String>, String> colonne4 = new TableColumn<>("Genre");
        colonne4.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("Genre")));

        TableColumn<Map<String, String>, String> colonne5 = new TableColumn<>("Nombre de Représentations");
        colonne5.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("Nombre de Représentations")));

        tableau.getColumns().addAll(colonne1, colonne2, colonne3, colonne4, colonne5);
    }

    private void initialiserTableauRepresentations() {
        TableColumn<Map<String, String>, String> colonne1 = new TableColumn<>("Nom du Spectacle");
        colonne1.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("Nom du Spectacle")));

        TableColumn<Map<String, String>, String> colonne2 = new TableColumn<>("Date");
        colonne2.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("Date")));

        TableColumn<Map<String, String>, String> colonne3 = new TableColumn<>("Heure");
        colonne3.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("Heure")));

        TableColumn<Map<String, String>, String> colonne4 = new TableColumn<>("Chiffre d'Affaires");
        colonne4.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("Chiffre d'Affaires")));

        tableau.getColumns().addAll(colonne1, colonne2, colonne3, colonne4);
    }

    private void initialiserTableauArtistes() {
        TableColumn<Map<String, String>, String> colonne1 = new TableColumn<>("Nom");
        colonne1.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("Nom")));

        TableColumn<Map<String, String>, String> colonne2 = new TableColumn<>("Chiffre d'Affaires Total");
        colonne2.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("Chiffre d'Affaires Total")));

        TableColumn<Map<String, String>, String> colonne3 = new TableColumn<>("Nombre de Représentations Total");
        colonne3.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("Nombre de Représentations Total")));

        tableau.getColumns().addAll(colonne1, colonne2, colonne3);
    }

    private void actualiserStatistiques() {
        tableau.getColumns().clear(); // Nettoyer les colonnes précédentes

        switch (choiceBox.getValue()) {
            case "Spectacle":
                initialiserTableauSpectacles();
                afficherStatistiquesSpectacles();
                break;
            case "Représentation":
                initialiserTableauRepresentations();
                afficherStatistiquesRepresentations();
                break;
            case "Artiste":
                initialiserTableauArtistes();
                afficherStatistiquesArtistes();
                break;
        }

        // Mettre à jour les statistiques de la saison
        double caSaison = 0; // Calculer le chiffre d'affaires de la saison
        int nbBilletsVendus = 0; // Calculer le nombre total de billets vendus

        for (Spectacle spectacle : spectacles) {
            caSaison += spectacle.getChiffreAffairesSaison();
            nbBilletsVendus += spectacle.getNbBilletsVendus();
        }

        txtCASaison.setText(String.valueOf(caSaison));
        txtNbVendu.setText(String.valueOf(nbBilletsVendus));
    }

    private void afficherStatistiquesSpectacles() {
        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();

        for (Spectacle spectacle : spectacles) {
            Map<String, String> row = new HashMap<>();
            row.put("Nom", spectacle.getNom());
            row.put("Durée", String.valueOf(spectacle.getDuree()));
            row.put("Nombre Max Spectateurs", String.valueOf(spectacle.getNbreMaxSpect()));
            row.put("Genre", spectacle.getGenre().getLibelle());
            row.put("Nombre de Représentations", String.valueOf(spectacle.getRepresentations().size()));
            data.add(row);
        }

        tableau.setItems(data);
    }

    private void afficherStatistiquesRepresentations() {
        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();

        for (Spectacle spectacle : spectacles) {
            for (Representation representation : spectacle.getRepresentations()) {
                Map<String, String> row = new HashMap<>();
                row.put("Nom du Spectacle", spectacle.getNom());
                row.put("Date", representation.getJour());
                row.put("Heure", representation.getHeure()git);
                row.put("Chiffre d'Affaires", String.valueOf(representation.getChiffreAffaires()));
                data.add(row);
            }
        }

        tableau.setItems(data);
    }

    private void afficherStatistiquesArtistes() {
        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();

        for (Artiste artiste : Donnees.getListeArtiste()) {
            Map<String, String> row = new HashMap<>();
            row.put("Nom", artiste.getNom());
            row.put("Chiffre d'Affaires Total", String.valueOf(artiste.getChiffreAffairesTotal()));
            row.put("Nombre de Représentations Total", String.valueOf(artiste.getNombreRepresentations()));
            data.add(row);
        }

        tableau.setItems(data);
    }
}

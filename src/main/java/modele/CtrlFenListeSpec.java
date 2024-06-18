package modele;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import lepatio.Genre;
import lepatio.Spectacle;
import main.Main;
import lepatio.Donnees;

public class CtrlFenListeSpec {

    @FXML
    private ListView<Genre> listeFiltre;

    @FXML
    private ListView<Spectacle> listeSpectacle;

    @FXML
    private Button bnCreerGenre;

    @FXML
    private Button bnFermer;

    @FXML
    private Button bnStat;

    @FXML
    private Button bnSelectionner;

    @FXML
    private TextField txtFiltre;

    private ObservableList<Spectacle> allSpectacles; // Liste de tous les spectacles
    private FilteredList<Spectacle> filteredSpectacles; // Liste filtrée de spectacles

    @FXML
    void fermer(ActionEvent event) {
        Main.fermerAppli();
    }

    @FXML
    void creerGenre(ActionEvent event) {
        Main.ouvrirCreerGenre();
    }

    @FXML
    void afficherStat(ActionEvent event) {
        Main.ouvrirStat();
    }

    @FXML
    void selectionnerGenre(ActionEvent event) {
        Genre selectedGenre = listeFiltre.getSelectionModel().getSelectedItem();
        if (selectedGenre != null) {
            // Filtrer les spectacles par le genre sélectionné
            filteredSpectacles.setPredicate(spectacle -> spectacle.getGenre().equals(selectedGenre));
        }
    }

    public void initialize() {
        // Initialiser la liste des genres
        ObservableList<Genre> listeGenres = Donnees.getListeGenre();
        listeFiltre.setItems(listeGenres);
        listeFiltre.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        // Filtrage dynamique des genres par la barre de recherche
        FilteredList<Genre> filteredGenres = new FilteredList<>(listeGenres);
        txtFiltre.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredGenres.setPredicate(genre -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true; // Afficher tous les genres si rien n'est tapé
                }
                String lowerCaseFilter = newValue.toLowerCase();
                return genre.getLibelle().toLowerCase().contains(lowerCaseFilter); // Filtrer par nom de genre
            });
        });

        listeFiltre.setItems(filteredGenres); // Appliquer le filtre à la ListView des genres

        // Initialiser la liste des spectacles avec tous les spectacles
        allSpectacles = Donnees.getListeSpectacle();
        filteredSpectacles = new FilteredList<>(allSpectacles);

        // Lier la liste des spectacles à la liste filtrée
        listeSpectacle.setItems(filteredSpectacles);

        // Binding pour désactiver le bouton Sélectionner lorsque aucun genre n'est sélectionné
        bnSelectionner.disableProperty().bind(
            Bindings.isNull(listeFiltre.getSelectionModel().selectedItemProperty())
        );
    }
}

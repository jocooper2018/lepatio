package modele;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lepatio.Artiste;
import lepatio.Billet;
import lepatio.Donnees;
import lepatio.Fauteuil;
import lepatio.Representation;
import lepatio.Reservation;
import lepatio.Spectacle;
import lepatio.Tarif;
import lepatio.Zone;
import main.Main;

import java.util.HashMap;
import java.util.Map;

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
        
        Donnees.chargerDonnees();

        spectacles = FXCollections.observableArrayList(Donnees.getListeSpectacle());

        // Configuration de la ChoiceBox
        choiceBox.getItems().addAll("Spectacle", "Représentation", "Artiste");
        choiceBox.setValue("Spectacle"); // Valeur par défaut

        // Initialiser le TableView avec les données des spectacles par défaut
        initTableSpectacles();

        // Écouter les changements de sélection dans la ChoiceBox
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "Spectacle":
                    initTableSpectacles();
                    break;
                case "Représentation":
                    initTableRepresentations();
                    break;
                case "Artiste":
                    initTableArtistes();
                    break;
                default:
                    break;
            }
        });
    }

    private void initTableSpectacles() {
        // Définir les colonnes du TableView pour les spectacles
        tableau.getColumns().clear();
        TableColumn<Map<String, String>, String> colNom = new TableColumn<>("Nom Spectacle");
        colNom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("nom")));
        TableColumn<Map<String, String>, String> colCATotal = new TableColumn<>("CA Total");
        colCATotal.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("ca_total")));
        TableColumn<Map<String, String>, String> colNbRepresentations = new TableColumn<>("Nb. de Représentations");
        colNbRepresentations.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("nb_representations")));

        tableau.getColumns().addAll(colNom, colCATotal, colNbRepresentations);

        // Remplir les données dans le TableView pour les spectacles
        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();
        for (Spectacle spectacle : spectacles) {
            Map<String, String> row = new HashMap<>();
            row.put("nom", spectacle.getNom());
            double caTotal = 0.0;
            for (Representation representation : spectacle.getRepresentations()) {
                for (Reservation reservation : representation.getReservations()) {
                    for (Billet billet : reservation.getBillets()) {
                        Tarif tarif = Spectacle.getTarif(spectacle, billet.getFauteuil().getZone());
                        if (tarif != null) {
                            caTotal += tarif.calculerMontant(billet);
                        }
                    }
                }
            }
            row.put("ca_total", String.valueOf(caTotal / 100.0));
            row.put("nb_representations", String.valueOf(spectacle.getRepresentations().size()));
            data.add(row);
        }
        tableau.setItems(data);
    }

    private void initTableRepresentations() {
        // Définir les colonnes du TableView
        tableau.getColumns().clear();
        TableColumn<Map<String, String>, String> colNomSpectacle = new TableColumn<>("Nom Spectacle");
        colNomSpectacle.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("nom")));
        TableColumn<Map<String, String>, String> colDate = new TableColumn<>("Date");
        colDate.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("date")));
        TableColumn<Map<String, String>, String> colHeure = new TableColumn<>("Heure");
        colHeure.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("heure")));
        TableColumn<Map<String, String>, String> colCATotal = new TableColumn<>("CA");
        colCATotal.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("ca")));

        tableau.getColumns().addAll(colNomSpectacle, colDate, colHeure, colCATotal);

        // Remplir les données dans le TableView
        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();
        for (Spectacle spectacle : spectacles) {
            for (Representation representation : spectacle.getRepresentations()) {
                Map<String, String> row = new HashMap<>();
                row.put("nom", spectacle.getNom());
                row.put("date", representation.getJour());
                row.put("heure", representation.getHeure());
                double caTotal = 0.0;
                for (Reservation reservation : representation.getReservations()) {
                    for (Billet billet : reservation.getBillets()) {
                        Tarif tarif = Spectacle.getTarif(spectacle, billet.getFauteuil().getZone());
                        if (tarif != null) {
                            caTotal += tarif.calculerMontant(billet);
                        }
                    }
                }
                row.put("ca", String.valueOf(caTotal / 100.0));
                data.add(row);
            }
        }
        tableau.setItems(data);
    }

    private void initTableArtistes() {
        // Définir les colonnes du TableView
        tableau.getColumns().clear();
        TableColumn<Map<String, String>, String> colNomArtiste = new TableColumn<>("Nom Artiste");
        colNomArtiste.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("nom")));
        TableColumn<Map<String, String>, String> colCATotal = new TableColumn<>("CA Total");
        colCATotal.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("ca_total")));
        TableColumn<Map<String, String>, String> colNbRepresentations = new TableColumn<>("Nb. de Représentations");
        colNbRepresentations.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get("nb_representations")));

        tableau.getColumns().addAll(colNomArtiste, colCATotal, colNbRepresentations);

        // Calculer le chiffre d'affaires total et le nombre de représentations pour chaque artiste
        Map<Artiste, Long> chiffreAffaireParArtiste = new HashMap<>();
        Map<Artiste, Integer> nbRepresentationsParArtiste = new HashMap<>();

        
        // Remplir les données dans le TableView
        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();
        for (Artiste artiste : Donnees.getListeArtiste()) {

            long chiffreAffaire = 0L;
            int nbRepresentations = 0;
            for (Spectacle spectacle : artiste.getSpectacles()) {
                for (Representation representation : spectacle.getRepresentations()) {
                    nbRepresentations++;
                    for (Reservation reservation : representation.getReservations()) {
                        for (Billet billet : reservation.getBillets()) {
                            chiffreAffaire += Spectacle.getTarif(spectacle, billet.getFauteuil().getZone()).getPleinTarif();
                        }
                    }
                }
            }

            chiffreAffaireParArtiste.put(artiste, Long.valueOf(chiffreAffaire));
            nbRepresentationsParArtiste.put(artiste, Integer.valueOf(nbRepresentations));

            Map<String, String> row = new HashMap<>();
            row.put("nom", artiste.getNom());
            row.put("ca_total", String.valueOf((double)chiffreAffaireParArtiste.getOrDefault(artiste, 0L) / 100.0));
            row.put("nb_representations", String.valueOf(nbRepresentationsParArtiste.getOrDefault(artiste, 0)));
            data.add(row);
        }
        tableau.setItems(data);
    }

    @FXML
    void fermerFenetre(ActionEvent event) {
        Main.fermerStat();
    }
}
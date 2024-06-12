package main;

import javafx.application.Application;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lepatio.Donnees;
import lepatio.Genre;
import modele.*;

public class Main extends Application {
    private static FenListeSpec fListe;
    private static FenCreerGenre fCreer;
    private static ListView<Genre> ctrlListe;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Main.fListe = new FenListeSpec();
        Main.fCreer = new FenCreerGenre();

        Main.fCreer.initModality(Modality.APPLICATION_MODAL);
        this.fListe.show();
    }

    // Gestion des fenêtres

    public static void fermerAppli() {
        System.exit(0);
    }

    public static void fermerPopup() {
        Main.fCreer.close();
    }

    public static void ouvrirCreerGenre() {
        Main.fCreer.show();
    }

    // Gestion des données

    public static void creerGenre(Genre genre) {
        Donnees.ajouterGenre(genre);
    }

    public static void creerGenre(String nomGenre) {
        Main.creerGenre(new Genre(nomGenre));
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}

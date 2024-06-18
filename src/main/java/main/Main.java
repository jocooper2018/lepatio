package main;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lepatio.Donnees;
import lepatio.Genre;
import modele.*;

public class Main extends Application {
    private static FenListeSpec fListe;
    private static FenCreerGenre fCreer;
    private static FenAffichageStatistique fStat;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Main.fListe = new FenListeSpec();
        Main.fCreer = new FenCreerGenre();
        Main.fStat = new FenAffichageStatistique();

        Donnees.chargerDonnees();

        Main.fCreer.initModality(Modality.APPLICATION_MODAL);
        Main.fStat.initModality(Modality.APPLICATION_MODAL);
        Main.fListe.show();
    }

    // Gestion des fenêtres

    public static void fermerAppli() {
        System.exit(0);
    }

    public static void fermerPopup() {
        Main.fCreer.close();
    }

    public static void ouvrirStat(){
        Main.fStat.show();
    }

    public static void fermerStat(){
        Main.fStat.close();
    }
    public static void ouvrirCreerGenre() {
        Main.fCreer.clear();
        Main.fCreer.show();
    }

    // Gestion des données

    public static void creerGenre(Genre genre) {
        Donnees.ajouterGenre(genre);
        Main.fermerPopup();
    }

    public static void creerGenre(String nomGenre) {
        Main.creerGenre(new Genre(nomGenre));
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}

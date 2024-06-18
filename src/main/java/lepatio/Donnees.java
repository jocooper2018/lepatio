package lepatio;

import java.util.Collection;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Cette classe contient toute les données de l'application. Toutes les données
 * sons dans des variables static.
 * 
 * @author LE BOUT Matthieu
 */
public class Donnees {

    private static ObservableList<Genre> listeGenre = FXCollections.observableArrayList();
    private static ObservableList<Spectacle> listeSpectacle = FXCollections.observableArrayList();

    /**
     * @return La liste de tous les genres créés.
     */
    public static ObservableList<Genre> getListeGenre() {
        return Donnees.listeGenre;
    }

    /**
     * Ajoute un genre à la liste des genres.
     * @param genre Le genre à ajouter.
     * @return {@code true} (as specified by {@link Collection#add})
     */
    public static boolean ajouterGenre(Genre genre) {
        return Donnees.getListeGenre().add(genre);
    }

    /**
     * Supprimer un genre.
     * @param genre Le genre à supprimer.
     * @return {@code true} (as specified by {@link List#remove})
     */
    public static boolean supprimerGenre(Genre genre) {
        return Donnees.getListeGenre().remove(genre);
    }

    public static ObservableList<Spectacle> getListeSpectacle() {
        return Donnees.listeSpectacle;
    }

    public static boolean ajouterSpectacle(Spectacle spectacle) {
        return Donnees.getListeSpectacle().add(spectacle);
    }

    public static boolean supprimerSpectacle(Spectacle spectacle) {
        return Donnees.getListeSpectacle().remove(spectacle);
    }

    public static void chargerDonnees() {

        Genre genreTheatre = new Genre("Théâtre");
        Genre genreMarionnette = new Genre("Marionnette");
        Genre genreCirque = new Genre("Cirque");
        Genre genreMusique = new Genre("Musique");
        Genre genreOpera = new Genre("Opera");
        Genre genreDanse = new Genre("Danse");

        Artiste artisteAlbert = new Artiste("Albert Jcanrpunhoufr");
        Artiste artisteJorgul = new Artiste("Jorgul");
        Artiste artisteEldwin = new Artiste("Eldwin Shelby");
        Artiste artisteTiti = new Artiste("Titi Hicks");
        Artiste artisteElendur = new Artiste("Elendur Sylverël");
        Artiste artisteFulbert = new Artiste("Fulbert Clovis");

        Spectacle spectacle1 = new Spectacle("Les guadeloupéens", 161, 504, genreOpera);
        spectacle1.ajouterArtiste(artisteAlbert);
        spectacle1.ajouterArtiste(artisteEldwin);
        spectacle1.ajouterArtiste(artisteJorgul);

        Spectacle spectacle2 = new Spectacle("Les guadeloupédeux", 170, 239, genreDanse);
        spectacle2.ajouterArtiste(artisteTiti);
        spectacle2.ajouterArtiste(artisteElendur);
        spectacle2.ajouterArtiste(artisteFulbert);

        Spectacle spectacle3 = new Spectacle("Les guadeloupétrois", 169, 345, genreCirque);
        spectacle3.ajouterArtiste(artisteAlbert);
        spectacle3.ajouterArtiste(artisteEldwin);
        spectacle3.ajouterArtiste(artisteJorgul);
        spectacle3.ajouterArtiste(artisteTiti);
        spectacle3.ajouterArtiste(artisteElendur);
        spectacle3.ajouterArtiste(artisteFulbert);

        Donnees.ajouterGenre(genreTheatre);
        Donnees.ajouterGenre(genreMarionnette);
        Donnees.ajouterGenre(genreCirque);
        Donnees.ajouterGenre(genreMusique);
        Donnees.ajouterGenre(genreOpera);
        Donnees.ajouterGenre(genreDanse);

        Donnees.ajouterSpectacle(spectacle1);
        Donnees.ajouterSpectacle(spectacle2);
        Donnees.ajouterSpectacle(spectacle3);
    }
}

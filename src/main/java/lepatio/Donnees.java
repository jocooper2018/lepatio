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
}

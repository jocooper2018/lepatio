package lepatio;

import javafx.collections.ObservableList;

public class Donnees {
    
    private static ObservableList<Genre> listeGenre;

    public static ObservableList<Genre> getListeGenre() {
        return Donnees.listeGenre;
    }

    public static boolean ajouterGenre(Genre genre) {
        return Donnees.getListeGenre().add(genre);
    }

    public static boolean supprimerGenre(Genre genre) {
        return Donnees.getListeGenre().remove(genre);
    }
}

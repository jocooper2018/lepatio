package lepatio;

import java.util.Collection;
import java.util.GregorianCalendar;
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
    private static ObservableList<Representation> listeRepresentations = FXCollections.observableArrayList();
    private static ObservableList<Reservation> listeReservations = FXCollections.observableArrayList();
    private static ObservableList<Artiste> listeArtistes = FXCollections.observableArrayList();


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

    public static ObservableList<Representation> getListeRepresentations() {
        return Donnees.listeRepresentations;
    }

    public static boolean ajouterRepresentation(Representation representation) {
        return Donnees.getListeRepresentations().add(representation);
    }

    public static boolean supprimerRepresentation(Representation representation) {
        return Donnees.getListeRepresentations().remove(representation);
    }

    public static ObservableList<Reservation> getListeReservations() {
        return Donnees.listeReservations;
    }

    public static boolean ajouterReservation(Reservation Reservation) {
        return Donnees.getListeReservations().add(Reservation);
    }

    public static boolean supprimerReservation(Reservation Reservation) {
        return Donnees.getListeReservations().remove(Reservation);
    }

    public static ObservableList<Artiste> getListeArtiste() {
        return Donnees.listeArtistes;
    }

    public static boolean ajouterArtiste(Artiste artiste) {
        return Donnees.getListeArtiste().add(artiste);
    }

    public static boolean supprimerArtiste(Artiste artiste) {
        return Donnees.getListeArtiste().remove(artiste);
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

        Representation representation1_1 = new Representation("20/06/2024", "15h15", spectacle1);
        Representation representation1_2 = new Representation("27/06/2024", "15h15", spectacle1);
        Representation representation1_3 = new Representation("01/07/2024", "20h20", spectacle1);

        Representation representation2_1 = new Representation("04/07/2024", "15h15", spectacle2);
        Representation representation2_2 = new Representation("11/07/2024", "15h15", spectacle2);
        Representation representation2_3 = new Representation("15/07/2024", "20h20", spectacle2);

        Representation representation3_1 = new Representation("08/07/2024", "20h20", spectacle3);
        Representation representation3_2 = new Representation("18/07/2024", "15h15", spectacle3);
        Representation representation3_3 = new Representation("24/07/2024", "20h20", spectacle3);
        Representation representation3_4 = new Representation("27/07/2024", "15h15", spectacle3);

        Client client1 = new Client("quoive", "Toto", "L'adresse de Toto", "0606060606", "adresse@email.com");
        Client client2 = new Client("kantunz", "Jojo", "L'adresse de Jojo", "0707070707", "adresse@email.fr");
        Client client3 = new Client("ninlusy", "Tata", "L'adresse de Tata", "0202020202", "adresse@email.org");

        Fauteuil fauteuil1 = new Fauteuil("1", "1", null);
        Fauteuil fauteuil2 = new Fauteuil("1", "2", null);
        Fauteuil fauteuil3 = new Fauteuil("1", "3", null);

        Reservation reservation1 = new Reservation(new GregorianCalendar(), null, representation1_1, client1);
        Reservation reservation2 = new Reservation(new GregorianCalendar(), null, representation2_1, client1);
        Reservation reservation3 = new Reservation(new GregorianCalendar(), null, representation3_1, client1);
        Reservation reservation4 = new Reservation(new GregorianCalendar(), null, representation1_1, client2);
        Reservation reservation5 = new Reservation(new GregorianCalendar(), null, representation2_1, client2);
        Reservation reservation6 = new Reservation(new GregorianCalendar(), null, representation3_1, client2);
        Reservation reservation7 = new Reservation(new GregorianCalendar(), null, representation1_1, client3);
        Reservation reservation8 = new Reservation(new GregorianCalendar(), null, representation2_1, client3);

        reservation1.ajouterBillet(new Billet(reservation1, fauteuil1, new TarifAdulte()));
        reservation2.ajouterBillet(new Billet(reservation2, fauteuil1, new TarifAdulte()));
        reservation3.ajouterBillet(new Billet(reservation3, fauteuil1, new TarifAdulte()));
        reservation4.ajouterBillet(new Billet(reservation4, fauteuil2, new TarifAdulte()));
        reservation5.ajouterBillet(new Billet(reservation5, fauteuil2, new TarifAdulte()));
        reservation6.ajouterBillet(new Billet(reservation6, fauteuil2, new TarifAdulte()));
        reservation7.ajouterBillet(new Billet(reservation7, fauteuil3, new TarifAdulte()));
        reservation8.ajouterBillet(new Billet(reservation8, fauteuil3, new TarifAdulte()));

        Donnees.ajouterGenre(genreTheatre);
        Donnees.ajouterGenre(genreMarionnette);
        Donnees.ajouterGenre(genreCirque);
        Donnees.ajouterGenre(genreMusique);
        Donnees.ajouterGenre(genreOpera);
        Donnees.ajouterGenre(genreDanse);

        Donnees.ajouterSpectacle(spectacle1);
        Donnees.ajouterSpectacle(spectacle2);
        Donnees.ajouterSpectacle(spectacle3);

        Donnees.ajouterRepresentation(representation1_1);
        Donnees.ajouterRepresentation(representation1_2);
        Donnees.ajouterRepresentation(representation1_3);

        Donnees.ajouterRepresentation(representation2_1);
        Donnees.ajouterRepresentation(representation2_2);
        Donnees.ajouterRepresentation(representation2_3);

        Donnees.ajouterRepresentation(representation3_1);
        Donnees.ajouterRepresentation(representation3_2);
        Donnees.ajouterRepresentation(representation3_3);
        Donnees.ajouterRepresentation(representation3_4);

        Donnees.ajouterReservation(reservation1);
        Donnees.ajouterReservation(reservation2);
        Donnees.ajouterReservation(reservation3);
        Donnees.ajouterReservation(reservation4);
        Donnees.ajouterReservation(reservation5);
        Donnees.ajouterReservation(reservation6);
        Donnees.ajouterReservation(reservation7);
        Donnees.ajouterReservation(reservation8);
    }
}

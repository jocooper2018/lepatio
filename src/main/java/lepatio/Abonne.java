package lepatio;

public class Abonne extends Client {

    public Abonne(String nom, String prenom, String adresse, String tel, String mail, String numero,
            Reservation premiereReservation) {
        super(nom, prenom, adresse, tel, mail, numero, premiereReservation);
    }
}

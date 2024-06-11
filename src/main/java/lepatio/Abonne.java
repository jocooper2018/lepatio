package lepatio;

/**
 * La classe {@code Abonne} représente un client qui assiste à au moins 3
 * spectacles par ans. Un client a un nom, un prénom, une adresse, un numéro de
 * téléphone, un mail, et est identifié par un numéro.
 * Un client peut faire autant de réservation qu'il le souhaite, mais doit en
 * avoir fait au moins une pour être client.
 * 
 * @author LE BOUT Matthieu
 * @see Reservation
 * @see Client
 */
public class Abonne extends Client {

    /**
     * Construit un client abonné avec les paramètres spécifiés.
     * 
     * @param nom                 Le nom du client.
     * @param prenom              Le prénom du client.
     * @param adresse             L'adresse postale du client.
     * @param tel                 Le numéro de téléphone de client.
     * @param mail                L'adresse e-mail du client.
     * @param numero              Le numéro du client.
     * @param premiereReservation La première réservation effectuer par le client.
     */
    public Abonne(String nom, String prenom, String adresse, String tel, String mail, String numero,
            Reservation premiereReservation) {
        super(nom, prenom, adresse, tel, mail, premiereReservation);
    }
}

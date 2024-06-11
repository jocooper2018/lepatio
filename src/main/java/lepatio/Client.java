package lepatio;

import java.util.HashSet;
import java.util.Set;

/**
 * La classe {@code Client} représente un client. Un client a un nom, un prénom,
 * une adresse, un numéro de téléphone, un mail, et est identifié par un numéro.
 * Un client peut faire autant de réservation qu'il le souhaite, mais doit en
 * avoir fait au moins une pour être client.
 * 
 * @author LE BOUT Matthieu
 * @see Reservation
 * @see Abonne
 */
public class Client {

    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String mail;
    private String numero;
    private Set<Reservation> reservations;

    /**
     * Construit un client avec les paramètres spécifiés.
     * 
     * @param nom                 Le nom du client.
     * @param prenom              Le prénom du client.
     * @param adresse             L'adresse postale du client.
     * @param tel                 Le numéro de téléphone de client.
     * @param mail                L'adresse e-mail du client.
     * @param numero              Le numéro du client.
     * @param premiereReservation La première réservation effectuer par le client.
     */
    public Client(String nom, String prenom, String adresse, String tel, String mail, String numero,
            Reservation premiereReservation) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdresse(adresse);
        this.setTel(tel);
        this.setMail(mail);
        this.setNumero(numero);
        this.reservations = new HashSet<Reservation>();
        this.ajouterReservation(premiereReservation);
    }

    /**
     * @return Le nom du client.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Change le nom du client.
     * 
     * @param nom Le nouveau nom du client.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return Le prénom du client.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Change le prénom du client.
     * 
     * @param prenom Le nouveau prénom du client.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return L'adresse postale du client.
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Change l'adresse postale du client.
     * 
     * @param adresse La nouvelle adresse postale du client.
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return Le numéro de téléphone de client.
     */
    public String getTel() {
        return tel;
    }

    /**
     * Change le numéro de téléphone de client.
     * 
     * @param tel Le nouveau numéro de téléphone de client.
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return L'adresse e-mail du client.
     */
    public String getMail() {
        return mail;
    }

    /**
     * Change l'adresse e-mail du client.
     * 
     * @param mail La nouvelle adresse e-mail du client.
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return Le numéro du client.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Change le numéro du client.
     * 
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return L'ensemble des réservations du client.
     */
    public Set<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Ajoute une réservation au client.
     * 
     * @param reservation La réservation à ajouter.
     * @return {@code true} si l'ensemble des reservation du client ne contient pas
     *         déjà la réservation à ajouter.
     */
    public boolean ajouterReservation(Reservation reservation) {
        reservation.setClient(this);
        return this.getReservations().add(reservation);
    }

    /**
     * Enlève une réservation du client.
     * 
     * @param reservation La réservation à enlever.
     * @return {@code true} si l'ensemble des réservation contenait la réservation à
     *         enlever.
     * @throws IllegalStateException Si il n'y a qu'une seule réservation ou moins
     *                               associé au client.
     */
    public boolean enleverReservation(Reservation reservation) throws IllegalStateException {
        if (this.getReservations().size() <= 1) {
            throw new IllegalStateException(
                    "Impossible de supprimer la réservation : le client doit être associé à au moins une réservation.");
        }
        return this.getReservations().remove(reservation);
    }
}

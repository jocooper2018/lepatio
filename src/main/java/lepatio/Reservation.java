package lepatio;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * La classe {@code Reservation} représente une réservation faite par un client
 * pour assister une représentation d'un spectacle. La réservation peut concerne
 * au moins un billets.
 * 
 * @author LE BOUT Matthieu
 * @see Representation
 * @see Billet
 * @see Client
 */
public class Reservation {

    private String numero;
    private Calendar date;
    private Calendar dateEnvoiConf;
    private Representation representation;
    private Set<Billet> billets;
    private Client client;
    private Annulation annulation;

    private static int nbReservations = 0;

    /**
     * Construit une réservation.
     * 
     * @param date           Date à laquelle la réservation a été effectuée.
     * @param dateEnvoiConf  Date d'envoie de la confirmation.
     * @param representation La représentation concernée par la réservation.
     * @param client         Le client qui a réservé les billets.
     */
    public Reservation(Calendar date, Calendar dateEnvoiConf, Representation representation,
            Client client) {
        this.setNumero(String.valueOf(nbReservations++));
        this.setDate(date);
        this.setDateEnvoiConf(dateEnvoiConf);
        this.setRepresentation(representation);
        this.billets = new HashSet<Billet>();
        this.setClient(client);
        this.annulation = null;
        representation.getReservations().add(this);
    }

    /**
     * 
     * @return Le numéro de la réservation.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Change le numéro de la réservation.
     * 
     * @param numero Le nouveau numéro de la réservation.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Change la date de la réservation.
     * 
     * @param date La nouvelle date.
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * Change la date d'envoie de la confirmation.
     * 
     * @param dateEnvoiConf La nouvelle date.
     */
    public void setDateEnvoiConf(Calendar dateEnvoiConf) {
        this.dateEnvoiConf = dateEnvoiConf;
    }

    public int getNbReservations() {
        return nbReservations;
    }

    public void setNbReservations(int nbReservations) {
        Reservation.nbReservations = nbReservations;
    }

    /**
     * Change la représentation associé à la réservation.
     * 
     * @param representation La nouvelle représentation.
     */
    public void setRepresentation(Representation representation) {
        this.representation = representation;
    }

    /**
     * 
     * @return Date à laquelle la réservation a été effectuée.
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * 
     * @return Date d'envoie de la confirmation.
     */
    public Calendar getDateEnvoiConf() {
        return dateEnvoiConf;
    }

    /**
     * 
     * @return La représentation concernée par la réservation.
     */
    public Representation getRepresentation() {
        return representation;
    }

    /**
     * 
     * @return L'ensemble des billets.
     */
    public Set<Billet> getBillets() {
        return billets;
    }

    /**
     * Ajoute un billet à la réservation.
     * 
     * @param billet Le billet à ajouter.
     * @return {@code true} si le billet n'est pas déjà dans l'ensemble des billets.
     */
    public boolean ajouterBillet(Billet billet) {
        return this.getBillets().add(billet);
    }

    /**
     * Enlève un billet de la réservation.
     * @param billet Le billet à enlever.
     * @return {@code true} si l'ensemble des billet contient le billet à supprimer.
     * @throws IllegalStateException Si l'ensemble des billets ne contient qu'un seul billet ou moins.
     */
    public boolean enleverBillet(Billet billet) throws IllegalStateException {
        if (this.getBillets().size() <= 1) {
            throw new IllegalStateException("Impossible de supprimer le billet : la réservation doit avoir au moins un billet.");
        }
        return this.getBillets().remove(billet);
    }

    /**
     * 
     * @return Le client qui a réservé les billets.
     */
    public Client getClient() {
        return client;
    }

    /**
     * Change le client.
     * @param client Le nouveau client.
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * 
     * @return {@code true} si la réservation est annulée.
     */
    public boolean estAnnulee() {
        return Objects.nonNull(annulation);
    }

    /**
     * Annule une réservation.
     * @param annulation 
     */
    public void annuler(Annulation annulation) {
        this.annulation = annulation;
    }
}

package lepatio;

import java.util.Calendar;

/**
 * La classe {@code Annulation} représente l'annulation d'une réservation.
 * Une annulation est associé à une réservation, et est effectué à une date.
 * Le remboursement du billet ne se fait pas tous de suite après l'annulation.
 * 
 * @author LE BOUT Matthieu
 * @see Reservation
 * @see AnnulationArtiste
 * @see AnnulationClient
 */
public abstract class Annulation {

    private Calendar date;
    private boolean remboursementEffectue;
    private Reservation reservation;

    /**
     * Construit une annulation avec les paramètres spécifiés.
     * 
     * @param reservation           La réservation associé à l'annulation.
     * @param date                  La date de l'annulation.
     * @param remboursementEffectue Si le remboursement a été effectué.
     */
    public Annulation(Reservation reservation, Calendar date, boolean remboursementEffectue) {
        this.setReservation(reservation);
        this.setDate(date);
        this.remboursementEffectue = remboursementEffectue;
    }

    /**
     * Construit une annulation avec les paramètres spécifiés. Le remboursement n'a
     * pas encore été effectué.
     * 
     * @param reservation La réservation associé à l'annulation.
     * @param date        La date de l'annulation.
     */
    public Annulation(Reservation reservation, Calendar date) {
        this.setReservation(reservation);
        this.setDate(date);
        this.remboursementEffectue = false;
    }

    /**
     * @return La date de l'annulation.
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * Change la date de l'annulation.
     * 
     * @param date La nouvelle date de l'annulation.
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * @return {@code true} si le remboursement a été effectué.
     */
    public boolean remboursementEffectue() {
        return remboursementEffectue;
    }

    /**
     * Effectuer le remboursement.
     */
    public void rembourser() {
        this.remboursementEffectue = true;
    }

    /**
     * @return La réservation associé à l'annulation.
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * Change la réservation associé à l'annulation.
     * 
     * @param reservation La nouvelle réservation associé à l'annulation.
     */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}

package lepatio;

import java.util.Objects;

/**
 * La classe {@code Billet} représente un billet permettant d'assister à une
 * représentation d'un spectacle. Un billet concerne une réservation, un
 * fauteuil, et a une tarification.
 * 
 * @author LE BOUT Matthieu
 * @see Reservation
 * @see Fauteuil
 * @see Tarification
 */
public class Billet {

    private String numero;
    private Reservation reservation;
    private Fauteuil fauteuil;
    private Tarification tarification;

    /**
     * Construit un billet avec les caractéristiques spécifiées.
     * 
     * @param numero       Le numéro du billet.
     * @param reservation  La réservation associé au billet.
     * @param fauteuil     Le fauteuil réservé.
     * @param tarification La tarification du billet.
     */
    public Billet(String numero, Reservation reservation, Fauteuil fauteuil, Tarification tarification) {
        this.setNumero(numero);
        this.setReservation(reservation);
        this.setFauteuil(fauteuil);
        this.setTarification(tarification);
    }

    /**
     * 
     * @return Le numéro du billet.
     */
    protected String getNumero() {
        return numero;
    }

    /**
     * Change le numéro du billet.
     * 
     * @param numero Le nouveau numéro.
     */
    protected void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * 
     * @return La réservation associé au billet.
     */
    protected Reservation getReservation() {
        return reservation;
    }

    /**
     * Change la réservation associé au billet.
     * 
     * @param reservation La nouvelle réservation.
     */
    protected void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    /**
     * 
     * @return Le fauteuil réservé.
     */
    protected Fauteuil getFauteuil() {
        return fauteuil;
    }

    /**
     * Change le fauteuil réservé. Si l'ancien fauteuil n'est pas {@code null},
     * enlève ce billet de l'ancien fauteuil. Ajoute ce billet au nouveau fauteuil.
     * 
     * @param fauteuil Le nouveau fauteuil.
     */
    protected void setFauteuil(Fauteuil fauteuil) {
        if (Objects.nonNull(this.getFauteuil())) {
            this.getFauteuil().enleverBillet(this);
        }
        fauteuil.ajouterBillet(this);
        this.fauteuil = fauteuil;
    }

    /**
     * 
     * @return La tarification du billet.
     */
    public Tarification getTarification() {
        return tarification;
    }

    /**
     * Change la tarification du billet.
     * @param tarification La nouvelle tarification.
     */
    public void setTarification(Tarification tarification) {
        if (Objects.nonNull(this.getTarification())) {
            this.getTarification().enleverBillet(this);
        }
        tarification.ajouterBillet(this);
        this.tarification = tarification;
    }
}

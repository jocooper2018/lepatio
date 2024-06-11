package lepatio;

import java.util.Calendar;

/**
 * La classe {@code AnnulationClient} représente l'annulation d'une réservation
 * effectué par une client.
 * Une annulation est associé à une réservation, et est effectué à une date.
 * Le remboursement du billet ne se fait pas tous de suite après l'annulation.
 * 
 * @author LE BOUT Matthieu
 * @see Reservation
 * @see Annulation
 * @see AnnulationArtiste
 */
public class AnnulationClient extends Annulation {

    /**
     * Construit une annulation avec les paramètres spécifiés. Le remboursement n'a
     * pas encore été effectué.
     * 
     * @param reservation La réservation associé à l'annulation.
     * @param date        La date de l'annulation.
     */
    public AnnulationClient(Reservation reservation, Calendar date) {
        super(reservation, date);
    }
    
    /**
     * Construit une annulation avec les paramètres spécifiés.
     * 
     * @param reservation           La réservation associé à l'annulation.
     * @param date                  La date de l'annulation.
     * @param remboursementEffectue Si le remboursement a été effectué.
     */
    public AnnulationClient(Reservation reservation, Calendar date, boolean remboursementEffectue) {
        super(reservation, date, remboursementEffectue);
    }
}

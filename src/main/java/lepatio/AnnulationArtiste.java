package lepatio;

import java.util.Calendar;

public class AnnulationArtiste extends Annulation {

    public AnnulationArtiste(Reservation reservation, Calendar date) {
        super(reservation, date);
    }
    
    public AnnulationArtiste(Reservation reservation, Calendar date, boolean remboursementEffectue) {
        super(reservation, date, remboursementEffectue);
    }
}

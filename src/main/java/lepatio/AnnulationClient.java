package lepatio;

import java.util.Calendar;

public class AnnulationClient extends Annulation {

    public AnnulationClient(Reservation reservation, Calendar date) {
        super(reservation, date);
    }
    
    public AnnulationClient(Reservation reservation, Calendar date, boolean remboursementEffectue) {
        super(reservation, date, remboursementEffectue);
    }
}

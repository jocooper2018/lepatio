package lepatio;

import java.util.Calendar;

public class AnnulationArtiste extends Annulation {

    public AnnulationArtiste(Calendar date) {
        super(date);
    }
    
    public AnnulationArtiste(Calendar date, boolean remboursementEffectue) {
        super(date, remboursementEffectue);
    }
}

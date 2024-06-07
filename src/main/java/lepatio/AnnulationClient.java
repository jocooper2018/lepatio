package lepatio;

import java.util.Calendar;

public class AnnulationClient extends Annulation {

    public AnnulationClient(Calendar date) {
        super(date);
    }
    
    public AnnulationClient(Calendar date, boolean remboursementEffectue) {
        super(date, remboursementEffectue);
    }
}

package lepatio;

import java.util.Calendar;

public abstract class Annulation {
    
    private Calendar date;
    private boolean remboursementEffectue;
    
    public Annulation(Calendar date, boolean remboursementEffectue) {
        this.setDate(date);
        this.remboursementEffectue = remboursementEffectue;
    }

    public Annulation(Calendar date) {
        this.setDate(date);
        this.remboursementEffectue = false;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public boolean remboursementEffectue() {
        return remboursementEffectue;
    }

    public void rembourser() {
        this.remboursementEffectue = true;
    }
}

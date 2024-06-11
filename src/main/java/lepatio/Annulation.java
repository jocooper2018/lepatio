package lepatio;

import java.util.Calendar;

public abstract class Annulation {
    
    private Calendar date;
    private boolean remboursementEffectue;
    private Reservation reservation;
    
    public Annulation(Reservation reservation, Calendar date, boolean remboursementEffectue) {
        this.setReservation(reservation);
        this.setDate(date);
        this.remboursementEffectue = remboursementEffectue;
    }

    public Annulation(Reservation reservation, Calendar date) {
        this.setReservation(reservation);
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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}

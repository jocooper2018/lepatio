package lepatio;

public class Billet {
    
    private String numero;
    private Reservation reservation;
    private Fauteuil fauteuil;
    private Tarification tarification;
    
    public Billet(String numero, Reservation reservation, Fauteuil fauteuil, Tarification tarification) {
        this.setNumero(numero);
        this.setReservation(reservation);
        this.setFauteuil(fauteuil);
        this.setTarification(tarification);
    }

    protected String getNumero() {
        return numero;
    }

    protected void setNumero(String numero) {
        this.numero = numero;
    }

    protected Reservation getReservation() {
        return reservation;
    }

    protected void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    protected Fauteuil getFauteuil() {
        return fauteuil;
    }

    protected void setFauteuil(Fauteuil fauteuil) {
        fauteuil.ajouterBillet(this);
        this.fauteuil = fauteuil;
    }

    public Tarification getTarification() {
        return tarification;
    }

    public void setTarification(Tarification tarification) {
        tarification.ajouterBillet(this);
        this.tarification = tarification;
    }
}

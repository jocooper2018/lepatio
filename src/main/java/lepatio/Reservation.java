package lepatio;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Reservation {

    private String numero;
    private Calendar date;
    private Calendar dateEnvoiConf;
    private Representation representation;
    private Set<Billet> billets;

    public Reservation(String numero, Calendar date, Calendar dateEnvoiConf, Representation representation,
            Billet premierBillet) {
        this.setNumero(numero);
        this.setDate(date);
        this.setDateEnvoiConf(dateEnvoiConf);
        this.setRepresentation(representation);
        this.billets = new HashSet<Billet>();
        this.ajouterBillet(premierBillet);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setDateEnvoiConf(Calendar dateEnvoiConf) {
        this.dateEnvoiConf = dateEnvoiConf;
    }

    public void setRepresentation(Representation representation) {
        this.representation = representation;
    }

    public Calendar getDate() {
        return date;
    }

    public Calendar getDateEnvoiConf() {
        return dateEnvoiConf;
    }

    public Representation getRepresentation() {
        return representation;
    }

    public Set<Billet> getBillets() {
        return billets;
    }

    public boolean ajouterBillet(Billet billet) {
        return this.getBillets().add(billet);
    }

    public boolean enleverBillet(Billet billet) {
        return this.getBillets().remove(billet);
    }
}

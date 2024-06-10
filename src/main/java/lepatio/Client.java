package lepatio;

import java.util.HashSet;
import java.util.Set;

public class Client {

    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String mail;
    private String numero;
    private Set<Reservation> reservations;

    public Client(String nom, String prenom, String adresse, String tel, String mail, String numero,
            Reservation premiereReservation) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdresse(adresse);
        this.setTel(tel);
        this.setMail(mail);
        this.setNumero(numero);
        this.reservations = new HashSet<Reservation>();
        this.ajouterReservation(premiereReservation);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public boolean ajouterReservation(Reservation reservation) {
        reservation.setClient(this);
        return this.getReservations().add(reservation);
    }

    public boolean enleverReservation(Reservation reservation) {
        return this.getReservations().remove(reservation);
    }
}

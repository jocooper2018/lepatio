package lepatio;

import java.util.HashSet;
import java.util.Set;

/**
 * La classe {@code Fauteuil} représente un fauteuil de la salle de spectacle.
 * Un fauteuil se trouve dans une zone de la salle, a une rangée et un numéro.
 * 
 * @author LE BOUT Matthieu
 * @see Zone
 * @see Billet
 */
public class Fauteuil {

    private String rangee;
    private String numero;
    private Zone zone;
    private Set<Billet> billets;

    /**
     * Construit un fauteuil avec les caractéristiques spécifié.
     * 
     * @param rangee La rangée du fauteuil.
     * @param numero Le numéro du fauteuil.
     * @param zone   La zone de la salle où se trouve le fauteuil.
     */
    public Fauteuil(String rangee, String numero, Zone zone) {
        this.setRangee(rangee);
        this.setNumero(numero);
        this.setZone(zone);
        this.billets = new HashSet<>();
    }

    /**
     * 
     * @return La rangée du fauteuil.
     */
    public String getRangee() {
        return rangee;
    }

    /**
     * Change la rangée du fauteuil.
     * @param rangee La nouvelle rangée du fauteuil.
     */
    public void setRangee(String rangee) {
        this.rangee = rangee;
    }

    /**
     * 
     * @return Le numéro du fauteuil.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Change le numéro du fauteuil.
     * @param numero Le nouveau numéro du fauteuil.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * 
     * @return La zone de la salle où se trouve le fauteuil.
     */
    public Zone getZone() {
        return zone;
    }

    /**
     * Change la zone de la salle où se trouve le fauteuil.
     * @param zone La nouvelle zone.
     */
    public void setZone(Zone zone) {
        this.zone = zone;
    }

    /**
     * 
     * @return L'ensemble des billets associés à ce fauteuil.
     */
    protected Set<Billet> getBillets() {
        return billets;
    }

    /**
     * Ajoute un billet à ce fauteuil.
     * @param billet Le billet à ajouter.
     * @return {@code true} si le billet n'est pas déjà associé au fauteuil.
     */
    protected boolean ajouterBillet(Billet billet) {
        return this.getBillets().add(billet);
    }

    /**
     * Enlève un billet au fauteuil.
     * @param billet Billet à enlever.
     * @return {@code true} si le billet est associé au fauteuil.
     */
    protected boolean enleverBillet(Billet billet) {
        return this.getBillets().remove(billet);
    }
}

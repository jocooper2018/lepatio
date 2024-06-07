package lepatio;

import java.util.Set;

public class Fauteuil {
    
    private String rangee;
    private String numero;
    private Zone zone;
    private Set<Billet> billets;
    
    public Fauteuil(String rangee, String numero, Zone zone) {
        this.setRangee(rangee);
        this.setNumero(numero);
        this.setZone(zone);
    }

    public String getRangee() {
        return rangee;
    }

    public void setRangee(String rangee) {
        this.rangee = rangee;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    protected Set<Billet> getBillets() {
        return billets;
    }
    
    protected boolean ajouterBillet(Billet billet) {
        return this.getBillets().add(billet);
    }

    protected boolean enleverBillet(Billet billet) {
        return this.getBillets().remove(billet);
    }
}

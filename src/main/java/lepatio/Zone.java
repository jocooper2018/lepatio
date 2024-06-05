package lepatio;

import java.util.HashSet;
import java.util.Set;

public class Zone {
    
    private String nom;
    private Set<Spectacle> spectacles;
    private static Set<Tarif> tarifs = new HashSet<Tarif>();
    
    public Zone(String nom, Spectacle premierSpectacle) {
        this.nom = nom;
        this.spectacles = new HashSet<Spectacle>();
        this.spectacles.add(premierSpectacle);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Spectacle> getSpectacles() {
        return spectacles;
    }
}

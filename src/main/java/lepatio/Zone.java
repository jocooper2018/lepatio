package lepatio;

import java.util.HashSet;
import java.util.Set;

public class Zone {
    
    private String nom;
    private Set<Spectacle> spectacles;
    
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

    protected Set<Spectacle> getSpectacles() {
        return spectacles;
    }

    protected boolean ajouterSpectacle(Spectacle spectacle) {
        return this.getSpectacles().add(spectacle);
    }

    protected boolean enleverSpectacle(Spectacle spectacle) {
        return this.getSpectacles().remove(spectacle);
    }
}

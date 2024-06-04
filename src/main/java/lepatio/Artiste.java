package lepatio;

import java.util.HashSet;
import java.util.Set;

public class Artiste {

    private String nom;
    private Set<Spectacle> spectacles;

    public Artiste(String nom, Spectacle premierSpectacle) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Artiste other = (Artiste) obj;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Artiste [nom=" + nom + "]";
    }

}

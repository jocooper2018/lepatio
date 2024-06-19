package lepatio;

import java.util.HashSet;
import java.util.Set;

/**
 * La classe {@code Artiste} représente un artiste.
 * Un artiste à un nom et interprète plusieurs spectacles.
 * Un artiste doit interpréter au moins un spectacle.
 * 
 * @author LE BOUT Matthieu
 * @see Spectacle
 */
public class Artiste {

    private String nom;
    private Set<Spectacle> spectacles;

    /**
     * Construit un artiste avec son nom et son premier spectacle.
     * 
     * @param nom Nom de l'artiste.
     */
    public Artiste(String nom) {
        this.nom = nom;
        this.spectacles = new HashSet<Spectacle>();
    }

    /**
     * 
     * @return Le nom de l'artiste.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Change le nom de l'artiste.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * 
     * @return L'ensemble des spectacles interprété par l'artiste.
     */
    public Set<Spectacle> getSpectacles() {
        return spectacles;
    }

    /**
     * Ajoute un spectacle à l'ensemble des spectacles interprété par l'artiste.
     * 
     * @param spectacle Le spectacle à ajouter.
     * @return {@code true} si l'ensemble des spectacles interprété par l'artiste ne
     *         contient pas déjà le spectacle à ajouter.
     */
    protected boolean ajouterSpectacle(Spectacle spectacle) {
        return this.getSpectacles().add(spectacle);
    }

    /**
     * Enlève un spectacle de l'ensemble des spectacles interprété par l'artiste.
     * 
     * @param spectacle Le spectacle à enlever.
     * @return {@code true} si l'ensemble des spectacles interprété par l'artiste
     *         contient le spectacle à enlever.
     * @throws IllegalStateException Si l'ensemble des spectacles interprété par
     *                               l'artiste ne contient qu'un seul spectacle ou
     *                               moins.
     */
    protected boolean enleverSpectacle(Spectacle spectacle) throws IllegalStateException {
        if (this.getSpectacles().size() <= 1) {
            throw new IllegalStateException(
                    "Impossible de supprimer le spectacle : l'artiste doit interpréter au moins un spectacle.");
        }
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

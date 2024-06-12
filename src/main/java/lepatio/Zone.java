package lepatio;

import java.util.HashSet;
import java.util.Set;

/**
 * La classe {@code Zone} représente une zone de la salle de spectacle. Une zone
 * a un nom, et est associé à au moins un spectacle.
 * 
 * @author LE BOUT Matthieu
 * @see Spectacle
 */
public class Zone {

    private String nom;
    private Set<Spectacle> spectacles;

    /**
     * Construit une zone avec les caractéristiques spécifiées.
     * 
     * @param nom              Le nom de la zone.
     * @param premierSpectacle Premier spectacle associé avec la zone.
     */
    public Zone(String nom, Spectacle premierSpectacle) {
        this.nom = nom;
        this.spectacles = new HashSet<Spectacle>();
        this.spectacles.add(premierSpectacle);
    }

    /**
     * 
     * @return Le nom de la zone.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Change le nom de la zone.
     * 
     * @param nom Le nouveau nom.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * 
     * @return L'ensemble des spectacles associé à cette zone.
     */
    protected Set<Spectacle> getSpectacles() {
        return spectacles;
    }

    /**
     * Ajoute un spectacle.
     * 
     * @param spectacle Le spectacle à ajouter.
     * @return {@code true} si le spectacle n'est pas déjà associé à cette zone.
     */
    protected boolean ajouterSpectacle(Spectacle spectacle) {
        return this.getSpectacles().add(spectacle);
    }

    /**
     * Enlève un spectacle de l'ensemble des spectacles associé à cette zone.
     * 
     * @param spectacle Le spectacle à enlever.
     * @return {@code true} si le spectacle à enlever est associé à cette zone.
     * @throws IllegalStateException Si il n'y a qu'un seul spectacle associé à
     *                               cette zone ou moins.
     */
    protected boolean enleverSpectacle(Spectacle spectacle) throws IllegalStateException {
        if (this.getSpectacles().size() <= 1) {
            throw new IllegalStateException(
                    "Impossible de supprimer le spectacle : la zone doit être associé à au moins un spectacle.");
        }
        return this.getSpectacles().remove(spectacle);
    }
}

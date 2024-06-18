package lepatio;

/**
 * La classe {@code Representation} représente une représentation d'un
 * spectacle. Une représentation est associé à un spectacle, a lieu à un jour
 * et une heure précise, et peut être annulée.
 * @author LE BOUT Matthieu
 * @see Spectacle
 */
public class Representation {

    private String jour;
    private String heure;
    private boolean annulee;
    private Spectacle spectacle;

    /**
     * Construit une représentation d'un spectacle à un jour et une heure précise.
     * 
     * @param jour Le jour où aura lieu la représentation.
     * @param heure L'heure où aura lieu la représentation.
     * @param spectacle Le spectacle qui sera représenter.
     */
    public Representation(String jour, String heure, Spectacle spectacle) {
        this.jour = jour;
        this.heure = heure;
        this.spectacle = spectacle;
        this.annulee = false;
        spectacle.ajouterRepresentation(this);
    }

    /**
     * 
     * @return Le jour de la représentation.
     */
    public String getJour() {
        return jour;
    }

    /**
     * Change le jour de la représentation.
     * @param jour Le nouveau jour de la représentation.
     */
    public void setJour(String jour) {
        this.jour = jour;
    }

    /**
     * 
     * @return L'heure de la représentation.
     */
    public String getHeure() {
        return heure;
    }

    /**
     * Change l'heure de la représentation.
     * @param heure La nouvelle heure de la représentation.
     */
    public void setHeure(String heure) {
        this.heure = heure;
    }

    /**
     * 
     * @return {@code true} si la représentation est annulée.
     */
    public boolean isAnnulee() {
        return annulee;
    }

    /**
     * Annule une représentation.
     */
    public void annuler() {
        this.annulee = true;
    }

    /**
     * 
     * @return Le spectacle représenté.
     */
    public Spectacle getSpectacle() {
        return spectacle;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((jour == null) ? 0 : jour.hashCode());
        result = prime * result + ((heure == null) ? 0 : heure.hashCode());
        result = prime * result + ((spectacle == null) ? 0 : spectacle.hashCode());
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
        Representation other = (Representation) obj;
        if (jour == null) {
            if (other.jour != null)
                return false;
        } else if (!jour.equals(other.jour))
            return false;
        if (heure == null) {
            if (other.heure != null)
                return false;
        } else if (!heure.equals(other.heure))
            return false;
        if (spectacle == null) {
            if (other.spectacle != null)
                return false;
        } else if (!spectacle.equals(other.spectacle))
            return false;
        return true;
    }
}

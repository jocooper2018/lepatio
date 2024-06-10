package lepatio;

/**
 * La classe {@code Representation} représente une représentation d'un
 * spectacle. Une représentation est associé à un spectacle, à lieu à un jour
 * et une heure précise, et peut être annulée.
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
}

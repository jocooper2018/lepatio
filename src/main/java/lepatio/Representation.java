package lepatio;

public class Representation {
    
    private String jour;
    private String heure;
    private boolean annulee;
    private Spectacle spectacle;
    
    public Representation(String jour, String heure, Spectacle spectacle) {
        this.jour = jour;
        this.heure = heure;
        this.spectacle = spectacle;
        this.annulee = false;
        spectacle.ajouterRepresentation(this);
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public void annuler() {
        this.annulee = true;
    }

    public Spectacle getSpectacle() {
        return spectacle;
    }

}

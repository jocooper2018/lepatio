package lepatio;

/**
 * La classe {@code Genre} représente un genre de spectacle.
 * @author LE BOUT Matthieu
 */
public class Genre {

    /**
     * Le libellé correspond au nom du genre.
     */
    private String libelle;

    public Genre(String libelle) {
        this.setLibelle(libelle);
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return this.libelle;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
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
        Genre other = (Genre) obj;
        if (libelle == null) {
            if (other.libelle != null)
                return false;
        } else if (!libelle.equals(other.libelle))
            return false;
        return true;
    }
    
    
}
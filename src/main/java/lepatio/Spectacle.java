package lepatio;

import java.util.HashSet;
import java.util.Set;

public class Spectacle {
    
    private String nom;
    private int duree;
    private int nbreMaxSpect;
    private Genre genre;
    private Set<Artiste> artistes;
    private Set<Representation> representations;
    
    public Spectacle(String nom, int duree, int nbreMaxSpect, Genre genre, Artiste premierArtiste) {
        this.nom = nom;
        this.duree = duree;
        this.nbreMaxSpect = nbreMaxSpect;
        this.genre = genre;
        this.artistes = new HashSet<Artiste>();
        this.artistes.add(premierArtiste);
        this.representations = new HashSet<Representation>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getNbreMaxSpect() {
        return nbreMaxSpect;
    }

    public void setNbreMaxSpect(int nbreMaxSpect) {
        this.nbreMaxSpect = nbreMaxSpect;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    protected Set<Artiste> getArtistes() {
        return artistes;
    }

    public boolean ajouterArtiste(Artiste artiste) {
        artiste.ajouterSpectacle(this);
        return this.getArtistes().add(artiste);
    }

    public boolean enleverArtiste(Artiste artiste) {
        artiste.enleverSpectacle(this);
        return this.getArtistes().remove(artiste);
    }

    protected Set<Representation> getRepresentations() {
        return representations;
    }

    protected boolean ajouterRepresentation(Representation representation) {
        return this.getRepresentations().add(representation);
    }

    protected boolean enleverRepresentation(Representation representation) {
        return this.getRepresentations().remove(representation);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((artistes == null) ? 0 : artistes.hashCode());
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
        Spectacle other = (Spectacle) obj;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        if (artistes == null) {
            if (other.artistes != null)
                return false;
        } else if (!artistes.equals(other.artistes))
            return false;
        return true;
    }
}

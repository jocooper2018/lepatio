package lepatio;

import java.util.HashSet;
import java.util.Set;

/**
 * La classe {@code Spectacle} représente un spectacle.
 * Un spectacle peut faire l'objet de plusieurs représentations.
 * 
 * @author LE BOUT Matthieu
 * @see Representation
 */
public class Spectacle {

    private String nom;
    private int duree;
    private int nbreMaxSpect;
    private Genre genre;
    private Set<Artiste> artistes;
    private Set<Representation> representations;
    private Set<Zone> zones;
    private static Set<Tarif> tarifs = new HashSet<Tarif>();

    /**
     * Construit un nouveau spectacle avec les paramètres spécifiés.
     * 
     * @param nom                    Le nom du spectacle.
     * @param duree                  La durée du spectacle.
     * @param nbreMaxSpect           Le nombre maximum de spectateurs pouvant
     *                               assister à une représentation du spectacle.
     * @param genre                  Le genre du spectacle.
     * @param premierArtiste         Le premier artiste à ajouter à la liste
     *                               d'artiste.
     * @param premiereZone           La première zone à ajouter à la liste des
     *                               zones.
     * @param pleinTarifPremiereZone Le plein tarif associé à la première zone à
     *                               ajouter.
     */
    public Spectacle(String nom, int duree, int nbreMaxSpect, Genre genre, Artiste premierArtiste, Zone premiereZone,
            long pleinTarifPremiereZone) {
        this.setNom(nom);
        this.setDuree(duree);
        this.setNbreMaxSpect(nbreMaxSpect);
        this.setGenre(genre);
        this.artistes = new HashSet<Artiste>();
        this.ajouterArtiste(premierArtiste);
        this.representations = new HashSet<Representation>();
        this.zones = new HashSet<Zone>();
        this.ajouterZone(premiereZone, pleinTarifPremiereZone);
    }

    /**
     * Retourne le nom du spectacle.
     * 
     * @return Le nom du spectacle.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom du spectacle.
     * 
     * @param nom Le nouveau nom du spectacle.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la durée du spectacle.
     * 
     * @return La durée du spectacle.
     */
    public int getDuree() {
        return duree;
    }

    /**
     * Modifie la durée du spectacle.
     * 
     * @param duree La nouvelle durée du spectacle.
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * Retourne le nombre maximum de spectateur pouvant assister au spectacle.
     * 
     * @return Le nombre maximum de spectateur pouvant assister au spectacle.
     */
    public int getNbreMaxSpect() {
        return nbreMaxSpect;
    }

    /**
     * Modifie le nombre maximum de spectateur pouvant assister au spectacle.
     * 
     * @param nbreMaxSpect Le nouveau nombre maximum de spectateur pouvant assister
     *                     au spectacle.
     */
    public void setNbreMaxSpect(int nbreMaxSpect) {
        this.nbreMaxSpect = nbreMaxSpect;
    }

    /**
     * Retourne le genre du spectacle.
     * 
     * @return Le genre du spectacle.
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Modifie le genre du spectacle.
     * 
     * @param genre Le nouveau genre du spectacle.
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     * Retourne l'ensemble des artistes.
     * 
     * @return L'ensemble ({@code Set}) des artistes.
     */
    protected Set<Artiste> getArtistes() {
        return artistes;
    }

    /**
     * Ajoute un artiste au spectacle, et ajoute ce spectacle à l'artiste ajouté.
     * 
     * @param artiste L'artiste à ajouter.
     * @return {@code true} si l'ensemble des artistes ne contient pas déjà
     *         l'artiste à ajouter et si l'ensemble des spectacle de l'artiste ne
     *         contient pas déjà ce spectacle.
     */
    public boolean ajouterArtiste(Artiste artiste) {
        return artiste.ajouterSpectacle(this) && this.getArtistes().add(artiste);
    }

    /**
     * Enlève un artiste de l'ensemble des artistes, et ce spectacle de l'ensemble
     * des spectacles de l'artiste.
     * 
     * @param artiste L'artiste à enlever.
     * @return {@code true} si l'ensemble des artistes contient l'artiste à enlever
     *         et si l'ensemble des spectacle de l'artiste contient ce spectacle.
     * @throws IllegalStateException Si l'ensemble des artiste contient un seul
     *                               artiste ou moins.
     */
    public boolean enleverArtiste(Artiste artiste) throws IllegalStateException {
        if (this.getArtistes().size() <= 1) {
            throw new IllegalStateException(
                    "Impossible de supprimer l'artiste : le spectacle doit contenir au moins un artiste.");
        }
        return artiste.enleverSpectacle(this) && this.getArtistes().remove(artiste);
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

    public Set<Zone> getZones() {
        return this.zones;
    }

    public boolean ajouterZone(Zone zone, long pleinTarifZone) {
        zone.ajouterSpectacle(this);
        Spectacle.ajouterTarif(new Tarif(pleinTarifZone, this, zone));
        return this.getZones().add(zone);
    }

    public boolean enleverZone(Zone zone) throws Exception {
        if (this.getZones().size() <= 1) {
            throw new Exception("Impossible d'enlever la dernière zone");
        }
        zone.enleverSpectacle(this);
        Spectacle.enleverTarif(Spectacle.getTarif(this, zone));
        return this.getZones().remove(zone);
    }

    public static Tarif getTarif(Spectacle spectacle, Zone zone) {
        for (Tarif tarif : Spectacle.tarifs) {
            if (tarif.getSpectacle().equals(spectacle) && tarif.getZone().equals(zone)) {
                return tarif;
            }
        }
        return null;
    }

    public static boolean ajouterTarif(Tarif tarif) {
        return Spectacle.tarifs.add(tarif);
    }

    public static boolean enleverTarif(Tarif tarif) {
        return Spectacle.tarifs.remove(tarif);
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

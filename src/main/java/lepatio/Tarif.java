package lepatio;

/**
 * La classe {@code Tarif} contient le plein tarif associé à un spectacle et à
 * une zone.
 * 
 * @author LE BOUT Matthieu
 * @see Spectacle
 * @see Zone
 */
public class Tarif {

    private long pleinTarif;
    private Spectacle spectacle;
    private Zone zone;

    /**
     * Construit un tarif avec les caractéristique spécifiées.
     * 
     * @param pleinTarif Le plein tarif en centimes.
     * @param spectacle  Le spectacle associé.
     * @param zone       La zone associé.
     */
    public Tarif(long pleinTarif, Spectacle spectacle, Zone zone) {
        this.pleinTarif = pleinTarif;
        this.spectacle = spectacle;
        this.zone = zone;
    }

    /**
     * 
     * @return Le plein tarif en centimes.
     */
    public long getPleinTarif() {
        return pleinTarif;
    }

    /**
     * Change le plein tarif.
     * @param pleinTarif Le nouveau plein tarif en centimes.
     */
    public void setPleinTarif(long pleinTarif) {
        this.pleinTarif = pleinTarif;
    }

    /**
     * 
     * @return Le spectacle associé.
     */
    public Spectacle getSpectacle() {
        return spectacle;
    }

    /**
     * Change le spectacle associé.
     * @param spectacle Le nouveau spectacle associé.
     */
    public void setSpectacle(Spectacle spectacle) {
        this.spectacle = spectacle;
    }

    /**
     * 
     * @return La zone associé.
     */
    public Zone getZone() {
        return zone;
    }

    /**
     * Change la zone associé.
     * @param zone La nouvelle zone associé.
     */
    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public long calculerMontant(Billet billet) {
        
        long tarifBillet = this.pleinTarif;
        if(billet.getReservation().getClient().estAbonne()){
            tarifBillet = (long)(this.pleinTarif * (1-TarifAbonne.reductionStatic));
        }
        else if(billet.getReservation().getNbReservations() >= 8){
            tarifBillet = (long)(this.pleinTarif * (1-TarifGroupe.reductionStatic));
        }
        return tarifBillet;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (pleinTarif ^ (pleinTarif >>> 32));
        result = prime * result + ((spectacle == null) ? 0 : spectacle.hashCode());
        result = prime * result + ((zone == null) ? 0 : zone.hashCode());
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
        Tarif other = (Tarif) obj;
        if (pleinTarif != other.pleinTarif)
            return false;
        if (spectacle == null) {
            if (other.spectacle != null)
                return false;
        } else if (!spectacle.equals(other.spectacle))
            return false;
        if (zone == null) {
            if (other.zone != null)
                return false;
        } else if (!zone.equals(other.zone))
            return false;
        return true;
    }
}

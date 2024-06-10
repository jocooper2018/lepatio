package lepatio;

public class Tarif {
    
    private long pleinTarif;
    private Spectacle spectacle;
    private Zone zone;

    public Tarif(long pleinTarif, Spectacle spectacle, Zone zone) {
        this.pleinTarif = pleinTarif;
        this.spectacle = spectacle;
        this.zone = zone;
    }

    public long getPleinTarif() {
        return pleinTarif;
    }

    public void setPleinTarif(long pleinTarif) {
        this.pleinTarif = pleinTarif;
    }

    public Spectacle getSpectacle() {
        return spectacle;
    }

    public void setSpectacle(Spectacle spectacle) {
        this.spectacle = spectacle;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
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

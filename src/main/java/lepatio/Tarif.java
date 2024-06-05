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

    
}

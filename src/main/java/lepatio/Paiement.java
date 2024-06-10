package lepatio;

public abstract class Paiement {
    
    private boolean realise;

    public Paiement(boolean realise) {
        this.realise = realise;
    }

    public Paiement() {
        this.realise = false;
    }

    public void realiserLePaiement() {
        this.realise = true;
    }

    public boolean isRealise() {
        return realise;
    }
}

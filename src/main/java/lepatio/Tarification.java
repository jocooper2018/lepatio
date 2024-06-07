package lepatio;

import java.util.HashSet;
import java.util.Set;

public abstract class Tarification {
    
    private Set<Billet> billets;
    
    public Tarification() {
        this.billets = new HashSet<Billet>();
    }

    public Set<Billet> getBillets() {
        return billets;
    }

    public boolean ajouterBillet(Billet billet) {
        return this.getBillets().add(billet);
    }

    public boolean enleverBillet(Billet billet) {
        return this.getBillets().remove(billet);
    }
}

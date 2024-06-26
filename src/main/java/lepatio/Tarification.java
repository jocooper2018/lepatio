package lepatio;

import java.util.HashSet;
import java.util.Set;

/**
 * La classe {@code Tarification} représente la tarification associé à un
 * billet. Certaine tarification apporte des réductions.
 * 
 * @author LE BOUT Matthieu
 * @see Billet
 * @see TarifJeune
 * @see TarifAdulte
 * @see TarifSenior
 * @see TarifGroupe
 * @see TarifAbonne
 */
public abstract class Tarification {

    private Set<Billet> billets;

    /**
     * Construit une tarification.
     */
    public Tarification() {
        this.billets = new HashSet<Billet>();
    }

    /**
     * @return L'ensemble des billets associés.
     */
    public Set<Billet> getBillets() {
        return billets;
    }

    /**
     * Ajoute un billet à l'ensemble des billet associés
     * 
     * @param billet Le billet à associer
     * @return {@code true} si le billet n'est pas déjà associé.
     */
    public boolean ajouterBillet(Billet billet) {
        return this.getBillets().add(billet);
    }

    /**
     * Enlève un billet à l'ensemble des billets associés.
     * 
     * @param billet Le billet à enlever.
     * @return {@code true} si le billet est associé.
     */
    public boolean enleverBillet(Billet billet) {
        return this.getBillets().remove(billet);
    }
}

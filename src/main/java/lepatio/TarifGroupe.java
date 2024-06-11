package lepatio;

/**
 * La classe {@code TarifGroupe} représente une tarification qui s'applique aux
 * d'au moins 20 adultes. Cette tarification apporte une réduction de 15%.
 * 
 * @author LE BOUT Matthieu
 * @see Billet
 * @see Tarification
 * @see TarifJeune
 * @see TarifAdulte
 * @see TarifSenior
 * @see TarifAbonne
 */
public class TarifGroupe extends Tarification {
    
    public static final double reductionStatic = 0.15;
    
    /**
     * Construit un TarifGroupe
     */

    public TarifGroupe() {
        super();
    }
}

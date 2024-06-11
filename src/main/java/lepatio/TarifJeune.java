package lepatio;

/**
 * La classe {@code TarifJeune} représente une tarification au tarif jeune
 * associé à un billet. Cette tarification apporte une réductions de 30%.
 * 
 * @author LE BOUT Matthieu
 * @see Billet
 * @see Tarification
 * @see TarifAdulte
 * @see TarifSenior
 * @see TarifGroupe
 * @see TarifAbonne
 */
public class TarifJeune extends Tarification {

    public static final double reductionStatic = 0.3;

    /**
     * Construit un TarifJeune
     */
    public TarifJeune() {
        super();
    }
}

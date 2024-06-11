package lepatio;

/**
 * La classe {@code TarifJeune} représente une tarification qui s'plique aux
 * jeunes de moins de 25 ans. Cette tarification apporte une réduction de 30%.
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

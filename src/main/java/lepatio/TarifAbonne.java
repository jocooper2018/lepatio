package lepatio;

/**
 * La classe {@code TarifAbonne} représente une tarification qui s'applique aux
 * clients qui assiste à au moins 3 spectacles par an. Cette tarification
 * apporte une réduction de 30%.
 * 
 * @author LE BOUT Matthieu
 * @see Billet
 * @see Tarification
 * @see TarifJeune
 * @see TarifAdulte
 * @see TarifSenior
 * @see TarifGroupe
 */
public class TarifAbonne extends Tarification {

    public static final double reductionStatic = 0.3;

    /**
     * Construit un TarifJeune
     */
    public TarifAbonne() {
        super();
    }

}

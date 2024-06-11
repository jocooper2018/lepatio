package lepatio;

/**
 * La classe {@code TarifSenior} représente une tarification qui s'plique aux
 * senior de plus de 65 ans. Cette tarification apporte une réduction de 25%.
 * 
 * @author LE BOUT Matthieu
 * @see Billet
 * @see Tarification
 * @see TarifAdulte
 * @see TarifSenior
 * @see TarifGroupe
 * @see TarifAbonne
 */
public class TarifSenior extends Tarification {
    
    public static final double reductionStatic = 0.25;

    public TarifSenior() {
        super();
    }
}

package lepatio;

/**
 * La classe {@code TarifJeune} représente une tarification au tarif normal
 * associé à un billet. Cette tarification n'apporte pas de réductions.
 * 
 * @author LE BOUT Matthieu
 * @see Billet
 * @see Tarification
 * @see TarifJeune
 * @see TarifSenior
 * @see TarifGroupe
 * @see TarifAbonne
 */
public class TarifAdulte extends Tarification {

    public static final double reductionStatic = 0.0;

    public TarifAdulte() {
        super();
    }
}

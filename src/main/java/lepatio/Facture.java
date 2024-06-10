package lepatio;

public class Facture {
    
    private String numero;
    private long montantTTC;
    private Paiement paiement;
    
    private static double tauxTVA = 0.2;

    public Facture(String numero, long montantTTC, Paiement paiement) {
        this.setNumero(numero);
        this.setMontantTTC(montantTTC);
        this.setPaiement(paiement);
    }

    public String getNumero() {
        return numero;
    }

    private void setNumero(String numero) {
        this.numero = numero;
    }

    public long getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(long montantTTC) {
        this.montantTTC = montantTTC;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }
    
}

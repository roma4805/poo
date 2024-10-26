package tp;
public class CompteCourant extends CompteBancaire {
    // Attribut supplémentaire
    private double decouvertAutorise;

    // Constructeur
    public CompteCourant(String numeroCompte, String titulaire, double decouvertAutorise) {
        super(numeroCompte, titulaire); // Appel au constructeur de la classe mère
        this.decouvertAutorise = decouvertAutorise;
    }

    // Surcharge de la méthode retirer pour permettre un découvert autorisé
    @Override
    public void retirer(double montant) {
        if (montant > 0 && solde - montant >= -decouvertAutorise) {
            solde -= montant;
            System.out.println("Retrait effectué : " + montant + " euros (découvert autorisé)");
        } else {
            System.out.println("Retrait impossible : montant dépasse le découvert autorisé.");
        }
    }

    // Getter pour le découvert autorisé (optionnel)
    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }
}


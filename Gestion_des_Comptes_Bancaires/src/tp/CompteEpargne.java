package tp;

public class CompteEpargne extends CompteBancaire {
    // Attribut supplémentaire
    private double tauxInteret;

    // Constructeur
    public CompteEpargne(String numeroCompte, String titulaire, double tauxInteret) {
        super(numeroCompte, titulaire); // Appel au constructeur de la classe mère
        this.tauxInteret = tauxInteret;
    }

    // Méthode pour calculer et appliquer les intérêts au solde
    public void calculerInteret() {
        double interet = solde * tauxInteret / 100;
        deposer(interet);
        System.out.println("Intérêts de " + interet + " euros ajoutés au compte.");
    }

    // Getter pour le taux d'intérêt (optionnel)
    public double getTauxInteret() {
        return tauxInteret;
    }
}


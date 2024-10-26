package tp;
import java.util.ArrayList;
import java.util.List;

public class CompteBancaire {
    // Attributs
    protected String numeroCompte;
    protected double solde;
    protected String titulaire;
    private List<Transaction> transactions; // Liste pour enregistrer les transactions

    // Constructeur
    public CompteBancaire(String numeroCompte, String titulaire) {
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.solde = 0.0;
        this.transactions = new ArrayList<>(); // Initialisation de la liste des transactions
    }

    // Méthode pour déposer de l'argent sur le compte
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            transactions.add(new Transaction("credit", montant)); // Enregistrer la transaction
            System.out.println("Dépôt effectué : " + montant + " euros");
        } else {
            System.out.println("Le montant de dépôt doit être positif.");
        }
    }

    // Méthode pour retirer de l'argent en vérifiant que le solde est suffisant
    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            transactions.add(new Transaction("debit", montant)); // Enregistrer la transaction
            System.out.println("Retrait effectué : " + montant + " euros");
        } else if (montant > solde) {
            System.out.println("Solde insuffisant pour effectuer ce retrait.");
        } else {
            System.out.println("Le montant de retrait doit être positif.");
        }
    }

    // Méthode pour afficher le solde actuel du compte
    public void afficherSolde() {
        System.out.println("Solde actuel du compte : " + solde + " euros");
    }

    // Méthode pour afficher l'historique des transactions
    public void afficherHistoriqueTransactions() {
        System.out.println("Historique des transactions pour le compte " + numeroCompte + " :");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    // Getters
    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    // Setter pour le titulaire
    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }
}

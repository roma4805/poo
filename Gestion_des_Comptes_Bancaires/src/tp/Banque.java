package tp;

import java.util.ArrayList;

public class Banque {
    // Attributs
    private ArrayList<CompteBancaire> comptes; // Liste pour stocker les comptes bancaires
    private static int nombreComptes = 0; // Attribut partagé entre toutes les instances de la classe

    // Constructeur qui initialise la liste des comptes
    public Banque() {
        this.comptes = new ArrayList<>();
    }

    // Méthode pour ajouter un nouveau compte à la banque
    public void ajouterCompte(CompteBancaire compte) {
        comptes.add(compte);
        nombreComptes++; // Incrémente le nombre total de comptes bancaires
        System.out.println("Compte ajouté : " + compte.getNumeroCompte());
    }

    // Méthode pour rechercher un compte par son numéro
    public CompteBancaire chercherCompte(String numeroCompte) {
        for (CompteBancaire compte : comptes) {
            if (compte.getNumeroCompte().equals(numeroCompte)) {
                return compte;
            }
        }
        System.out.println("Compte avec le numéro " + numeroCompte + " introuvable.");
        return null; // Retourne null si le compte n'est pas trouvé
    }

    // Méthode pour transférer de l'argent d'un compte à un autre
    public void transfert(String numeroSource, String numeroDest, double montant) {
        CompteBancaire compteSource = chercherCompte(numeroSource);
        CompteBancaire compteDest = chercherCompte(numeroDest);

        if (compteSource != null && compteDest != null) {
            if (compteSource.getSolde() >= montant) {
                compteSource.retirer(montant);
                compteDest.deposer(montant);
                System.out.println("Transfert de " + montant + " euros effectué de " + numeroSource + " vers " + numeroDest);
            } else {
                System.out.println("Solde insuffisant pour effectuer le transfert.");
            }
        } else {
            System.out.println("Transfert impossible : un ou plusieurs comptes sont introuvables.");
        }
    }

    // Méthode statique pour afficher le nombre total de comptes bancaires
    public static void afficherNombreComptes() {
        System.out.println("Nombre total de comptes bancaires : " + nombreComptes);
    }
}

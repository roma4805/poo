package tp;

public class BanqueTest {
    public static void main(String[] args) {
        // Création de la banque
        Banque banque = new Banque();

        // Ajout de trois comptes bancaires avec des numéros et des titulaires différents
        CompteBancaire compte1 = new CompteBancaire("001", "Alice Dupont");
        CompteBancaire compte2 = new CompteBancaire("002", "Bob Martin");
        CompteBancaire compte3 = new CompteBancaire("003", "Charlie Durand");

        banque.ajouterCompte(compte1);
        banque.ajouterCompte(compte2);
        banque.ajouterCompte(compte3);

        // Effectuer des dépôts sur les comptes
        compte1.deposer(1000);
        compte2.deposer(500);
        compte3.deposer(300);

        // Effectuer des retraits sur les comptes
        compte1.retirer(200);
        compte2.retirer(100);

        // Effectuer un transfert entre les comptes
        banque.transfert("001", "002", 150);

        // Afficher le solde des comptes après les transactions
        System.out.println("\nSolde des comptes après transactions :");
        compte1.afficherSolde();
        compte2.afficherSolde();
        compte3.afficherSolde();

        // Afficher le nombre total de comptes créés
        Banque.afficherNombreComptes();
     // Création de comptes courants avec un découvert autorisé
        CompteCourant compteCourant1 = new CompteCourant("001", "Alice Dupont", 500);
        CompteCourant compteCourant2 = new CompteCourant("002", "Bob Martin", 300);

        // Création de comptes épargne avec un taux d'intérêt
        CompteEpargne compteEpargne1 = new CompteEpargne("003", "Charlie Durand", 2.5);
        CompteEpargne compteEpargne2 = new CompteEpargne("004", "Diane Leroy", 3.0);

        // Ajout des comptes à la banque
        banque.ajouterCompte(compteCourant1);
        banque.ajouterCompte(compteCourant2);
        banque.ajouterCompte(compteEpargne1);
        banque.ajouterCompte(compteEpargne2);

        // Opérations sur les comptes courants
        compteCourant1.deposer(1000);
        compteCourant1.retirer(1200); // Retrait possible grâce au découvert
        compteCourant2.deposer(500);
        compteCourant2.retirer(900); // Retrait dépasse le découvert autorisé

        // Opérations sur les comptes épargne
        compteEpargne1.deposer(1000);
        compteEpargne1.calculerInteret(); // Calcul et ajout des intérêts
        compteEpargne2.deposer(2000);
        compteEpargne2.calculerInteret();

        // Afficher les soldes après les opérations
        System.out.println("\nSoldes des comptes après les opérations :");
        compteCourant1.afficherSolde();
        compteCourant2.afficherSolde();
        compteEpargne1.afficherSolde();
        compteEpargne2.afficherSolde();
        // Afficher l'historique des transactions pour chaque compte
        System.out.println("\nHistorique des transactions :");
        compte1.afficherHistoriqueTransactions();
        compte2.afficherHistoriqueTransactions();
    }

}


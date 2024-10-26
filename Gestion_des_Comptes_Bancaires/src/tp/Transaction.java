package tp;


import java.util.Date;

public class Transaction {
    // Attributs
    private String type; // "credit" pour dépôt, "debit" pour retrait
    private double montant;
    private Date date;

    // Constructeur
    public Transaction(String type, double montant) {
        this.type = type;
        this.montant = montant;
        this.date = new Date(); // Initialise la date à la date actuelle
    }

    // Méthode pour afficher les informations de la transaction
    public String toString() {
        return "Type: " + type + ", Montant: " + montant + ", Date: " + date;
    }
}

package Compte;

import TP_POO.Saisie;

public class CreationCompte {
	
    public static void main(String[] args) {
        Compte compte = creerCompteViaConsole();

        System.out.println("Compte créé : ");
        compte.afficheTout();
        
    }

    public static Compte creerCompteViaConsole() {
        // Demande � l'utilisateur de saisir les d�tails du compte
        System.out.println("Création d'un nouveau compte :");
        String titulaire = Saisie.lire_String("Nom du titulaire : ");
        int numero = Saisie.lire_int("Numéro du compte : ");
        double solde = Saisie.lire_double("Solde initial du compte : ");
        double decouvert = Saisie.lire_double("Découvert autorisé du compte : ");

        // Cr�ation du compte avec les informations saisies
        return new Compte(titulaire, numero, solde, decouvert);
    }
    
}

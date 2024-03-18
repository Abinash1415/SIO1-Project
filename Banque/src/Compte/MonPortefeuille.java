package Compte;

import java.util.ArrayList;

public class MonPortefeuille {
	
    private ArrayList<Compte> mesComptes;

    public MonPortefeuille() {
        this.mesComptes = new ArrayList<>();
    }

    public void ajouterCompte(Compte nouveauCompte) {
        mesComptes.add(nouveauCompte);
    }

    public void afficherSoldeTotal() {
        double soldeTotal = 0;
        for (Compte compte : mesComptes) {
            soldeTotal += compte.getSolde();
        }
        System.out.println("Le solde total de tous les comptes est : " + soldeTotal + "�");
    }

    public static void main(String[] args) {
        MonPortefeuille portefeuille = new MonPortefeuille();

        // Cr�ation des comptes
        Compte compte1 = new Compte("Abinash", 10, 10000.0, 500.0);
        Compte compte2 = new Compte("Leon", 11, 10000.0, 500.0);
        Compte compte3 = new Compte("Mohammed", 12, 10000.0, 500.0);
        Compte compte4 = new Compte("Amath", 13, 10000.0, 500.0);
        
        // Ajout des comptes au portefeuille
        portefeuille.ajouterCompte(compte1);
        portefeuille.ajouterCompte(compte2);
        portefeuille.ajouterCompte(compte3);
        portefeuille.ajouterCompte(compte4);
        
        portefeuille.afficherComptes();
    }
    
    public void afficherComptes() {
        System.out.println("Liste des comptes dans le portefeuille :");
        System.out.println("");
        for (Compte compte : mesComptes) {
           compte.afficheTout();
            System.out.println("");
        }
    }

}
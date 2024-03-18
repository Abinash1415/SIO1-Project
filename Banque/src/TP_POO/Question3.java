package TP_POO;

import Collection.CollectionCompte;
import Compte.Compte;

class Question3 {
	
	// 12 Comptes 
    public static void main(String[] args) {
        CollectionCompte collectionCompte = new CollectionCompte();

        for (int i = 1; i <= 4; i++)
        {
            String titulaire = "Titulaire N�" + i;
            int numero = 1000 + i;
            // cr�� al�atoirement un nombre compris entre 0.0 et 10000/1000
            int solde = (int) (Math.random() * 10000);
            int decouvert = (int) (Math.random() * 1000);

            Compte nouveauCompte = new Compte(titulaire, numero, solde, decouvert);
            collectionCompte.ajouterCompte(nouveauCompte);
        }

        
        // message liste vide ou non
        if (collectionCompte.getNombreDeComptes() == 0) {
            System.out.println("La liste de comptes est vide.");
        } else {
            System.out.println("La liste de comptes n'est pas vide.");
        }

        collectionCompte.afficherTouteLaCollection();
        System.out.println("Nombre total de comptes : " + collectionCompte.getNombreDeComptes());
    }

}

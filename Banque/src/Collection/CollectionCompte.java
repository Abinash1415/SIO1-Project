package Collection;

import java.util.ArrayList;

import Compte.Compte;

public class CollectionCompte {

    private ArrayList<Compte> MonPortefeuille;

    public CollectionCompte() {
        MonPortefeuille = new ArrayList<>();
    }

    public void ajouterCompte(Compte nouveauCompte) {
        MonPortefeuille.add(nouveauCompte);
    }

    public void afficherTouteLaCollection() {
        System.out.println("CollectionCompte fonction ");
        int numeroCompte = 1;

        // for r�cup�re chaque objet Compte dans la collection MonPortefeuille
        for (Compte compte : MonPortefeuille) {
            System.out.println("Compte N�" + numeroCompte);
            System.out.println("Titulaire : " + compte.getTitulaire());
            System.out.println("Num�ro : " + compte.getNum());
            System.out.println("Solde : " + compte.getSolde() + "�");
            System.out.println("D�couvert : " + compte.getDecouvert() + "�");
            System.out.println("");
            numeroCompte++;
        }
    }

    public int getNombreDeComptes() {
        return MonPortefeuille.size();
    }
    
    public Compte rechercherCompteParNumero(int numero) {
        for (Compte compte : MonPortefeuille) {
            if (compte.getNum() == numero) {
                return compte; // Si trouver
            }
        }
        return null; // Non trouver
    }

    public void afficherTousLesComptes() {
        System.out.println("Liste de tous les comptes :");
        for (Compte compte : MonPortefeuille) {
            compte.afficheTout(); // Utilise la m�thode afficheTout() de la classe Compte
        }
    }
    
}
    
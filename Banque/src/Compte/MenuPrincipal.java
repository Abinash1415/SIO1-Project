package Compte;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MenuPrincipal {

    public static void main(String[] args) {

        List<Compte> listeComptes = new ArrayList<>();

        boolean continuer = true;

        while (continuer) {
            int choix = Saisie.lire_int(""
            		+ "Menu:\n1. Créer un nouveau compte"
            		+ "\n2. Afficher tous les comptes"
            		+ "\n3. Supprimer un compte"
            		+ "\n4. ModIfier le taux de rémunération du compte Epargne"
            		+ "\n5. Quitter\nVotre choix : ");

            switch (choix) {	
                case 1:
                    // Ajouter un nouveau compte
                    Compte nouveauCompte = CreationCompte.creerCompteViaConsole();
                    listeComptes.add(nouveauCompte);
                    break;
                case 2:
                    // Afficher tous les comptes
                    for (Compte compte : listeComptes) {
                        compte.Consulte();
                    }
                    break;
                case 3:
                    // Supprimer un compte
                    int numCompteSupprimer = Saisie.lire_int("Entrez le numéro du compte à supprimer :");
                    Supprimer(listeComptes, numCompteSupprimer);
                    break;
                case 4:
                    // Augmenter le taux de rémunération des comptes Epargne
                    for (Compte compte : listeComptes) {
                        if (compte instanceof Compte_Epargne) {
                            ((Compte_Epargne) compte).mise_a_jour();
                        }
                    }
                    break;
                case 5:
                    // Quitter
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
        }
    }

    private static void Supprimer(List<Compte> listeComptes, int numCompteSupprimer) {
        boolean compteTrouve = false;
        Iterator<Compte> iterator = listeComptes.iterator();
        while (iterator.hasNext()) {
            Compte compte = iterator.next();
            if (compte.getNum() == numCompteSupprimer) {
                iterator.remove();
                compteTrouve = true;
                System.out.println("Le compte a été supprimé avec succès.");
                break;
            }
        }
        if (!compteTrouve) {
            System.out.println("Aucun compte trouvé avec ce numéro.");
        }
    }



}

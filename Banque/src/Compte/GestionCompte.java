package Compte;

import java.util.ArrayList;
import java.util.List;

public class GestionCompte {
    
    public static void main(String[] args) {
        List<Compte> listeComptes = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Compte compte = new Compte(
                Saisie.lire_String("Quel est le nom du titulaire ?"),
                Saisie.lire_int("Quel est le numéro du compte ?"),
                Saisie.lire_double("Quel est le solde de ce compte ?")
            );
            listeComptes.add(compte);
        }

        // Affichage de tous les comptes
        for (Compte compte : listeComptes) {
            compte.Consulte();
        }

        Vide(listeComptes);
        ChercheCompte(listeComptes);
        Negatif(listeComptes);
        AjoutCompte(listeComptes);
        ModifDecouvert(listeComptes);
        int numCompteSupprimer = 1;
        Supprimer(listeComptes, numCompteSupprimer);
    }
    
    // liste de comptes est vide ou non
    public static void Vide(List<Compte> listeComptes)
	{            	
    	if (listeComptes.isEmpty()) {
            System.out.println("La liste de comptes est vide.");
        } else {
            System.out.println("La liste de comptes n'est pas vide.");
        }
	}
    
    // Rechercher un compte spécifique dans la liste
    public static void ChercheCompte(List<Compte> listeComptes) {
        int comparNumCompte = Saisie.lire_int("Quel numéro de compte cherchez-vous ?");

        boolean compteTrouve = false;

        for (Compte compte : listeComptes) {
            if (compte.getNum() == comparNumCompte) {
                System.out.println("Le solde du compte associé au numéro de compte saisi est : " + compte.getSolde());
                compteTrouve = true;
                break; // Pour arrêter la recherche une fois le compte trouvé
            }
        }

        if (!compteTrouve) {
            System.out.println("Le numéro de compte saisi ne correspond à aucun compte existant.");
        }
    }

	// Afficher tous les comptes avec un solde négatif
    public static void Negatif(List<Compte> listeComptes) {
        boolean aucunCompteNegatif = true;

        System.out.println("Voici la liste de comptes avec un solde négatif :");
        for (Compte compte : listeComptes) {
            if (compte.getSolde() < 0) {
                compte.Consulte();
                aucunCompteNegatif = false;
            }
        }

        if (aucunCompteNegatif) {
            System.out.println("Aucun compte avec un solde négatif n'a été trouvé.");
        }
    }
	
	
	// Ajouter un compte
    public static void AjoutCompte(List<Compte> listeComptes) {
        Compte nouveauCompte = CreationCompte.creerCompteViaConsole();
        listeComptes.add(nouveauCompte);

        System.out.println("Nouveau compte ajouté avec succès :");
        nouveauCompte.Consulte();
    }
	
	
	// Modifier le découvert d'un compte
    public static void ModifDecouvert(List<Compte> listeComptes) {
        int numeroCompte = Saisie.lire_int("Entrez le numéro de compte pour modifier le découvert :");

        boolean compteTrouve = false;

        for (Compte compte : listeComptes) {
            if (compte.getNum() == numeroCompte) {
                double nouveauDecouvert = Saisie.lire_double("Entrez le nouveau découvert autorisé pour ce compte :");
                compte.setDecouvert(nouveauDecouvert);
                compte.Consulte();
                compteTrouve = true;
                break;
            }
        }

        if (!compteTrouve) {
            System.out.println("Aucun compte trouvé avec ce numéro.");
        }
    }
	
    // Supprimer un compte recherché
    public static void Supprimer(List<Compte> listeComptes, int numeroCompte) {
        boolean compteTrouve = false;
        for (Compte compte : listeComptes) {
            if (compte.getNum() == numeroCompte) {
                listeComptes.remove(compte);
                compteTrouve = true;
                break;
            }
        }
        if (compteTrouve) {
            System.out.println("Le compte a été supprimé avec succès.");
        } else {
            System.out.println("Aucun compte trouvé avec ce numéro.");
        }
    }

    public static void Transfert(List<Compte> listeComptes, int numCompteEpargne, int numCompteCourant, double montant) {
        Compte_Epargne compteEpargne = null;
        Compte_Courant compteCourant = null;

        // Recherche des comptes à partir de leurs numéros
        for (Compte compte : listeComptes) {
            if (compte instanceof Compte_Epargne && compte.getNum() == numCompteEpargne) {
                compteEpargne = (Compte_Epargne) compte;
            } else if (compte instanceof Compte_Courant && compte.getNum() == numCompteCourant) {
                compteCourant = (Compte_Courant) compte;
            }
        }

        // Vérification si les deux comptes ont été trouvés
        if (compteEpargne != null && compteCourant != null) {
            // Vérification si le montant est disponible dans le compte courant
            if (compteCourant.getSolde() >= montant) {
                compteEpargne.Deposer(montant); // Crédit du montant au compte épargne
                compteCourant.Retirer(montant); // Débit du montant du compte courant
                System.out.println("Transfert effectué avec succès !");
            } else {
                System.out.println("Solde insuffisant dans le compte courant pour effectuer le transfert.");
            }
        } else {
            System.out.println("L'un des deux comptes n'a pas été trouvé.");
        }
    }

	
}
package monpackage;

import java.util.ArrayList;
import java.util.ListIterator;


public class PorteFeuilleClients {
	private ArrayList<compte> CompteClients;
	private int nbr = 0;

	public PorteFeuilleClients(){
		CompteClients = new ArrayList<compte>();
	}

	public void menu() {
	    System.out.println("╔══════════════════════════════════════════════╗");
	    System.out.println("║                 MENU PRINCIPAL               ║");
	    System.out.println("║══════════════════════════════════════════════║");
	    System.out.println("║ 1. Ajouter 3 comptes"+"                         ║");
	    System.out.println("║ 2. Afficher tous les comptes"+"                 ║");  
	    System.out.println("║ 3. Afficher les comptes avec solde négatif"+"   ║");
	    System.out.println("║ 4. Supprimer tous les comptes"+"                ║");
	    System.out.println("║ 5. Tester si la liste est vide"+"               ║"); 
	    System.out.println("║ 6. Créer un compte"+"                           ║"); 
	    System.out.println("║ 7. Rechercher un client par numéro"+"           ║"); 
	    System.out.println("║ 8. Quitter l'application"+"                     ║"); 
	    System.out.println("╚══════════════════════════════════════════════╝");
	}
	
	public void sousmenu(compte cbc) {
		ListIterator<compte> it = CompteClients.listIterator();
        
        if (it.hasNext()) {
            compte compte = it.next();
            int choixSousMenu;

            do {
            	 System.out.println("╔════════════════════════════════════════╗");
                 System.out.println("║               SOUS-MENU                ║");
                 System.out.println("║════════════════════════════════════════║");
                 System.out.println("║           Bienvenue " + cbc.getTitulaire()+"           ║");		
                 System.out.println("║ 1. Afficher le Solde"+"                   ║");
                 System.out.println("║ 2. Modifier le découvert"+"               ║");
                 System.out.println("║ 3. Supprimer le compte"+"                 ║");
                 System.out.println("║ 4. Retour"+"                              ║");
                 System.out.println("╚════════════════════════════════════════╝");

                choixSousMenu = Saisie.lire_int("Choisissez une option : ");

                switch (choixSousMenu) {
                    case 1:
                    	System.out.println("╔════════════════════════════════════════╗");
                    	System.out.println("║ Solde du compte : " + "                     ║");
                    	cbc.Consulter();
                    	System.out.println("╚════════════════════════════════════════╝");
                        break;
                    case 2:
                        double nouveauDecouvert = Saisie.lire_double("Entrez le nouveau decouvert : ");
                        cbc.setDecouvert(nouveauDecouvert);
                        System.out.println("╔════════════════════════════════════════╗");
                        System.out.println("║ Decouvert modifié avec succès." + "         ║");
                        System.out.println("╚════════════════════════════════════════╝");
                        break;
                    case 3:
                    	
                    	while (it.hasNext()) {
                            compte compte1 = it.next();
                            if (compte1 == cbc) {
                                it.remove(); // Supprimer le compte actuel
                        System.out.println("╔════════════════════════════════════════╗");
                        System.out.println("║ Compte supprimé avec succès."+ "           ║");
                        System.out.println("╚════════════════════════════════════════╝");
                        return;
                        }
                            }
                    case 4:
                    	System.out.println("╔════════════════════════════════════════╗");
                        System.out.println("║ Retour au menu principal."+ "               ║");
                        System.out.println("╚════════════════════════════════════════╝");
                        break;
            
                    default:
                    	System.out.println("╔════════════════════════════════════════╗");
                        System.out.println("║ Option invalide. Veuillez choisir une option valide."+ "               ║");
                        System.out.println("╚════════════════════════════════════════╝");
                }

            } while (choixSousMenu != 4);
        } else {
        	System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║ Aucun compte trouvé."+ "               ║");
            System.out.println("╚════════════════════════════════════════╝");
        }
    }


	public void ajouterNComptes(int nb) {
	        for (int i = 0; i < nb; i++) {
	        	int Num = nbr++;
	            String Titulaire = "Client " + Num;
	            double Solde = 1000 + (Num) * 100;
	            double Decouvert = 500;
 
	            compte cmpt = new compte(Titulaire, Num, Solde, Decouvert);
	            CompteClients.add(cmpt);
	        }
	    }
	
	public void AddNewAccount() {
        	int Num = nbr++;
            String Titulaire = Saisie.lire_String("Quelle est votre nom ?");
            double Solde = Saisie.lire_double("Quel est le montant de votre solde ?");
            double Decouvert = Saisie.lire_double("Quel est le montant maximum de votre decouvert ?");

            compte cmpt = new compte(Titulaire, Num, Solde, Decouvert);
            CompteClients.add(cmpt);
            cmpt.AfficheCompte();
        }
    

	public void affichetout() {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║ Voici les comptes : "+ "                   ║");
		System.out.println("╚════════════════════════════════════════╝");
		ListIterator<compte> it = CompteClients.listIterator();
		while(it.hasNext()) {
			Object Obj = it.next();
			compte cmpt = (compte) Obj;
			cmpt.AfficheCompte();
		}
	}

	
	public void DelAllAccount() {
		System.out.println("╔═══════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║ Voulez-vous supprimer tous les comptes ? | 1 = Oui, 2 = Non"+ "               ║");
		System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");
	    int choix = Saisie.lire_int("");
	   
	    if (choix == 1) {
	        CompteClients.clear(); // Supprime tous les éléments de la liste
	        System.out.println("╔════════════════════════════════════════╗");
	        System.out.println("║ Tous les comptes ont été supprimés."+ "    ║");
	        System.out.println("╚════════════════════════════════════════╝");
	    } else if (choix == 2) {
	    	System.out.println("╔════════════════════════════════════════════════════╗");
	        System.out.println("║ Operation annulée. Voici les comptes restants :"+ "    ║");
	        System.out.println("╚════════════════════════════════════════════════════╝");
	        ListIterator<compte> it = CompteClients.listIterator();
	        while (it.hasNext()) {
	            compte cmpt = it.next();
	            cmpt.AfficheCompte();
	        }
	    } else {
	        System.out.println("Choix invalide. Aucune action effectuée.");
	    }
	}
	
	
	public void testVide() {
		if(CompteClients.isEmpty()){
			System.out.println("╔════════════════════════════════════════╗");
			System.out.println("║ La liste est vide !" + "                    ║");
			System.out.println("╚════════════════════════════════════════╝");
		}else {
			System.out.println("╔════════════════════════════════════════╗");
			System.out.println("║ La liste n'est pas vide !"+ "              ║");
			System.out.println("╚════════════════════════════════════════╝");
		}
	}
	
	public void afficherComptesNegatifs() {
		System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║ Comptes avec solde négatif : "+ "          ║");
        ListIterator<compte> it = CompteClients.listIterator();
        if(CompteClients.isEmpty()){
        	System.out.println("╚════════════════════════════════════════╝");
       }else {
    	   System.out.println("╚════════════════════════════════════════╝");
       }
        
        while (it.hasNext()) {
            compte compte = it.next();
            if (compte.getSolde() < 0) {
                compte.AfficheCompte();
            } 
        }
    }
	
	public compte searchById() {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║ Veuillez choisir le code client : "+"     ║");
		System.out.println("╚════════════════════════════════════════╝");
		int Num1 = Saisie.lire_int("");
	ListIterator<compte> it = CompteClients.listIterator();
	while (it.hasNext()) {
        compte compte = it.next();
        if (compte.getNum() == Num1) {
            return compte;
        } 
    }
	System.out.println("╔════════════════════════════════════════╗");
	System.out.println("║ Aucun compte trouvé avec le numéro : " + Num1+ " ║");
	System.out.println("╚════════════════════════════════════════╝");
	return null;
}
	
}
	

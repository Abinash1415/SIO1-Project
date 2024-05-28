package monpackage;

public class UtilisationBanque {

	public static void main(String[] args) {


	        PorteFeuilleClients cb = new PorteFeuilleClients();
	       
	        int choix;

	        do {
	        	cb.menu();
	            choix = Saisie.lire_int("Choisissez une option : ");

	            switch (choix) {
	                case 1:
	                    cb.ajouterNComptes(3);
	                    System.out.println("╔════════════════════════════════════════╗");
	                    System.out.println("║ Les trois comptes ont été créer !"+ "      ║");
	                    System.out.println("╚════════════════════════════════════════╝");
	                    break;
	                case 2:
	                    cb.affichetout();
	                    break;
	                case 3:
	                    cb.afficherComptesNegatifs();
	                    break;
	                case 4:
	                    cb.DelAllAccount();
	                    break;
	                case 5:
	                    cb.testVide();
	                    break;
	                case 6:
	                    cb.AddNewAccount();
	                    System.out.println("╔════════════════════════════════════════╗");
	                    System.out.println("║ Le compte à été créer !"+ "                ║");
	                    System.out.println("╚════════════════════════════════════════╝");
	                    break;
	                case 7:
	                	compte cbc = cb.searchById();
	                	if(cbc != null) {
	                	cb.sousmenu(cbc);
	                	break;
	                	}
	                	break;
	                case 8:
	                	System.out.println("╔════════════════════════════════════════╗");
	                    System.out.println("║ Fin du programme."+ "                      ║");
	                    System.out.println("╚════════════════════════════════════════╝");
	                    break;
	                default:
	                	System.out.println("╔════════════════════════════════════════════════════════════╗");
	                    System.out.println("║ Option invalide. Veuillez choisir une option valide."+ " *9      ║");
	                    System.out.println("╚════════════════════════════════════════════════════════════╝");
	            }

	        } while (choix != 8);
	    }
	}
	
 



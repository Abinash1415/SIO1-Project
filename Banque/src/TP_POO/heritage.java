package TP_POO;

public class heritage {

	public class Compte
	{
		// Liste des attributs
		 public  String Titulaire;
		 public  int Num =0;
		 public  double Solde;
		 
		 // Constructeur
		 
		 public Compte( )
		 {
			   Titulaire = Saisie.lire_String("Quel est le nom du titulaire ?");
			   Num = Saisie.lire_int("Quel est le num�ro du compte ?");
			   Solde = Saisie.lire_double("Quel est le solde de ce compte ?");
			  
		 }
		 
		 // Autres m�thodes
		 
		 public void  Consulte()
			
			{
				System.out.println("Le solde du compte dont le num�ro est "+ Num +"est de" +Solde+"�");
			
			}
		  public void  Retirer(double somme)
			
			{
			  	  
			   Solde = Solde-somme;           
				
			}
		  
		  public void  Deposer(double somme)
			
			{
			 Solde = Solde+somme;
				
			}
		 
		 public  void AfficheCompte ()
		 {
			 
			 System.out.println("Voici les informations du compte");
			 System.out.println("Le titulaire du compte dont le num�ro est "+Num +" s'appelle "+Titulaire+" ");
			 System.out.println("Son solde est de "+Solde + " � ");
		 }
		 
	}

}

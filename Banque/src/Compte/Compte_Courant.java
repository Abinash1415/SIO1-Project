package Compte;

public class Compte_Courant extends Compte
{
//  D�claration des attributs
	private double  Decouvert_Autorise;
	
// D�claration du constructeur
	public Compte_Courant()
	{
	super();
	Decouvert_Autorise= Saisie.lire_double("Quel est montant ");
	}
	
  // d�claration des autres m�thodes
	public void  Retirer(double somme)
	
	{
	  if ((Solde - somme ) < Decouvert_Autorise) System.out.println("Op�ration �chou�e");
		 else 
			  {
		         Solde = Solde-somme;
		         System.out.println("Voici votre argent !");
	          }
	}
	
	public void Consulte()
	{
		super.Consulte();
		System.out.println();
		System.out.println("Le d�couvert autoris� est de  "+ Decouvert_Autorise+" �");
	}
	
}

package Compte;

public class Compte_Epargne extends Compte
{
//  D�claration des attributs
	private double  Taux;
	
// D�claration du constructeur
	public Compte_Epargne()
	{
	super ();
	Taux = Saisie.lire_double("Quel est le taux");
	}
	
	// Autres m�thodes
	public void Consulte()
	{
		super.Consulte();
		System.out.println();
		System.out.println("Le taux de r�mun�ration est de  "+ Taux+" %");
	}
	
	public void mise_a_jour()
	{
		Taux = Taux *1.2;
		System.out.println("Le nouveau taux vaut "+ Taux);
	}

}

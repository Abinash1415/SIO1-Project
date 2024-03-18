package Point;

import Collection.CollectionPoint;
import TP_POO.Saisie;

public class UtilisePoint
{
	public static void main(String Args[])
	{
		int n;
		n = Saisie.lire_int("Combiens de points voulez vous manipuler?");
		
		CollectionPoint Coll = new CollectionPoint();
		
		Coll.ajouteobjet(n);
		Coll.affichtoutbis();
		Coll.affichtout();
		Coll.TestVide();
		Coll.SupprimePoint();
		Coll.affichtout();
		Coll.affichpositif();
		Coll.ModifCoordo();
		Coll.affichtout();
		Coll.AjouteUnPoint();
		Coll.affichtout();
		Coll.ComptePoints();
		Coll.VideCollection();
		Coll.affichtout();
	}
} 

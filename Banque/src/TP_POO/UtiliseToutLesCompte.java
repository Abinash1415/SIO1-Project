package TP_POO;

import Compte.Compte;
import Compte.Compte_Courant;
import Compte.Compte_Epargne;

public class UtiliseToutLesCompte {

    public static void main(String[] args)
    {
    	Compte C1 = new Compte();
    	C1.Consulte();
    	C1.Deposer(100);
    	C1.Consulte();
    		
    	Compte C2 = new Compte();	
    	C2.Consulte();	
    	C2.Retirer(200);
    	C2.Consulte();
    		
    	Compte_Epargne C3 = new Compte_Epargne();
    	C3.Consulte();
    	C3.Deposer(500);
    	C3.Consulte();
    	C3.mise_a_jour();
    	C3.Consulte();
    		
    	Compte_Courant C4 = new Compte_Courant();
    	C4.Consulte();
    	C4.Retirer(200.0d);
    	C4.Consulte();
    	C4.Retirer(300.0d);
    	C4.Consulte();
    	C4.Deposer(400.0d);
    	C4.Consulte();
    		
    }
}

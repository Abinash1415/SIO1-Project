package TP_POO;

import Compte.Compte;

public class UtiliseCompte {

		public static void main(String[] args) 
		{
			Compte Dupont;
			Dupont = new Compte ("Dupont",1234,450);
			Dupont.AfficheSolde();
			Dupont.Deposer(500);
			Dupont.AfficheSolde();
			Dupont.Retirer(120);
			Dupont.AfficheSolde();
			
			Compte CptMartin;
			CptMartin = new Compte ("Martin",4567,150);
			CptMartin.AfficheSolde();
			CptMartin.Deposer(500);
			CptMartin.AfficheSolde();
			CptMartin.Retirer(1000);
			CptMartin.AfficheSolde();
			
			Dupont.AfficheSolde();
			 // Compte Durand
			Compte CptDurand = new Compte ("Durand", 70017, 1500, -200);
			CptDurand.AfficheSolde();
			CptDurand.Deposer(500);
			CptDurand.AfficheSolde();
			CptDurand.Retirer(120);
			CptDurand.AfficheSolde();
			
			 // Compte Durand
			Compte unCompte= new Compte ("Malherd", 586, 100, -150);
			unCompte.AfficheSolde();
			unCompte.Retirer(200);
			unCompte.AfficheSolde();
			unCompte.Retirer(300);
			unCompte.AfficheSolde();
			
			
		}


}

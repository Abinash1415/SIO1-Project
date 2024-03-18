package DevoirMaison;

import java.lang.Math;

public class Dé {

	public static void main(String[] args) {
		String Nom1, Nom2 ;
		int score1, score2, jet, départ ;
		
		score1 = 0 ;
		score2 = 0 ;
		Nom1 = Saisie.lire_String("Quel est votre nom ?") ;
		Nom2 = Saisie.lire_String("Quel est votre nom ?") ;

		System.out.println("Nous allons maintenant proc�der au tirage au sort pour savoir qui commence !") ;
		départ = (int) (Math.random() * 2 + 1);
		
		if (départ == 1) {
			System.out.println("C'est " + Nom1 + " qui commence") ;
		} 
		else
			
		{
			System.out.println("C'est " + Nom2 + " qui commence") ;
		
		
		System.out.println("Commencez !") ;
		
		jet = (int) (Math.random() * 6 + 1);
		score2 = jet + score2 ;
		System.out.println("Joueur " + Nom2 + " votre score est de " + score2) ;
		
		while (jet == 6) {
			System.out.println("Joueur 2, vous devez recommencer !") ;
			jet = (int) (Math.random() * 6 + 1);
			score2 = jet + score2 ;
			System.out.println("Joueur " + Nom2 + " votre score est de " + score2 ) ;
		}
		
		
		}
		
		do 
		{
			System.out.println("C'est au tour de joueur 1 !") ;
			System.out.println("Jouez !") ;
			jet = (int) (Math.random() * 6 + 1);
			score1 = jet + score1 ;
			System.out.println("Joueur " + Nom1 + " votre score est de " + score1) ;
			
			while (jet == 6) 
			{
				System.out.println("Joueur 2, vous devez recommencer !") ;
				jet = (int) (Math.random() * 6 + 1);
				score1 = jet + score1 ;
				System.out.println("Joueur " + Nom1 + " votre score est de " + score1 ) ;
			}
			if (score1 <= 30) {
				System.out.println("C'est au tour de joueur 2 !") ;
				System.out.println("Jouez !") ;
				jet = (int) (Math.random() * 6 + 1);
				score2 = jet + score2 ;
				System.out.println("Joueur " + Nom2 + " votre score est de " + score2 ) ;
				
				while (jet == 6)
					{
					System.out.println("Joueur 2, vous devez recommencer !") ;
					jet = (int) (Math.random() * 6 + 1);
					score2 = jet + score2 ;
					System.out.println("Joueur " + Nom2 + " votre score est de " + score2 ) ;
					}
			}
		}
		while ((score1 <= 30) && (score2 <= 30)) ;
			
		if (score1 >= 30) 
		{
			System.out.println("Joueur " + Nom1 + " vous avez gagné avec un score de " + score1) ;
		}
		else 
		{
			System.out.println("Joueur " + Nom2 + " vous avez gagné avec un score de " + score2) ;
		}

	
		
	}
}
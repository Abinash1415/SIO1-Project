package Devoir_à4;

public class Calculatrice 
{

	public static void main(String[] args)
	{
	String Op;
	int Nb, Res;
	
	Op = "";
	
	while (Op.equals("F")==false)  {
	  Res=Saisie.lire_int("Quel est le premier nombre ?");
	  Op=Saisie.lire_String("Quel est votre opérateur ?");
	  while ((Op.equals("F")==false) && (Op.equals("C")==false)){
		  Nb=Saisie.lire_int("Quel est votre deuxième nombre ?");
		  
		  if (Op.equals("+")) Res += Nb;
		  else if (Op.equals("-")) Res -= Nb;
		  		else if (Op.equals("*")) Res *= Nb;
		  
		  System.out.println("Votre résultat est "+Res); 
		  
		  Op=Saisie.lire_String("Quel est l'opérateur suivant ?");
		  
		  
		  
	  }
	  }
	
	System.out.println("Fin des calculs");
	}
		
		
	}



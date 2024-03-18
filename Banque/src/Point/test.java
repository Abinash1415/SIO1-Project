package Point;

import java.util.*;
import java.util.ArrayList.*;
import java.io.*;

public class test {

	public static void main(String[] args) {
		
		ArrayList al = new ArrayList();
		al.add(12);
		al.add("Une cha�ne de caract�re !");
		al.add(12.20f);
		al.add('d');
		
		for(int i = 0; i < al.size(); i++)
		{
			System.out.println("donn�e � l'indice " + i + " = " + al.get(i));
		}
	}

}

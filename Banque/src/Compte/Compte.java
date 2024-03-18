package Compte;

import java.io.*;

public class Compte {
    public static final int NumCompte = 0;

    // Liste des attributs
    public String Titulaire;
    public int Num;
    public double Solde;
    public double Decouvert;

    // Déclaration du constructeur
    public Compte(String Nom, int Numéro, double SoldeSaisi, double DecouvertSaisi) {
        Titulaire = Nom;
        Num = Numéro;
        Solde = SoldeSaisi;
        Decouvert = DecouvertSaisi;
    }

    public Compte(String Nom, int Numéro, double SoldeSaisi) {
        Titulaire = Nom;
        Num = Numéro;
        Solde = SoldeSaisi;
    }
    public Compte() {
        Titulaire = Saisie.lire_String("Quel est le nom du titulaire ?");
        Num = Saisie.lire_int("Quel est le numéro du compte ?");
        Solde = Saisie.lire_double("Quel est le solde de ce compte ?");
    }

    // Déclaration des méthodes
    public void AfficheSolde() {
        System.out.println("Le solde du compte dont le " + Num + " est de " + Solde + "€");
    }

    public void Retirer(double somme) {
        if ((Solde - somme) < Decouvert) {
            System.out.println("Opération échouée");
        } else {
            Solde = Solde - somme;
            System.out.println("Voici votre argent !");
        }
    }

    public void Deposer(double somme) {
        Solde = Solde + somme;
    }

    public double getSolde() {
        return Solde;
    }

    public double getDecouvert() {
        return Decouvert;
    }

    public String getTitulaire() {
        return Titulaire;
    }

    public int getNum() {
        return Num;
    }

    public void afficheTout() {
        System.out.println("Titulaire : " + Titulaire);
        System.out.println("Numéro : " + Num);
        System.out.println("Solde : " + Solde);
        System.out.println("Découvert : " + Decouvert);
        System.out.println("");
    }

    public void Consulte() {
        System.out.println("Titulaire : " + Titulaire);
        System.out.println("Solde actuel : " + Solde);
        System.out.println();
    }

    public void setDecouvert(double nouveauDecouvert) {
        this.Decouvert = nouveauDecouvert;
    }
}

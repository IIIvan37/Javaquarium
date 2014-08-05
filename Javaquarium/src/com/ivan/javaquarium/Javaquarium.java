package com.ivan.javaquarium;

import java.io.IOException;

public class Javaquarium {

	public static void main(String[] args) {

		Aquarium aquarium = new Aquarium();

		aquarium.ajouterPoisson(UsinePoisson.creerThon("T1", Sexe.M));
		aquarium.ajouterPoisson(UsinePoisson.creerCarpe("C1", Sexe.F));
		aquarium.ajouterPoisson(UsinePoisson.creerBar("B1", Sexe.F));
		aquarium.ajouterPoisson(UsinePoisson.creerMerou("M1", Sexe.M));
		aquarium.ajouterPoisson(UsinePoisson.creerPoissonClown("E1", Sexe.M));
		aquarium.ajouterPoisson(UsinePoisson.creerSole("S1", Sexe.M));
		aquarium.ajouterPoisson(UsinePoisson.creerThon("T2", Sexe.F));
		aquarium.ajouterPoisson(UsinePoisson.creerCarpe("C2", Sexe.M));
		aquarium.ajouterPoisson(UsinePoisson.creerBar("B2", Sexe.M));
		aquarium.ajouterPoisson(UsinePoisson.creerMerou("M2", Sexe.F));
		aquarium.ajouterPoisson(UsinePoisson.creerPoissonClown("P2", Sexe.M));
		aquarium.ajouterPoisson(UsinePoisson.creerSole("S2", Sexe.M));
		aquarium.ajouterAlgue(new Algue());
		aquarium.ajouterAlgue(new Algue());
		
		aquarium.afficher();
		int tour = 1;
		while (!aquarium.estVide()) {
			System.out.println("===================================");
			System.out.println("tour N° " + tour++);
			System.out.println("===================================");
			
			aquarium.evoluer();
			System.out.println("\ninfos");
			System.out.println("-----------------------------------");
			aquarium.afficher();
			try {
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}

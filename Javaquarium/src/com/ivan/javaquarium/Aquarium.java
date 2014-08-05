package com.ivan.javaquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

	public Aquarium() {
		mAlgues = new ArrayList<>();
		mPoissons = new ArrayList<>();
	}

	public void ajouterAlgue(Algue algue) {
		mAlgues.add(algue);
		System.out.println("Ajout d'une algue.");
	}

	public void ajouterPoisson(Poisson poisson) {
		mPoissons.add(poisson);
		System.out.println("Ajout d'" + poisson.description());
	}

	public boolean estVide() {
		return mAlgues.isEmpty() && mPoissons.isEmpty();
	}

	public void evoluer() {
		mAlgues.addAll(evoluer(mAlgues));
		mPoissons.addAll(evoluer(mPoissons));
		retirerMorts(mAlgues);
		retirerMorts(mPoissons);
	}

	public List<EtreVivant> getAlgues() {
		return mAlgues;
	}

	public List<EtreVivant> getPoissons() {
		return mPoissons;
	}

	public void afficher() {
		afficher(mAlgues);
		afficher(mPoissons);
	}
	
	private void afficher(List<EtreVivant> etresVivants){
		for (EtreVivant e : etresVivants) {
			System.out.println(e.description());
		}
	}
	
	private void retirerMorts(List<EtreVivant> etresVivants) {
		List<EtreVivant> nouveauxEtresVivants = new ArrayList<>();
		for (EtreVivant e : etresVivants) {
			if (e.estVivant()) {
				nouveauxEtresVivants.add(e);
			} else {
				System.out.println(String.format("%s est mort(e).", e.toString()));
			}
		}
		etresVivants = nouveauxEtresVivants;
	}

	private List<EtreVivant> evoluer(List<EtreVivant> etresVivants) {

		List<EtreVivant> nouveaux = new ArrayList<>();
		for (EtreVivant e : etresVivants) {
			EtreVivant nouveauEtreVivant = e.evoluer(this);
			if (nouveauEtreVivant != null) {
				nouveaux.add(nouveauEtreVivant);
				System.out.println(String.format("%s vient de naitre !",
						nouveauEtreVivant.toString()));
			}
		}
	
		return nouveaux;
	}

	private List<EtreVivant> mAlgues;
	private List<EtreVivant> mPoissons;
}

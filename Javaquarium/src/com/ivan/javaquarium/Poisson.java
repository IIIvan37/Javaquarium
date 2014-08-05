package com.ivan.javaquarium;

import java.util.List;
import java.util.Random;

enum Sexe {

	M("mâle"), F("femelle");

	Sexe(String description) {
		mDescription = description;
	}

	@Override
	public String toString() {
		return mDescription;
	}

	private String mDescription;
}

public class Poisson extends EtreVivant {

	static final int DEGATS_SUBIS = 4;
	static final int GAIN_PV = 5;
	static final int FAIM = 5;
	
	Poisson(String nom, Race id, Sexe sexe) {
		this(nom, id, sexe, 0);

	}

	Poisson(String nom, Race id, Sexe sexe, int age) {
		super(id, EtreVivant.NOMBRE_PV_DEPART, age, DEGATS_SUBIS, GAIN_PV);

		mNom = nom;
		mSexe = sexe;
	}

	@Override
	public EtreVivant evoluer(Aquarium aquarium) {

		super.evoluer(aquarium);
		diminuerPV(1);
		if (estVivant()) {
			if (aFaim()) {
				mComportementAlimentaire.manger(this, aquarium);
			} else {
				Poisson autrePoisson = chercherReproducteur(aquarium
						.getPoissons());
				mComportementReproducteur.adapter(this, autrePoisson);
				if (autrePoisson != null) {
					return reproduire(autrePoisson);
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return mNom;
	}

	public String description() {
		return String.format("%s %s nommé %s%s.", getRace().toString(),
				getSexe().toString(), toString(), super.description());
	}

	public void setHerbivore() {
		mComportementAlimentaire = new Herbivore();
	}

	public void setCarnivore() {
		mComportementAlimentaire = new Carnivore();
	}

	public void setMonoSexue() {
		mComportementReproducteur = new MonoSexue();
	}

	public void setHermaphroditeAge() {
		mComportementReproducteur = new HermaphroditeAge();
	}

	public void setHermaphroditeOpportuniste() {
		mComportementReproducteur = new HermaphroditeOpportuniste();
	}

	public void manger(EtreVivant etreVivant) {
		augmenterPV(etreVivant.seFaitManger());
	}

	public boolean aFaim() {
		return getPV() <= FAIM;
	}

	public Sexe getSexe() {
		return mSexe;
	}

	public void changeSexe() {
		if (mSexe.equals(Sexe.M)) {
			mSexe = Sexe.F;
		} else {
			mSexe = Sexe.M;
		}
	}

	private Poisson reproduire(Poisson autrePoisson) {

		if (getRace() == autrePoisson.getRace()
				&& (getSexe() != autrePoisson.getSexe())) {
			Random r = new Random();

			return UsinePoisson.creerPoisson(getRace(), toString()
					+ autrePoisson.toString(), r.nextInt(2) == 0 ? Sexe.M
					: Sexe.F);
		}
		return null;
	}

	private Poisson chercherReproducteur(List<EtreVivant> poissons) {

		Random r = new Random();
		int indexPoisson = r.nextInt(poissons.size());
		if (poissons.get(indexPoisson) != this
				&& poissons.get(indexPoisson).getRace() == getRace()
				&& ((Poisson) poissons.get(indexPoisson)).getSexe() != getSexe()) {
			return (Poisson) poissons.get(indexPoisson);
		}

		return null;
	}

	private String mNom;
	private Sexe mSexe;
	protected ComportementAlimentaire mComportementAlimentaire;
	protected ComportementReproducteur mComportementReproducteur;
}

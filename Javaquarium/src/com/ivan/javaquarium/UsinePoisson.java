package com.ivan.javaquarium;

public class UsinePoisson {

	static Poisson creerPoisson(Race id, String nom, Sexe sexe) {

		switch (id) {
		case BAR:
			return creerBar(nom, sexe);

		case CARPE:
			return creerCarpe(nom, sexe);

		case MEROU:
			return creerMerou(nom, sexe);

		case POISSON_CLOWN:
			return creerPoissonClown(nom, sexe);

		case SOLE:
			return creerSole(nom, sexe);

		case THON:
			return creerThon(nom, sexe);

		default:
			return null;
		}
	}

	static Poisson creerBar(String nom, Sexe sexe) {
		Poisson bar = new Poisson(nom, Race.BAR, sexe);
		bar.setHerbivore();
		bar.setHermaphroditeAge();

		return bar;
	}

	static Poisson creerCarpe(String nom, Sexe sexe) {
		Poisson carpe = new Poisson(nom, Race.CARPE, sexe);
		carpe.setHerbivore();
		carpe.setMonoSexue();

		return carpe;
	}

	static Poisson creerMerou(String nom, Sexe sexe) {
		Poisson Merou = new Poisson(nom, Race.MEROU, sexe);
		Merou.setCarnivore();
		Merou.setHermaphroditeAge();

		return Merou;
	}

	static Poisson creerPoissonClown(String nom, Sexe sexe) {
		Poisson poissonClown = new Poisson(nom,
				Race.POISSON_CLOWN, sexe);
		poissonClown.setCarnivore();
		poissonClown.setHermaphroditeOpportuniste();

		return poissonClown;
	}

	static Poisson creerSole(String nom, Sexe sexe) {
		Poisson sole = new Poisson(nom, Race.SOLE, sexe);
		sole.setHerbivore();
		sole.setHermaphroditeOpportuniste();

		return sole;
	}

	static Poisson creerThon(String nom, Sexe sexe) {
		Poisson thon = new Poisson(nom, Race.THON,
				sexe);
		thon.setCarnivore();
		thon.setHermaphroditeOpportuniste();

		return thon;
	}

	private UsinePoisson() {
	};
}

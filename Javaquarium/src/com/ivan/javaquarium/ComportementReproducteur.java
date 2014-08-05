package com.ivan.javaquarium;


public interface ComportementReproducteur {

	void adapter(Poisson p, Poisson autrePoisson);
}

class HermaphroditeAge implements ComportementReproducteur {

	@Override
	public void adapter(Poisson p, Poisson autrePoisson) {

		if (p.getAge() == 11) {
			p.changeSexe();
		}
	}

}

class HermaphroditeOpportuniste implements ComportementReproducteur {

	@Override
	public void adapter(Poisson p, Poisson autrePoisson) {
		if (autrePoisson != null 
				&& p.getRace() == autrePoisson.getRace()
				&& p.getSexe() == autrePoisson.getSexe()) {
			p.changeSexe();
		}
	}

}

class MonoSexue implements ComportementReproducteur {

	@Override
	public void adapter(Poisson p, Poisson autrePoisson) {

	}

}
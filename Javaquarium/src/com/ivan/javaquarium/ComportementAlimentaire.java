package com.ivan.javaquarium;

import java.util.List;
import java.util.Random;

public interface ComportementAlimentaire {

	void manger(Poisson p, Aquarium aquarium);
}

class Herbivore implements ComportementAlimentaire {

	@Override
	public void manger(Poisson poisson, Aquarium aquarium) {

		List<EtreVivant> alguesRestantes = aquarium.getAlgues();
		if (!alguesRestantes.isEmpty()) {
			Random r = new Random();
			int indexAlgue = r.nextInt(alguesRestantes.size());
			
			Algue algue = (Algue) alguesRestantes.get(indexAlgue);
			System.out.println(String.format("%s mange une algue",
					poisson.toString()));
			poisson.manger(algue);
		}
	}
}

class Carnivore implements ComportementAlimentaire {

	@Override
	public void manger(Poisson poisson, Aquarium aquarium) {
		List<EtreVivant> poissonsRestants = aquarium.getPoissons();
		if (poissonsRestants.size() > 1) {
			Random r = new Random();
			int indexPoisson = r.nextInt(poissonsRestants.size() - 1);
						
			if(poissonsRestants.get(indexPoisson) == poisson) {
				indexPoisson++;
			}
			
			Poisson autrePoisson = (Poisson) poissonsRestants.get(indexPoisson);
			System.out.println(String.format("%s mange %s", poisson.toString(),
					autrePoisson.toString()));
			poisson.manger(autrePoisson);
		}

	}

}
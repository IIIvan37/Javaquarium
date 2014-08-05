package com.ivan.javaquarium;

public class Algue extends EtreVivant {

	static final int PV_REPRODUCTION = 10;
	static final int DEGATS_SUBIS = 2;
	static final int GAIN_PV = 3;
	
	Algue() {
		this(EtreVivant.NOMBRE_PV_DEPART);
	}

	Algue(int pv){
		this(pv, 0);
	}
	
	Algue(int pv, int age){
		super(Race.ALGUE, pv, age, DEGATS_SUBIS, GAIN_PV);
	}
	
	public EtreVivant evoluer(Aquarium aquarium) {
		super.evoluer(aquarium);
		augmenterPV(1);
		return reproduire();
	}

	public Algue reproduire(){
		
		if(getPV() >= PV_REPRODUCTION){
			int pv = getPV() / 2;
			diminuerPV(pv);
			return new Algue(pv);
		}
		return null;
	}
	
		
	public String description() {
		return toString() + super.description();
	}
}

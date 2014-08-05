package com.ivan.javaquarium;

enum Race {

	ALGUE("une algue"), MEROU("un mérou"), THON("un thon"), POISSON_CLOWN(
			"un poisson clown"), SOLE("une sole"), BAR("un bar"), CARPE(
			"une carpe");

	Race(String raceDescription) {
		mRaceDescription = raceDescription;
	}

	@Override
	public String toString() {
		return mRaceDescription;
	}

	private String mRaceDescription;
}

public abstract class EtreVivant {

	static final int NOMBRE_PV_DEPART = 10;
	static final int AGE_MAXI = 20;
	
	public EtreVivant(Race id, int degats, int gain){
		this(id, NOMBRE_PV_DEPART, degats, gain);
	}

	public EtreVivant(Race id, int pv, int degats, int gain) {
		this(id, pv, 0, degats, gain);
	}

	public EtreVivant(Race id, int pv, int age, int degats, int gain) {
		mRace = id;
		mPV = pv;
		mAge = age;
		mDegatsSubis = degats;
		mGainPV = gain;
	}

	public EtreVivant evoluer(Aquarium aquarium) {
		if (estVivant()) {
			mAge++;
			if (mAge > AGE_MAXI) {
				mPV = 0;
			}
		}

		return null;
	}

	public Race getRace() {
		return mRace;
	}

	public boolean estVivant() {
		return getPV() > 0;
	}

	public int seFaitManger(){
		diminuerPV(mDegatsSubis);
		return mGainPV;
	}

	public int getPV() {
		return mPV;
	}

	public void augmenterPV(int augmentation) {
		mPV += augmentation;
	}

	public void diminuerPV(int diminution) {
		mPV = Math.max(0, mPV - diminution);
	}

	public int getAge() {
		return mAge;
	}

	@Override
	public String toString(){
		return mRace.toString();
	}
	
	public String description() {
		return String.format(" agé(e) de %d tours et avec %d PV.", getAge(),
				getPV());
	}

	private Race mRace;
	private int mPV;
	private int mAge;
	private int mDegatsSubis;
	private int mGainPV;
}

package com.michalbarczyk.evogenerator;

public class Plant extends Creature {

    private final int energeticValue = 5;

    public Plant(Vector initVector, WorldMap worldMap/*, int value*/) {
        super(initVector, worldMap);
        //this.energeticValue = value;
    }

    public int getEnergeticValue() {
        return energeticValue;
    }

    @Override
    public String toString() {
        return "P";
    }

}

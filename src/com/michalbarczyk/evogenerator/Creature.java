package com.michalbarczyk.evogenerator;

import java.util.ArrayList;
import java.util.List;

public abstract class Creature implements IWorldElement {

    protected Vector creatureVector;
    protected WorldMap worldMap;
    private List<IVectorChangeObserver> observers;

    public Creature(Vector initVector, WorldMap worldMap) {
        this.creatureVector = initVector;
        this.worldMap = worldMap;
        this.observers = new ArrayList<>();
    }

    public Vector getVector() {
        return this.creatureVector;
    }

    public void addObserver(IVectorChangeObserver observer) {

        observers.add(observer);
    }

    public void removeObserver(IVectorChangeObserver observer) {

        observers.remove(observer);
    }

    public void vectorChanged(Vector oldVector, Vector newVector) {

        for (IVectorChangeObserver observer : observers) {

            observer.vectorChanged(oldVector, newVector);
        }
    }

}

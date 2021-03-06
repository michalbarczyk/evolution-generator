package com.michalbarczyk.evogenerator;

import java.util.Map;

public class Animal extends Creature {

    private int animalEnergy;
    private int toReproduction;
    private WorldDirection animalDirection;
    private Genom animalGenom;
    public static final int ONCREATIONENERGY = 25;
    public static final int REPRODUCTIONENERGY = 16;
    public static final WorldDirection DEFAULTWORLDDIRECTION = WorldDirection.NORTH;
    public static final int REPRODUCTIONPERIOD = 12;
    private Animal child;


    public Animal(Vector initVector, WorldMap worldMap, WorldDirection initDirection, int energy, Genom initGenom, int toReproduction) {
        super(initVector, worldMap);
        this.animalEnergy = energy;
        this.animalDirection = initDirection;
        this.animalGenom = initGenom;
        this.toReproduction = toReproduction;
        this.child = null;
    }

    public int getAnimalEnergy() {
        return animalEnergy;
    }

    private void move(MoveDirection direction) {

        switch (direction) {

            case FORWARDLEFT:
                animalDirection = animalDirection.prev(1);
                break;
            case LEFT:
                animalDirection = animalDirection.prev(2);
                break;
            case BACKWARDLEFT:
                animalDirection = animalDirection.prev(3);
                break;
            case FORWARDRIGHT:
                animalDirection = animalDirection.next(1);
                break;
            case RIGHT:
                animalDirection = animalDirection.next(2);
                break;
            case BACKWARDRIGHT:
                animalDirection = animalDirection.next(3);
                break;
            case BACKWARD:
                animalDirection = animalDirection.next(4);
                break;
            case FORWARD:
                animalDirection = animalDirection.next(0);
                break;
        }

        Vector oldVector = creatureVector;
        Vector candidateVector = worldMap.getVectorInFrontOfMe(animalDirection, creatureVector);
        if (!worldMap.isOccupied(candidateVector)) {
            creatureVector = candidateVector;
            vectorChanged(oldVector, creatureVector);
        }
    }

    public void tryToMoveByGenom() {
        DistributedRandomValuesGenerator<MoveDirection> directionGenerator = new DistributedRandomValuesGenerator<>();
        for (Map.Entry<MoveDirection, Double> gene : animalGenom.getGenes()) {
            directionGenerator.add(gene.getKey(), gene.getValue());
        }

        move(directionGenerator.getDistributedRandom());
    }

    public void tryToEat() {
        if (this.worldMap.isPlanted(this.getVector())) {
            this.animalEnergy += this.worldMap.removePlantFrom(this.getVector()).getEnergeticValue();
        }
    }

    public void tryToReproduct() {
        if (toReproduction <= 0 && animalEnergy >= REPRODUCTIONENERGY) {
            Vector childVector = worldMap.getFreeVectorNextTo(getVector());

            if (childVector != null) {
                int childEnergy = this.animalEnergy / 2;
                this.child = (new Animal(childVector, worldMap, DEFAULTWORLDDIRECTION, childEnergy, animalGenom.getChildGenom(), REPRODUCTIONPERIOD));
                this.animalEnergy -= childEnergy;
                this.toReproduction = REPRODUCTIONPERIOD;
            }

        }

    }

    public Genom getAnimalGenom() {
        return this.animalGenom;
    }

    public WorldDirection getAnimalDirection() {
        return animalDirection;
    }

    public Animal getChild() {
        return this.child;
    }

    public void reduceChild() {
        this.child = null;
    }

    public void refreshDay() {
        this.animalEnergy--;
        this.toReproduction--;
    }

    @Override
    public String toString() {

        switch (this.animalDirection) {

            case NORTH:
                return "/\\";
            case NORTHEAST:
                return "^>";
            case EAST:
                return "->";
            case SOUTHEAST:
                return "v>";
            case SOUTH:
                return "\\/";
            case SOUTHWEST:
                return "<v";
            case WEST:
                return "<-";
            case NORTHWEST:
                return "<^";
        }

        return null;
    }

}

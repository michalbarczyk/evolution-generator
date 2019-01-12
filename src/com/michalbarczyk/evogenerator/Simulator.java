package com.michalbarczyk.evogenerator;

import java.util.ArrayList;
import java.util.List;

public class Simulator {

    private WorldMap worldMap;
    private int duration;
    private int plantRefresh;

    public Simulator(WorldMap worldMap, int duration, int plantRefresh) {
        this.worldMap = worldMap;
        this.duration = duration;
        this.plantRefresh = plantRefresh;
    }

    public void startSimulation() {

        for (int i = 0; i < duration; i++) {
            removeDeadAnimals();
            moveAllAnimals();
            feedAllAnimals();
            reproductAllAnimals();
            refreshAllAnimals();
            WorldMapBuilder.generatePlants(this.worldMap, plantRefresh);
            collectChildren();
        }

    }

    private void removeDeadAnimals() {

        List<Animal> toBeRemoved  = new ArrayList<>();

        for (Animal animal : worldMap.getAnimalsList()) {
            if (animal.getAnimalEnergy() == 0)
                toBeRemoved.add(animal);
        }

        for(Animal animal : toBeRemoved) {
            worldMap.removeAnimalFrom(animal);
        }
    }

    private void moveAllAnimals() {
        for (Animal animal : worldMap.getAnimalsList()) {
            animal.tryToMoveByGenom();
        }
    }

    private void feedAllAnimals() {
        for (Animal animal : worldMap.getAnimalsList()) {
            animal.tryToEat();
        }
    }

    private void reproductAllAnimals() {
        for (Animal animal : worldMap.getAnimalsList()) {
            animal.tryToReproduct();
        }
    }

    private void refreshAllAnimals() {
        for (Animal animal : worldMap.getAnimalsList()) {
            animal.refreshDay();
        }
    }

    private void collectChildren() {

        List<Animal> children = new ArrayList<>();

        for (Animal animal : worldMap.getAnimalsList()) {
            if (animal.getChild() != null) {
                children.add(animal.getChild());
                animal.reduceChild();
            }

        }

        for (Animal child : children) {
            worldMap.addAnimal(child);
        }
    }




    
}

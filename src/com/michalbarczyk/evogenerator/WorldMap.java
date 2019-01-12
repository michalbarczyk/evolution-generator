package com.michalbarczyk.evogenerator;

import java.util.*;

public class WorldMap implements IVectorChangeObserver {

    private Map<Vector, Animal> animals;
    private List<Animal> animalsList;
    private Map<Vector, Plant> plants;
    private int height;
    private int length;
    private Vector jungleLeftDown;
    private Vector jungleRightUp;
    private double jungleDensity;

    public WorldMap(int length, int height, Vector jungleLeftDown, Vector jungleRightUp, double jungleDensity) {
        this.animals = new HashMap<>();
        this.animalsList = new ArrayList<>();
        this.plants = new HashMap<>();
        this.height = height;
        this.length = length;
        this.jungleLeftDown = jungleLeftDown;
        this.jungleRightUp = jungleRightUp;
        this.jungleDensity = jungleDensity;
    }

    public Vector getVectorInFrontOfMe(WorldDirection myDirection, Vector myVector) {
        Vector versor = null;

        switch (myDirection) {

            case NORTH:
                versor = new Vector(0,1);
                break;
            case NORTHEAST:
                versor = new Vector(1,1);
                break;
            case EAST:
                versor = new Vector(1,0);
                break;
            case SOUTHEAST:
                versor = new Vector(1,-1);
                break;
            case SOUTH:
                versor = new Vector(0,-1);
                break;
            case SOUTHWEST:
                versor = new Vector(-1,-1);
                break;
            case WEST:
                versor = new Vector(-1,0);
                break;
            case NORTHWEST:
                versor = new Vector(-1,1);
                break;
        }

        Vector preResult = myVector.add(versor);
        preResult = new Vector(preResult.x + this.getLength(), preResult.y + this.getHeight());

        return new Vector(preResult.x % length, preResult.y % height);
    }

    public Animal animalAt(Vector vector) {return animals.get(vector);}

    public Plant plantAt(Vector vector) {return plants.get(vector);}

    public void addAnimal(Animal animal) {
        if(!isOccupied(animal.creatureVector)) {
            animals.put(animal.creatureVector, animal);
            animalsList.add(animal);
            animal.addObserver(this);
        }

    }

    public void addPlant(Plant plant) {
        plants.put(plant.creatureVector, plant);
    }

    public Plant removePlantFrom(Vector vector) {
        return plants.remove(vector);
    }

    public Animal removeAnimalFrom(Animal animal) {
        animalsList.remove(animal);
        return animals.remove(animal.creatureVector);}

    public boolean isOccupied(Vector vector) {
        return animals.containsKey(vector);
    }

    public boolean isPlanted(Vector vector) { return  plants.containsKey(vector);}

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public double getJungleDensity() {
        return jungleDensity;
    }

    public List<Vector> getAllPossibleVectors() {
        List<Vector> vectors = new ArrayList<>();
        for (int x = 0; x < getLength(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                vectors.add(new Vector(x, y));
            }
        }
        return vectors;
    }

    public boolean inJungle(Vector vector) {
        return vector.x >= jungleLeftDown.x && vector.x <= jungleRightUp.x && vector.y >= jungleLeftDown.y && vector.y <= jungleRightUp.y;
    }

    public List<Animal> getAnimalsList() {
        return this.animalsList;
    }

    @Override
    public void vectorChanged(Vector oldVector, Vector newVector) {
        Animal animal = animals.remove(oldVector);
        animals.put(newVector, animal);
    }

    public Vector getFreeVectorNextTo(Vector vector) {

        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                Vector candidateVector = vector.add(new Vector(x, y));
                candidateVector = new Vector(candidateVector.x % length, candidateVector.y % height);
                if (!isOccupied(candidateVector))
                    return candidateVector;
            }
        }

        return null;
    }
}

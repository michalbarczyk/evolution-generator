package com.michalbarczyk.evogenerator;

public class WorldMapBuilder  {

    public static WorldMap build(int length, int height, int worldJungleRatio, int initAimalsQty, int initPlantsQty, double jungleDensity, Genom initGenom) {
        int jungleLength = length / worldJungleRatio;
        int jungleHeight = height / worldJungleRatio;
        Vector jungleLeftDown = new Vector((length - jungleLength) / 2, (height - jungleHeight) / 2 );
        Vector jungleUpRight = new Vector(((length - jungleLength) / 2) + jungleLength, ((height - jungleHeight) / 2) + jungleHeight);
        WorldMap worldMap = new WorldMap(length, height, jungleLeftDown, jungleUpRight, jungleDensity);
        generatePlants(worldMap, initPlantsQty);
        generateAnimals(worldMap, initAimalsQty, initGenom);

        return worldMap;
    }

    public static void generatePlants(WorldMap worldMap, int plantsQty) {
        DistributedRandomValuesGenerator<Vector> plantGenerator = new DistributedRandomValuesGenerator<>();

        for (Vector vector : worldMap.getAllPossibleVectors()) {
            if (worldMap.inJungle(vector))
                plantGenerator.add(vector, 0.1d * worldMap.getJungleDensity());
            else
                plantGenerator.add(vector, 0.1d);
        }

        for (int i = 0; i < plantsQty; i++) {
            Vector vector = plantGenerator.getDistributedRandom();
            if (!worldMap.isPlanted(vector))
                worldMap.addPlant(new Plant(vector, worldMap));
        }
    }

    public static void generateAnimals(WorldMap worldMap, int animalsQty, Genom initGenom) {
        DistributedRandomValuesGenerator<Vector> animalGenerator = new DistributedRandomValuesGenerator<>();

        for (Vector vector : worldMap.getAllPossibleVectors()) {
            animalGenerator.add(vector, 0.1d);
        }

        for (int i = 0; i < animalsQty; i++) {
            Vector vector = animalGenerator.getDistributedRandom();
            if (worldMap.isOccupied(vector))
                i--;
            else
                worldMap.addAnimal(new Animal(vector, worldMap, Animal.DEFAULTWORLDDIRECTION, Animal.ONCREATIONENERGY, initGenom, Animal.REPRODUCTIONPERIOD));
        }
    }
}

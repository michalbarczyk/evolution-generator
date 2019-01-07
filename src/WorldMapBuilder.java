public class WorldMapBuilder {

    public static WorldMap build(int length, int height, int worldJungleRatio, int initAimalsNo, int initPlantsNo, double jungleDensity) {
        int jungleLength = length / worldJungleRatio;
        int jungleHeight = height / worldJungleRatio;
        Vector jungleLeftDown = new Vector((length - jungleLength) / 2, (height - jungleHeight) / 2 );
        Vector jungleUpRight = new Vector(((length - jungleLength) / 2) + jungleLength, ((height - jungleHeight) / 2) + jungleHeight);
        WorldMap worldMap = new WorldMap(length, height, jungleLeftDown, jungleUpRight, jungleDensity);
        generatePlants(worldMap, initPlantsNo);

        return worldMap;
    }

    public static void generatePlants(WorldMap worldMap, int plantsNo) {
        DistributedRandomValuesGenerator<Vector> plantGenerator = new DistributedRandomValuesGenerator<>();

        for (Vector vector : worldMap.getAllPossibleVectors()) {
            if (worldMap.inJungle(vector))
                plantGenerator.add(vector, 0.1d * worldMap.getJungleDensity());
            else
                plantGenerator.add(vector, 0.1d);
        }

        for (int i = 0; i < plantsNo; i++) {
            Vector vector = plantGenerator.getDistributedRandom();
            if (worldMap.isPlanted(vector))
                i--;
            else
                worldMap.addPlant(new Plant(vector, worldMap));
        }
    }
}

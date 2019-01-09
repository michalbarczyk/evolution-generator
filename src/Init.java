public class Init {

    public static void main(String[] args) {

        Genom genom = new Genom();
        /*genom.getMap().put(MoveDirection.BACKWARD, 10);
        genom.getMap().put(MoveDirection.BACKWARDLEFT, 10);
        genom.getMap().put(MoveDirection.BACKWARDRIGHT, 10);
        genom.getMap().put(MoveDirection.LEFT, 10);
        genom.getMap().put(MoveDirection.RIGHT, 10);
        genom.getMap().put(MoveDirection.FORWARD, 10);
        genom.getMap().put(MoveDirection.FORWARDLEFT, 10);
        genom.getMap().put(MoveDirection.FORWARDRIGHT, 10);

        Map<MoveDirection, Integer> test = new HashMap<>();

        test.put(MoveDirection.BACKWARD, 0);
        test.put(MoveDirection.BACKWARDLEFT, 0);
        test.put(MoveDirection.BACKWARDRIGHT, 0);
        test.put(MoveDirection.LEFT, 0);
        test.put(MoveDirection.RIGHT, 0);
        test.put(MoveDirection.FORWARD, 0);
        test.put(MoveDirection.FORWARDLEFT, 0);
        test.put(MoveDirection.FORWARDRIGHT, 0);

        for (Map.Entry<MoveDirection, Integer> entry : test.entrySet()) {

            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }*/



        WorldMap worldMap = WorldMapBuilder.build(25,25,4,600, 25, 165.0);

        /*DistributedRandomValuesGenerator<Vector> plantGenerator = new DistributedRandomValuesGenerator<>();

        for (Vector vector : worldMap.getAllPossibleVectors()) {
            if (worldMap.inJungle(vector))
                plantGenerator.add(vector, 0.1d * worldMap.getJungleDensity());
            else
                plantGenerator.add(vector, 0.1d);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(plantGenerator.getDistributedRandom());
        }*/

        //Animal animal = new Animal(new Vector(3,3), map, WorldDirection.NORTH, 5, genom, 59);
        //Animal animal2 = new Animal(new Vector(3,5), map, WorldDirection.NORTH, 5, genom, 59);
        //map.addAnimal(animal);
        //map.addAnimal(animal2);

        MapVisualizer mapVisualizer = new MapVisualizer(worldMap);
        System.out.print(mapVisualizer.drawPlants(new Vector(0,0), new Vector(24,24)));
        //for(int i = 0; i < 10; i++) {
           // animal.move(MoveDirection.FORWARD);
           // System.out.print(mapVisualizer.drawPlants(new Vector(0,0), new Vector(19,19)));
        //}

    }
}

public class Init {

    public static void main(String[] args) {


        Genom initGenom = GenomBuilder.buildImpartialGenom();
        WorldMap worldMap = WorldMapBuilder.build(25, 25, 10, 100, 20, 100.0, initGenom);
        Simulator simulator = new Simulator(worldMap, 150000, 13);

        simulator.startSimulation();

        for (Animal animal : worldMap.getAnimalsList()) {
            System.out.println(worldMap.getAnimalsList().indexOf(animal) + ": " + animal.creatureVector + " energy = " + animal.getAnimalEnergy());
            System.out.print(animal.getAnimalGenom() + "\n");

        }

    }
}

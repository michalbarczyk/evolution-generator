public class Area {

    private Vector areaVector;
    private IWorldMap iWorldMap;
    private Plant plant;
    private Pair<Animal, Animal> pair;

    public Area(Vector areaVector, IWorldMap iWorldMap) {
        this.areaVector = areaVector;
        this.iWorldMap = iWorldMap;
        this.plant = null;
        this.pair = new Pair<>(null, null);
    }

    public Vector getAreaVector() {
        return this.areaVector;
    }

    public IWorldMap getIWorldMap() {
        return iWorldMap;
    }

    public void addPlant(Plant plant) {
        if(!isPlant())
            this.plant = plant;
    }
    public void addAnimal(Animal animal) {
        if (!isFirstOccupied())
            pair.setFirst(animal);
        else if (!isSecondOccupied())
            pair.setSecond(animal);
        else
            throw new IllegalArgumentException(toString() + " - there are 2 animals here");
    }

    private boolean isFirstOccupied() {
        return pair.getFirst() != null;
    }

    private boolean isSecondOccupied() {
        return pair.getSecond() != null;
    }

    private boolean isPlant() {
        return this.plant != null;
    }
    @Override
    public String toString() {
        return ":]";
    }
}

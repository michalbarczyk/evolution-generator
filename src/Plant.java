public class Plant extends Creature {

    int energeticValue;

    public Plant(Vector initVector, WorldMap worldMap, int value) {
        super(initVector, worldMap);
        this.energeticValue = value;
    }

    @Override
    public String toString() {
        return "P";
    }

}

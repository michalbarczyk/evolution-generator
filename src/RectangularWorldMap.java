import java.util.HashMap;
import java.util.Map;

public class RectangularWorldMap implements IVectorChangeObserver, IWorldMap {

    private Map<Vector, IWorldElement> worldMap;
    private int height;
    private int length;

    public RectangularWorldMap(int length, int height) {
        this.worldMap = new HashMap<>();
        this.height = height;
        this.length = length;
    }

    @Override
    public void positionChanged(Vector oldVector, Vector newVector) {

        IWorldElement element = worldMap.remove(oldVector);
        worldMap.put(newVector, element);
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

        return new Vector(preResult.x % length, preResult.y % height);
    }

    @Override
    public Object objectAt(Vector vector) {
        return this.worldMap.get(vector);
    }

    @Override
    public boolean isOccupied(Vector vector) {
        return this.worldMap.containsKey(vector);
    }

    public void add(Creature creature) {

        if (!isOccupied(creature.getCreatureVector())) {
            this.worldMap.put(creature.getCreatureVector(), creature);
            creature.addObserver(this);
        }
        else
            throw new IllegalArgumentException(creature.getCreatureVector().toString() + " is already occupied");
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }
}

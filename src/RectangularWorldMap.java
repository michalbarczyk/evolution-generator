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
            case NORTHEAST:
                versor = new Vector(1,1);
            case EAST:
                versor = new Vector(1,0);
            case SOUTHEAST:
                versor = new Vector(1,-1);
            case SOUTH:
                versor = new Vector(0,-1);
            case SOUTHWEST:
                versor = new Vector(-1,-1);
            case WEST:
                versor = new Vector(-1,0);
            case NORTHWEST:
                versor = new Vector(-1,1);
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

    @Override
    public void add(Vector vector, IWorldElement iWorldElement) {

        if (!isOccupied(vector))
            this.worldMap.put(vector, iWorldElement);
        else
            throw new IllegalArgumentException(vector.toString() + " is already occupied");
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }
}

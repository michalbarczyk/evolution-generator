import java.util.HashMap;
import java.util.Map;

public class RectangularWorldMap implements IWorldMap {

    private Map<Vector, Area> worldMap;
    private int height;
    private int length;

    public RectangularWorldMap(int length, int height) {
        this.worldMap = new HashMap<>();
        this.height = height;
        this.length = length;

        for (int x = 0; x < length; x++) {
            for (int y = 0; y < height; y++) {
                Area area = new Area(new Vector(x, y), this);
                worldMap.put(area.getAreaVector(), area);
            }
        }
    }

    public Area getAreaInFrontOfMe(WorldDirection myDirection, Area myArea) {
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

        Vector preResult = myArea.getAreaVector().add(versor);
        Vector result = new Vector(preResult.x % length, preResult.y % height);

        return worldMap.get(result);
    }

    public boolean isOccupied(Vector vector){
        return worldMap.containsKey(vector);
    }

    @Override
    public Object objectAt(Vector vector) {
        return this.worldMap.get(vector);
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }
}

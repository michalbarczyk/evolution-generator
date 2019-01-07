import java.util.HashMap;
import java.util.Map;

public class WorldMap implements IVectorChangeObserver {

    private Map<Vector, Animal> animals;
    private Map<Vector, Plant> plants;
    private int height;
    private int length;

    public WorldMap(int length, int height) {
        this.animals = new HashMap<>();
        this.plants = new HashMap<>();
        this.height = height;
        this.length = length;
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

    public Animal animalAt(Vector vector) {return animals.get(vector);}

    public void addAnimal(Animal animal) {
        if(!isOccupied(animal.creatureVector)) {
            animals.put(animal.creatureVector, animal);
            animal.addObserver(this);
        }
    }

    public boolean isOccupied(Vector vector) {
        return animals.containsKey(vector);
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void vectorChanged(Vector oldVector, Vector newVector) {
        Animal animal = animals.remove(oldVector);
        animals.put(newVector, animal);
    }
}

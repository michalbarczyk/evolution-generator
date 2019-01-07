import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldMap implements IVectorChangeObserver {

    private Map<Vector, Animal> animals;
    private Map<Vector, Plant> plants;
    private int height;
    private int length;
    private Vector jungleLeftDown;
    private Vector jungleRightUp;
    private double jungleDensity;

    public WorldMap(int length, int height, Vector jungleLeftDown, Vector jungleRightUp, double jungleDensity) {
        this.animals = new HashMap<>();
        this.plants = new HashMap<>();
        this.height = height;
        this.length = length;
        this.jungleLeftDown = jungleLeftDown;
        this.jungleRightUp = jungleRightUp;
        this.jungleDensity = jungleDensity;
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
        else throw new IllegalArgumentException(animal.creatureVector.toString() + " is already occupied by animal");
    }

    public void addPlant(Plant plant) {
        plants.put(plant.creatureVector, plant);
    }

    public boolean isOccupied(Vector vector) {
        return animals.containsKey(vector);
    }

    public boolean isPlanted(Vector vector) { return  plants.containsKey(vector);}

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public double getJungleDensity() {
        return jungleDensity;
    }

    public List<Vector> getAllPossibleVectors() {
        List<Vector> vectors = new ArrayList<>();
        for (int x = 0; x < getLength(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                vectors.add(new Vector(x, y));
            }
        }
        return vectors;
    }

    public boolean inJungle(Vector vector) {
        return vector.x >= jungleLeftDown.x && vector.x <= jungleRightUp.x && vector.y >= jungleLeftDown.y && vector.y <= jungleRightUp.y;
    }

    @Override
    public void vectorChanged(Vector oldVector, Vector newVector) {
        Animal animal = animals.remove(oldVector);
        animals.put(newVector, animal);
    }
}

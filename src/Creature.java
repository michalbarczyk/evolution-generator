import java.util.ArrayList;
import java.util.List;

public abstract class Creature implements IWorldElement {

    protected Vector creatureVector;
    protected IWorldMap iWorldMap;
    protected List<IVectorChangeObserver> vectorChangeObservers;

    public Creature(Vector initVector, IWorldMap iWorldMap) {
        this.creatureVector = initVector;
        this.iWorldMap = iWorldMap;
        this.vectorChangeObservers = new ArrayList<>();
    }


    @Override
    public Vector getCreatureVector() {
        return this.creatureVector;
    }

    public void addObserver(IVectorChangeObserver observer) {

        vectorChangeObservers.add(observer);
    }

    public void removeObserver(IVectorChangeObserver observer) {

        vectorChangeObservers.remove(observer);
    }

    public void positionChanged(Vector oldVector, Vector newVector) {

        for (IVectorChangeObserver observer : vectorChangeObservers) {

            observer.positionChanged(oldVector, newVector);
        }
    }
}

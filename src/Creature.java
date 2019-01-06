import java.util.ArrayList;
import java.util.List;

public abstract class Creature implements IWorldElement {

    private Vector vector;
    private IWorldMap iWorldMap;
    private List<IVectorChangeObserver> vectorChangeObservers;

    public Creature(Vector initVector, IWorldMap iWorldMap) {
        this.vector = initVector;
        this.iWorldMap = iWorldMap;
        this.vectorChangeObservers = new ArrayList<>();
    }


    @Override
    public Vector getVector() {
        return this.vector;
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

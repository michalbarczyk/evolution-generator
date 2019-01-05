public abstract class Creature implements WorldElement {

    private Vector vector;

    public Creature(Vector initVector) {
        this.vector = initVector;
    }

    @Override
    public Vector getVector() {
        return this.vector;
    }
}

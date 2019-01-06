public interface IWorldMap {

    Object objectAt(Vector vector);

    boolean isOccupied(Vector vector);

    void add(Vector vector, IWorldElement iWorldElement);
}

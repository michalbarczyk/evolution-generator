public interface IWorldMap {

    Object objectAt(Vector vector);

    boolean isOccupied(Vector vector);

    Vector getVectorInFrontOfMe(WorldDirection myDirection, Vector myVector);
}

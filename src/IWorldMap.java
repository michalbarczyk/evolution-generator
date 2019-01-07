public interface IWorldMap {

    Object objectAt(Vector vector);

    boolean isOccupied(Vector vector);

    Area getAreaInFrontOfMe(WorldDirection myDirection, Area myArea);
}

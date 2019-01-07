public class Animal extends Creature {

    private int animalEnergy;
    private WorldDirection animalDirection;
    private Genom animalGenom;

    public Animal(Area initArea, WorldDirection initDirection, int energy, Genom initGenom) {
        super(initArea);
        this.animalEnergy = energy;
        this.animalDirection = initDirection;
        this.animalGenom = initGenom;

    }

    public void move(MoveDirection direction) {

        switch (direction) {

            case FORWARDLEFT:
                animalDirection = animalDirection.prev(1);
                break;
            case LEFT:
                animalDirection = animalDirection.prev(2);
                break;
            case BACKWARDLEFT:
                animalDirection = animalDirection.prev(3);
                break;
            case FORWARDRIGHT:
                animalDirection = animalDirection.next(1);
                break;
            case RIGHT:
                animalDirection = animalDirection.next(2);
                break;
            case BACKWARDRIGHT:
                animalDirection = animalDirection.next(3);
                break;
            case BACKWARD:
                animalDirection = animalDirection.next(4);
                break;
            case FORWARD:
                animalDirection = animalDirection.next(0);
                break;
        }

        Area oldArea = creatureArea;
        creatureArea = creatureArea.getIWorldMap().getAreaInFrontOfMe(animalDirection, creatureArea);
    }

    @Override
    public String toString() {
        switch (this.animalDirection) {

            case NORTH:
                return "/\\";
            case NORTHEAST:
                return "^>";
            case EAST:
                return "->";
            case SOUTHEAST:
                return "v>";
            case SOUTH:
                return "\\/";
            case SOUTHWEST:
                return "<v";
            case WEST:
                return "<-";
            case NORTHWEST:
                return "<^";
        }

        return null;
    }

}

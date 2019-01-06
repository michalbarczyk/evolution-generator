public class Animal extends Creature {

    private int animalEnergy;
    private WorldDirection animalDirection;
    private Genom animalGenom;

    public Animal(Vector initVector) {
        super(initVector);
    }

    public void move(MoveDirection direction) {

        switch (direction) {

            case FORWARDLEFT:
                animalDirection = animalDirection.prev(1);
            case LEFT:
                animalDirection = animalDirection.prev(2);
            case BACKWARDLEFT:
                animalDirection = animalDirection.prev(3);
            case FORWARDRIGHT:
                animalDirection = animalDirection.next(1);
            case RIGHT:
                animalDirection = animalDirection.next(2);
            case BACKWARDRIGHT:
                animalDirection = animalDirection.next(3);
            case BACKWARD:
                animalDirection = animalDirection.next(4);
            case FORWARD:
                animalDirection = animalDirection.next(0);
        }



    }

    @Override
    public String toString() {
        return "A";
    }

}

public enum WorldDirection {

    NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST;

    private WorldDirection oneNext() {

        switch (this) {

            case NORTH:
                return NORTHEAST;

            case NORTHEAST:
                return EAST;

            case EAST:
                return SOUTHEAST;

            case SOUTHEAST:
                return SOUTH;

            case SOUTH:
                return SOUTHWEST;

            case SOUTHWEST:
                return WEST;

            case WEST:
                return NORTHWEST;

            case NORTHWEST:
                return NORTH;
        }
        return null;
    }

    private WorldDirection onePrev() {

        switch (this) {

            case NORTH:
                return NORTHWEST;

            case NORTHWEST:
                return WEST;

            case WEST:
                return SOUTHWEST;

            case SOUTHWEST:
                return SOUTH;

            case SOUTH:
                return SOUTHEAST;

            case SOUTHEAST:
                return EAST;

            case EAST:
                return NORTHEAST;

            case NORTHEAST:
                return NORTH;
        }
        return null;
    }

    public WorldDirection next(int changesNo) {
        WorldDirection result = this;

        for (int i = 0; i < changesNo; i++) {
            result = result.oneNext();
        }

        return result;
    }

    public WorldDirection prev(int changesNo) {
        WorldDirection result = this;

        for (int i = 0; i < changesNo; i++) {
            result = result.onePrev();
        }

        return result;
    }
}

import java.util.ArrayList;
import java.util.List;

public abstract class Creature implements IWorldElement {

    protected Area creatureArea;

    public Creature(Area initArea) {
        this.creatureArea = initArea;
    }


    @Override
    public Area getArea() {
        return this.creatureArea;
    }


}

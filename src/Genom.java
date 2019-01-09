import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Genom {

    private Map<MoveDirection, Double> genes;

    public Genom() {
        genes = new HashMap<>();
    }

    public Collection<Double> getValues() {
        return genes.values();
    }
    public Collection<Map.Entry<MoveDirection, Double>> getGenes() {
        return genes.entrySet();
    }

    public Map<MoveDirection, Double> getMap() {return genes;}

    public Genom getChildGenom() {
        DistributedRandomValuesGenerator<MoveDirection> generator = new DistributedRandomValuesGenerator<>();
        for (MoveDirection moveDirection : genes.keySet()) {
            generator.add(moveDirection, 0.1d);
        }

    }
}

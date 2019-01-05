import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Genom {

    private Map<MoveDirection, Integer> genes;

    public Genom() {
        genes = new HashMap<>();
    }

    public Collection<Integer> getValues() {
        return genes.values();
    }
    public Collection<Map.Entry<MoveDirection, Integer>> getGenes() {
        return genes.entrySet();
    }

    public Map<MoveDirection, Integer> getMap() {return genes;}
}

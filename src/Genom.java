import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Genom {

    private Map<MoveDirection, Double> genes;

    public Genom(Map<MoveDirection, Double> genes) {
        this.genes = genes;
    }

    public Collection<Double> getValues() {
        return genes.values();
    }
    public Collection<Map.Entry<MoveDirection, Double>> getGenes() {
        return genes.entrySet();
    }

    public Map<MoveDirection, Double> getMap() {return genes;}

    public Genom getChildGenom() {
        DistributedRandomValuesGenerator<MoveDirection> crossingOverGenerator = new DistributedRandomValuesGenerator<>();
        for (MoveDirection moveDirection : genes.keySet()) {
            crossingOverGenerator.add(moveDirection, 0.1d);
        }

        DistributedRandomValuesGenerator<Double> changeGenerator = new DistributedRandomValuesGenerator<>();
        changeGenerator.add(1.0d, 0.1d);
        changeGenerator.add(-1.0d, 0.1d);

        Genom childGenom = this.getCopy();

        MoveDirection crossingOver = crossingOverGenerator.getDistributedRandom();
        Double change = changeGenerator.getDistributedRandom();
        Double currGeneValue = childGenom.getMap().get(crossingOver);
        if (currGeneValue > 1.0)
            childGenom.getMap().put(crossingOver, childGenom.getMap().remove(crossingOver) + change);

        return childGenom;
    }

    private Genom getCopy() {
        Genom genom = new Genom(new HashMap<>(this.genes));
        return genom;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        for (Map.Entry<MoveDirection, Double> gene : genes.entrySet()) {
            builder.append(gene.getKey());
            builder.append(" : ");
            builder.append(gene.getValue());
            builder.append("\n");
        }

        return builder.toString();
    }
}

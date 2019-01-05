import java.util.Map;

public class RandomMoveDirectionGenerator {

    public static MoveDirection generate(Genom genom) {

        DistributedRandomValuesGenerator<MoveDirection> generator = new DistributedRandomValuesGenerator<>();
        Integer valuesSum = 0;
        for (Integer value : genom.getValues()) {
            valuesSum += value;
        }

        for (Map.Entry<MoveDirection, Integer> gene : genom.getGenes()) {
            generator.add(gene.getKey(), gene.getValue().doubleValue() / valuesSum.doubleValue());
        }

        return generator.getDistributedRandom();
   }
}

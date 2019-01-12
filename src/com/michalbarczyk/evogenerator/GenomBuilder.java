package com.michalbarczyk.evogenerator;

import java.util.HashMap;
import java.util.Map;

public class GenomBuilder {

    public static Genom buildImpartialGenom() {

        Map<MoveDirection, Double> genes = new HashMap<>();
        genes.put(MoveDirection.FORWARD, 10.0d);
        genes.put(MoveDirection.FORWARDRIGHT, 10.0d);
        genes.put(MoveDirection.RIGHT, 10.0d);
        genes.put(MoveDirection.BACKWARDRIGHT, 10.0d);
        genes.put(MoveDirection.BACKWARD, 10.0d);
        genes.put(MoveDirection.BACKWARDLEFT, 10.0d);
        genes.put(MoveDirection.LEFT, 10.0d);
        genes.put(MoveDirection.FORWARDLEFT, 10.0d);

        return new Genom(genes);
    }
}

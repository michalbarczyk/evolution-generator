package com.michalbarczyk.evogenerator;

import java.util.HashMap;
import java.util.Map;

public class DistributedRandomValuesGenerator<T> {

    private Map<T, Double> distribution;
    private double distSum;

    public DistributedRandomValuesGenerator() {
        distribution = new HashMap<>();
    }

    public void add(T item, double distribution) {
        if (this.distribution.get(item) != null) {
            distSum -= this.distribution.get(item);
        }
        this.distribution.put(item, distribution);
        distSum += distribution;
    }

    public T getDistributedRandom() {
        double rand = Math.random();
        double ratio = 1.0f / distSum;
        double tempDist = 0;
        for (T key : distribution.keySet()) {
            tempDist += distribution.get(key);
            if (rand / ratio <= tempDist) {
                return key;
            }
        }
        return null;
    }

}
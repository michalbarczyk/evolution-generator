package com.michalbarczyk.evogenerator;

import javax.swing.*;

public class Init {

    public static void main(String[] args) {

        int length = Integer.valueOf(args[0]);
        int height = Integer.valueOf(args[1]);
        int worldJungleRatio = Integer.valueOf(args[2]);
        int initAnimalsQty = Integer.valueOf(args[3]);
        int initPlantsQty = Integer.valueOf(args[4]);
        Double density = Double.valueOf(args[5]);
        int duration = Integer.valueOf(args[6]);
        int refresh = Integer.valueOf(args[7]);

        Genom initGenom = GenomBuilder.buildImpartialGenom();
        WorldMap worldMap = WorldMapBuilder.build(length, height, worldJungleRatio, initAnimalsQty, initPlantsQty, density, initGenom);
        Simulator simulator = new Simulator(worldMap, duration, refresh);

        simulator.startSimulation();

        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
               ResultsVisualizer.showResult(worldMap.getAnimalsList());
            }
        });
    }


}

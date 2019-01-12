package com.michalbarczyk.evogenerator;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.List;
import java.util.Map;

public class ResultsVisualizer {

    public static void showResult(List<Animal> animals)
    {
        JFrame frame = new JFrame("Evolution results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {
                "#",
                "energy left",
                MoveDirection.FORWARD.toString(),
                MoveDirection.FORWARDRIGHT.toString(),
                MoveDirection.RIGHT.toString(),
                MoveDirection.BACKWARDRIGHT.toString(),
                MoveDirection.BACKWARD.toString(),
                MoveDirection.BACKWARDLEFT.toString(),
                MoveDirection.LEFT.toString(),
                MoveDirection.FORWARDLEFT.toString()
        };

        String[][] representation = new String[animals.size()][10];

        for (Animal animal : animals) {
            representation[animals.indexOf(animal)][0] = Integer.toString(animals.indexOf(animal));
            representation[animals.indexOf(animal)][1] = Integer.toString(animal.getAnimalEnergy());

            Map<MoveDirection, Double> genes = animal.getAnimalGenom().getMap();
            representation[animals.indexOf(animal)][2] = genes.get(MoveDirection.FORWARD).toString();
            representation[animals.indexOf(animal)][3] = genes.get(MoveDirection.FORWARDRIGHT).toString();
            representation[animals.indexOf(animal)][4] = genes.get(MoveDirection.RIGHT).toString();
            representation[animals.indexOf(animal)][5] = genes.get(MoveDirection.BACKWARDRIGHT).toString();
            representation[animals.indexOf(animal)][6] = genes.get(MoveDirection.BACKWARD).toString();
            representation[animals.indexOf(animal)][7] = genes.get(MoveDirection.BACKWARDLEFT).toString();
            representation[animals.indexOf(animal)][8] = genes.get(MoveDirection.LEFT).toString();
            representation[animals.indexOf(animal)][9] = genes.get(MoveDirection.FORWARDLEFT).toString();

        }

        JTable table = new JTable(representation, columnNames);
        table.setBounds(30, 40, 200, 300);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        frame.pack();

        frame.setSize(500, 200);

        frame.setVisible(true);
    }
}

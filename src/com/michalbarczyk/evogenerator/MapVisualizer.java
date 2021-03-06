package com.michalbarczyk.evogenerator;

public class MapVisualizer {

    private WorldMap map;
    private final String leftRightBorder = "|";
    private final String downUpBorder = "-";

    public MapVisualizer(WorldMap map) {
        this.map = map;
    }

    /*

    public String drawAnimals(com.michalbarczyk.evogenerator.Vector downLeft, com.michalbarczyk.evogenerator.Vector upRight) {
        StringBuilder builder = new StringBuilder();

        int length = upRight.x - downLeft.x + 1;
        builder.append("  ");

        for (int i = 0; i < length; i++) {
            builder.append(" ");
            builder.append(String.format("%2d", i));
        }
        builder.append("\n");

        for (int y = upRight.y; y >= downLeft.y; y--) {

            builder.append(String.format("%2d", y));

            for (int x = downLeft.x; x <= upRight.x; x++) {
                builder.append(leftRightBorder);
                com.michalbarczyk.evogenerator.Vector currVector = new com.michalbarczyk.evogenerator.Vector(x,y);
                if (this.map.isOccupied(currVector))
                    builder.append(this.map.animalAt(currVector).toString());
                else
                    builder.append("  ");
            }

            builder.append(leftRightBorder);
            builder.append("\n");


        }

        return builder.toString();
    }

    public String drawPlants(com.michalbarczyk.evogenerator.Vector downLeft, com.michalbarczyk.evogenerator.Vector upRight) {
        StringBuilder builder = new StringBuilder();

        int length = upRight.x - downLeft.x + 1;
        builder.append("  ");

        for (int i = 0; i < length; i++) {
            builder.append(" ");
            builder.append(String.format("%2d", i));
        }
        builder.append("\n");

        for (int y = upRight.y; y >= downLeft.y; y--) {

            builder.append(String.format("%2d", y));

            for (int x = downLeft.x; x <= upRight.x; x++) {
                builder.append(leftRightBorder);
                com.michalbarczyk.evogenerator.Vector currVector = new com.michalbarczyk.evogenerator.Vector(x,y);
                if (this.map.isPlanted(currVector))
                    builder.append(" P");
                else
                    builder.append("  ");
            }

            builder.append(leftRightBorder);
            builder.append("\n");


        }

        return builder.toString();
    }
    */

    public String draw(Vector downLeft, Vector upRight) {
        StringBuilder builder = new StringBuilder();

        int length = upRight.x - downLeft.x + 1;
        builder.append("  ");

        for (int i = 0; i < length; i++) {
            builder.append(" ");
            builder.append(String.format("%3d", i));
        }
        builder.append("\n");

        for (int y = upRight.y; y >= downLeft.y; y--) {

            builder.append(String.format("%3d", y));

            for (int x = downLeft.x; x <= upRight.x; x++) {
                builder.append(leftRightBorder);
                Vector currVector = new Vector(x,y);
                if (this.map.isPlanted(currVector))
                    builder.append("P");
                else
                    builder.append(" ");

                if (this.map.isOccupied(currVector))
                    builder.append(this.map.animalAt(currVector).toString());
                else
                    builder.append("  ");
            }

            builder.append(leftRightBorder);
            builder.append("\n");
        }

        return builder.toString();
    }
}

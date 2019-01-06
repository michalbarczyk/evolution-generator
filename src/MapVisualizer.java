public class MapVisualizer {

    private IWorldMap iWorldMap;
    private final String leftRightBorder = "|";
    private final String downUpBorder = "-";

    public MapVisualizer(IWorldMap iWorldMap) {
        this.iWorldMap = iWorldMap;
    }

    public String draw(Vector downLeft, Vector upRight) {
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
                Vector currVector = new Vector(x,y);
                if (this.iWorldMap.isOccupied(currVector))
                    builder.append(this.iWorldMap.objectAt(currVector).toString());
                else
                    builder.append("  ");
            }

            builder.append(leftRightBorder);
            builder.append("\n");


        }

        return builder.toString();
    }
}

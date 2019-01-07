import java.util.HashMap;
import java.util.Map;

public class Init {

    public static void main(String[] args) {

        Genom genom = new Genom();
        /*genom.getMap().put(MoveDirection.BACKWARD, 10);
        genom.getMap().put(MoveDirection.BACKWARDLEFT, 10);
        genom.getMap().put(MoveDirection.BACKWARDRIGHT, 10);
        genom.getMap().put(MoveDirection.LEFT, 10);
        genom.getMap().put(MoveDirection.RIGHT, 10);
        genom.getMap().put(MoveDirection.FORWARD, 10);
        genom.getMap().put(MoveDirection.FORWARDLEFT, 10);
        genom.getMap().put(MoveDirection.FORWARDRIGHT, 10);

        Map<MoveDirection, Integer> test = new HashMap<>();

        test.put(MoveDirection.BACKWARD, 0);
        test.put(MoveDirection.BACKWARDLEFT, 0);
        test.put(MoveDirection.BACKWARDRIGHT, 0);
        test.put(MoveDirection.LEFT, 0);
        test.put(MoveDirection.RIGHT, 0);
        test.put(MoveDirection.FORWARD, 0);
        test.put(MoveDirection.FORWARDLEFT, 0);
        test.put(MoveDirection.FORWARDRIGHT, 0);


        for (int i = 0; i < 580*1000; i++) {

            MoveDirection moveDirection = RandomMoveDirectionGenerator.generate(genom);
            test.put(moveDirection, test.remove(moveDirection) + 1);

        }

        for (Map.Entry<MoveDirection, Integer> entry : test.entrySet()) {

            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }*/


        IWorldMap iWorldMap = new RectangularWorldMap(8,8);
        Area area = new Area(new Vector(3,3), iWorldMap);
        Animal animal = new Animal(area, WorldDirection.NORTH, 5, genom);



        MapVisualizer mapVisualizer = new MapVisualizer(iWorldMap);
        //System.out.print(mapVisualizer.draw(new Vector(0,0), new Vector(7,7)));
        //animal.move(MoveDirection.RIGHT);
        for(int i = 0; i < 10; i++) {
            animal.move(MoveDirection.FORWARD);
            System.out.print(mapVisualizer.draw(new Vector(0,0), new Vector(7,7)));
        }

    }
}

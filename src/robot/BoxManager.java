package robot;

public class BoxManager {

    private static final int NUMBER_OF_BOXES = 10;
    private int[] boxes = new int[NUMBER_OF_BOXES];
    private Box box = new Box();

    public static int getNumberOfBoxes() {
        return NUMBER_OF_BOXES;
    }

    public void addBlock(int position, int block) {

        if (box.isSpaceLeft(position)) boxes[position] += block;
    }

    public void showInfo() {

        for (int i=0; i<NUMBER_OF_BOXES; i++) {
            System.out.print(boxes[i] + " ");
        }
    }
}

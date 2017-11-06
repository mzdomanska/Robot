package robot;

public class Box {

    private static final int MAX_CAPACITY = 15;
    private static final int NUMBER_OF_BOXES = 10;
    private int[] boxes = new int[NUMBER_OF_BOXES];
    private boolean spaceLeft = true;

    public int getNumberOfBoxes() {
        return NUMBER_OF_BOXES;
    }

    public int[] getBoxes() {
        return boxes;
    }

    public int blocksInTheBox(int position) {

        int blocksInTheBox = boxes[position];
        return blocksInTheBox;

    }

    public boolean isSpaceLeft(int position) {

        if (blocksInTheBox(position) == MAX_CAPACITY) spaceLeft = false;
        else spaceLeft = true;

        return spaceLeft;
    }

}

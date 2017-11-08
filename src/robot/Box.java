package robot;

public class Box {

    private static final int MAX_CAPACITY = 15;
    private static final int NUMBER_OF_BOXES = 10;
    private int[] boxes = new int[NUMBER_OF_BOXES];
    private boolean spaceLeft = true;

    public int getNumberOfBoxes() {

        return NUMBER_OF_BOXES;
    }

    public int blocksInTheBox(int position) {

        return boxes[position];
    }

    public boolean isSpaceLeft(int position) {

        if (blocksInTheBox(position) == MAX_CAPACITY) spaceLeft = false;
        else spaceLeft = true;

        return spaceLeft;
    }

    public void addBlock(int position, int block) {

        if (isSpaceLeft(position) == true) boxes[position] += block;
    }

    public void showInfo() {

        for (int i=0; i<NUMBER_OF_BOXES; i++) {
            System.out.print(boxes[i] + " ");
        }
    }

}

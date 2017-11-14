/*
Rules:
    * there are always blocks in the stash ("Pickup" will always get a block),
    * if the robot already holds a block, "Pickup" will reset the robot to position 0,
    * the robot will not go beyond position 9. Trying to "Move" it further does nothing,
    * "Lowering" a block on a pile of 15 blocks does nothing and the robot will keep any block it holds,
    * "Lowering" without a block does nothing,
    * the robot ignores any command that is not 'P','M' or 'L'.
*/
package robot;

public class Robot {

    private int position;
    private boolean holdsBlock;
    private int previousBlock;

    public Robot() {
        this.position = 0;
        this.holdsBlock = false;
    }

    public int pickUpBlock() {

        int block;

        if (holdsBlock) {
            block = previousBlock;
            position = 0;
        }
        else {
            block = 1;
            previousBlock = block;
            holdsBlock = true;
        }
        return block;
    }

    public void moveBlock(BoxManager boxManager) {

        if (position > boxManager.getNumberOfBoxes()) position = boxManager.getNumberOfBoxes()-1;

        else position += 1;

    }

    public void lowerBlock(int block, BoxManager boxManager) {

        if (holdsBlock) {
            boxManager.addBlock(position, block);
            holdsBlock = false;
            position = 0;
        }
        else return;
    }

}

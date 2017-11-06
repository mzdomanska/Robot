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

import java.util.Arrays;

public class Robot {

    private int position;
    private boolean holdsBlock;
    private int previousBlock;

    Box box = new Box();

    public Robot() {
        this.position = 0;
        this.holdsBlock = false;
    }

    public int pickUpBlock() {

        int block;

        if (holdsBlock == true) {
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

    public void moveBlock() {

        if (position + 1 > box.getNumberOfBoxes()-1) position = box.getNumberOfBoxes()-1;

        else position += 1;

    }

    public void lowerBlock(int block) {

        int[] boxes = box.getBoxes();

        if (box.isSpaceLeft(position) == true && holdsBlock == true) {
            boxes[position] += block;
            holdsBlock = false;
            position = 0;
        }
        else return;
    }

    public void decodeCommands(String command) {

        boolean endOfCommand;
        int block = 0;

        do {
            for(String s : command.split("")) {

                if (s.equals("P"))
                    block = pickUpBlock();
                else if (s.equals("M"))
                    moveBlock();
                else if (s.equals("L"))
                    lowerBlock(block);
            }
            endOfCommand = true;
        }
        while (!endOfCommand);
    }


    public String showInfo() {

        String info;
        int[] quantityOfBlocks = new int[box.getNumberOfBoxes()];

        for (int i = 0; i<box.getNumberOfBoxes(); i++) {
            quantityOfBlocks[i] = box.blocksInTheBox(i);
        }

        info = Arrays.toString(quantityOfBlocks);
        return info;
    }

    public String start(String command) {

        decodeCommands(command);
        String info = showInfo();

        return info;

    }


}

package robot;

public class Box {

    private static final int MAX_CAPACITY = 15;
    private boolean spaceLeft = true;

    public boolean isSpaceLeft(int box) {

        if (box == MAX_CAPACITY) spaceLeft = false;
        else spaceLeft = true;

        return spaceLeft;
    }

}

package minesweeper;

public class Square {
    private boolean isOpened;
    private boolean isFlag;
    //在gridComponent中有，可能改他的更方便。。。。。。。

    private boolean hasLandMine;
    private int numberOfLandMine;
    public Square (boolean flag, boolean opened, boolean landmine, int numberOfLandMine){
        setFlag(flag);
        setHasLandMine(landmine);
        setOpened(opened);
        setNumberOfLandMine(numberOfLandMine);
    }
    public Square(){
        isFlag = false;
        isOpened = false;
        hasLandMine = false;
        numberOfLandMine = 0;
    }
    public void setFlag(boolean flag) {
        isFlag = flag;
    }
//maybe 没用
    public void setHasLandMine(boolean hasLandMine) {
        this.hasLandMine = hasLandMine;
    }
//maybe 没用
    public void setNumberOfLandMine(int numberOfLandMine) {
        this.numberOfLandMine = numberOfLandMine;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public boolean isHasLandMine() {
        return hasLandMine;
    }

    public int getNumberOfLandMine() {
        return numberOfLandMine;
    }
}

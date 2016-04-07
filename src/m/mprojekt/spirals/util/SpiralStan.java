package m.mprojekt.spirals.util;


public class SpiralStan {
    
    private int width;
    private int height;
    private int start;

    private int left;
    private int right;
    private int bottom;

    public SpiralStan(int width, int height) {
        this.width = width;
        this.height = height;
        start = 0;

        left = 0;
        right = width - 1;
        bottom = height - 1;
    }
    
    public void updateAfterFirstStep(){
        width--;
        height--;
        start++;
    }
    
    public void updateAfterThirdStep(){
        width--;
        height--;
    }
    
    public void updateAfterFourthStep(){
        left++;
        right--;
        bottom--;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getStart() {
        return start;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }

}

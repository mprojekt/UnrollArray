package m.mprojekt.spirals.util;


public class ResultHandler {
    
    private final int[] result;
    private int resultIndex;

    public ResultHandler(int width, int height) {
        result = new int[width * height];
        resultIndex = 0;
    }
    
    public void appendPartArray(int[] array) throws IllegalArgumentException{
        resultIndex = ArrayHandler.addArray(result, resultIndex, array);
    }
    
    public int[] getResult(){
        return result;
    }

}

package m.mprojekt.spirals.util;


public class ArrayHandler {
    
    private int[] result;
    private int resultIndex;

    public ArrayHandler(int width, int height) {
        result = new int[width * height];
        resultIndex = 0;
    }
    
    public void appendPartArray(int[] array, int start, int size) throws IllegalArgumentException{
        int[] tmp = ArrayHandler.cutBeetwen(array, start, size);
        resultIndex = ArrayHandler.addArray(result, resultIndex, tmp);
    }
    
    public int[] getResult(){
        return result;
    }
    
    public static boolean isRightArray(int[][] array){
        if(isNull(array))
            return false;
        
        int length = array[0].length;
        for (int[] row : array) {
            if (row.length != length) {
                return false;
            }
        }
        return true;
    }
        
    public static int[] getColumn(int[][] array, int number) throws IllegalArgumentException{
        if(isNull(array))
            return null;
        if(isIndexWrong(number, array.length))
            throw new IllegalArgumentException("Wrong number column!");
        
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i][number];
        }        
        return result;
    }
    
    public static int[] getRow(int[][] array, int number) throws IllegalArgumentException{
        if(isNull(array))
            return null;
        if(isIndexWrong(number, array.length))
            throw new IllegalArgumentException("Wrong number row!");
        
        return array[number];
    }
    
    public static int[] reverse(int[] array){
        if(isNull(array))
            return null;
        
        int j = array.length;
        int[] tmp = new int[j];        
        
        for (int i = 0; i < array.length; i++) {
            tmp[i] = array[--j];
        }
        return tmp;
    }
    
    public static int[] cutBeetwen(int[] array, int start, int size) throws IllegalArgumentException{
        if(isNull(array))
            return null;
        if(isIndexWithAddedModifierWrong(start, size, array.length))
            throw new IllegalArgumentException("Wrong start index or size!");
         
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i + start];
        }
        return result;
    }
    
    public static int addArray(int[] destination, int i, int[] source) throws IllegalArgumentException{
        if(isNull(destination) || isNull(source))
            return i;
        if(isIndexWithAddedModifierWrong(i,  source.length, destination.length))
            throw new IllegalArgumentException("Wrong index!");
        
        System.arraycopy(source, 0, destination, i, source.length);
        return i + source.length;
    }
    
    public static int[][] flipVertically(int[][] array) {
        if(isNull(array))
            return null;
        
        int[][] result = array.clone();
        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - 1 - i];            
        }
        return result;
    }

    public static int[][] flipHorizontally(int[][] array) {
        if(isNull(array))
            return null;
        
        int[][] result = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result[i][result[i].length - 1 - j] = array[i][j];
            }
        }
        return result;
    }
    
    public static void printArray(int[][] array){
        String print = "";
        for (int[] arr : array) {
            for (int j = 0; j < arr.length; j++) {
                print += " " + ((arr[j] < 10) ? " " : "") + arr[j];              
            }
            print += "\n";
        }
        System.out.println(print);
    }
    
    public static void printArray(int[] array){
        String print = "";
        for (int i = 1; i <= array.length; i++) {
            print += " " + ((array[i - 1] < 10)? " ": "") + array[i - 1];
            if((i % 25 == 0))
                print += "\n";
        }
        System.out.println(print);
    }
    
    private static boolean isNull(int[] array){
        return array == null;
    }
    
    private static boolean isNull(int[][] array){
        return array == null;
    }
    
    private static boolean isIndexWrong(int index, int length){
        return isIndexWithAddedModifierWrong(index, 0, length);
    }
    
    private static boolean isIndexWithAddedModifierWrong(int index, int modifier, int length){
        return ((index < 0) || (modifier < 0) || (index + modifier > length));
    }

}

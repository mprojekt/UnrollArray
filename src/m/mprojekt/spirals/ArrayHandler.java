package m.mprojekt.spirals;


public class ArrayHandler {
        
    public static int[] getColumn(int[][] array, int number){
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i][number];
        }        
        return result;
    }
    
    public static int[] getRow(int[][] array, int number){
        return array[number];
    }
    
    public static int[] reverse(int[] array){
        int j = array.length;
        int[] tmp = new int[j];        
        
        for (int i = 0; i < array.length; i++) {
            tmp[i] = array[--j];
        }
        return tmp;
    }
    
    public static int[] cutBeetwen(int[] array, int start, int size){
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i + start];
        }
        return result;
    }
    
    public static int addArray(int[] destination, int i, int[] source){
        System.arraycopy(source, 0, destination, i, source.length);
        return i + source.length;
    }
    
    public static int[][] flipVertically(int[][] array) {
        int[][] result = array.clone();
        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - 1 - i];            
        }
        return result;
    }

    public static int[][] flipHorizontally(int[][] array) {
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

}

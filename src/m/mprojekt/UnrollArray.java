package m.mprojekt;

import m.mprojekt.spirals.*;


public class UnrollArray {

    public static void main(String[] args) {
        int[][] array = new int[3][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 10 * i + j;                
            }            
        }        
        ArrayHandler.printArray(array);
        
        Spirals spiral = new Spirals();
        int[] tmp = spiral.unroll(array);        
        ArrayHandler.printArray(tmp);
    }
    
}

package m.mprojekt;

import m.mprojekt.spirals.*;
import m.mprojekt.spirals.util.*;


public class UnrollArray {

    public static void main(String[] args) {
        int[][] array = new int[6][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 10 * i + j;                
            }            
        }        
        ArrayHandler.printArray(array);
        
        Spiral spiral = new Spiral();
        int[] tmp = spiral.unroll(array);        
        ArrayHandler.printArray(tmp);
    }
    
}

package m.mprojekt;

import m.mprojekt.spirals.*;


public class UnrollArray {

    public static void main(String[] args) {
        int[][] arr = new int[3][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 10 * i + j;                
            }            
        }        
        printArray(arr);
        
        Spirals spiral = new Spirals();
        int[] slimak = spiral.unroll(arr);        
        printArray(slimak);
    }
    
    public static void printArray(int[][] arr){
        String print = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                print += " " + ((arr[i][j] < 10)? " ": "") + arr[i][j];              
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

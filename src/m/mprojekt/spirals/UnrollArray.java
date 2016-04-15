package m.mprojekt.spirals;

public interface UnrollArray {
    
    int[] unroll(int[][] array) throws IllegalArgumentException;
    
    Spiral top();
    Spiral right();
    Spiral bottom();
    Spiral left();
    
    Spiral clockwise();
    Spiral anticlockwise();

}

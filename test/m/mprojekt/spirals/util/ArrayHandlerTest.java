package m.mprojekt.spirals.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ArrayHandlerTest {
    
    int[][] array2D;
    int[][] array2DHight;
    int[][] array2DWeight;
    int[] array;
    
    @Before
    public void setUp() {
        array2D = generateArray(4, 4);
        array2DHight = generateArray(5, 3);
        array2DWeight = generateArray(3, 4);
        array = new int[]{1, 2, 3, 4};
    }

    @Test
    public void testAppendPartArray() {
        ArrayHandler instance = new ArrayHandler(2, 2); 
        instance.appendPartArray(array, 1, 2);  
        assertArrayEquals(new int[]{2, 3, 0, 0}, instance.getResult());
        
         try{
            instance.appendPartArray(array, -2, 3);
            fail("Should be IllegalArgumentException");
        } catch(IllegalArgumentException iae){
            assertTrue(true);
        }
        
        try{
            instance.appendPartArray(array, 53, 2);
            fail("Should be IllegalArgumentException");
        } catch(IllegalArgumentException iae){
            assertTrue(true);
        }
        
        try{
            instance.appendPartArray(array, 0, -1);
            fail("Should be IllegalArgumentException");
        } catch(IllegalArgumentException iae){
            assertTrue(true);
        }
    }

    @Test
    public void testGetResult() {
        ArrayHandler instance = new ArrayHandler(2, 2);        
        assertArrayEquals(new int[]{0, 0, 0, 0}, instance.getResult());
    }

    @Test
    public void testIsRightArray() {        
        assertTrue(ArrayHandler.isRightArray(array2D));
        assertTrue(ArrayHandler.isRightArray(array2DHight));
        assertTrue(ArrayHandler.isRightArray(array2DWeight));
        
        array2D = new int[][]{ {1, 2, 3}, {10, 11}, {20, 21, 22}};
        assertEquals(false, ArrayHandler.isRightArray(array2D));
    }

    @Test
    public void testGetColumn() {
        assertArrayEquals(new int[]{0, 10, 20, 30}, ArrayHandler.getColumn(array2D, 0));
        assertArrayEquals(new int[]{1, 11, 21, 31, 41}, ArrayHandler.getColumn(array2DHight, 1)); 
        assertArrayEquals(new int[]{3, 13, 23}, ArrayHandler.getColumn(array2DWeight, 3)); 
        
        try{
            ArrayHandler.getColumn(array2D, 26);
            fail("Should be IllegalArgumentException");
        } catch(IllegalArgumentException iae){
            assertTrue(true);
        }
        
        try{
            ArrayHandler.getColumn(array2D, -3);
            fail("Should be IllegalArgumentException");
        } catch(IllegalArgumentException iae){
            assertTrue(true);
        }
    }

    @Test
    public void testGetRow() {
        assertArrayEquals(new int[]{20, 21, 22, 23}, ArrayHandler.getRow(array2D, 2));
        assertArrayEquals(new int[]{40, 41, 42}, ArrayHandler.getRow(array2DHight, 4));
        assertArrayEquals(new int[]{0, 1, 2, 3}, ArrayHandler.getRow(array2DWeight, 0));
        
        try{
            ArrayHandler.getRow(array2D, 15);
            fail("Should be IllegalArgumentException");
        } catch(IllegalArgumentException iae){
            assertTrue(true);
        }
        
        try{
            ArrayHandler.getRow(array2D, -1);
            fail("Should be IllegalArgumentException");
        } catch(IllegalArgumentException iae){
            assertTrue(true);
        }
    }

    @Test
    public void testReverse() {
        assertArrayEquals(new int[]{4, 3, 2, 1}, ArrayHandler.reverse(array));
        
        assertNull(ArrayHandler.reverse(null));
    }

    @Test
    public void testCutBeetwen() {
        assertArrayEquals(new int[]{2, 3}, ArrayHandler.cutBeetwen(array, 1, 2));
        assertArrayEquals(new int[]{}, ArrayHandler.cutBeetwen(array, 1, 0));
        
        assertNull(ArrayHandler.cutBeetwen(null, 1, 2));
        
        try{
            ArrayHandler.cutBeetwen(array, -3, 2);
            fail("Should be IllegalArgumentException");
        } catch(IllegalArgumentException iae){
            assertTrue(true);
        }
        
        try{
            ArrayHandler.cutBeetwen(array, 5, 2);
            fail("Should be IllegalArgumentException");
        } catch(IllegalArgumentException iae){
            assertTrue(true);
        }
        
        try{
            ArrayHandler.cutBeetwen(array, 1, -3);
            fail("Should be IllegalArgumentException");
        } catch(IllegalArgumentException iae){
            assertTrue(true);
        }
    }

    @Test
    public void testAddArray() {
        assertEquals(7, ArrayHandler.addArray(new int[10], 3, array));
        
        assertEquals(3, ArrayHandler.addArray(new int[10], 3, null));
        assertEquals(3, ArrayHandler.addArray(null, 3, array));
        
        try{
            ArrayHandler.addArray(new int[10], -2, array);
            fail("Should be IllegalArgumentException");
        } catch(IllegalArgumentException iae){
            assertTrue(true);
        }
        
        try{
            ArrayHandler.addArray(new int[10], 25, array);
            fail("Should be IllegalArgumentException");
        } catch(IllegalArgumentException iae){
            assertTrue(true);
        }
        
        try{
            ArrayHandler.addArray(new int[5], 2, array);
            fail("Should be IllegalArgumentException");
        } catch(IllegalArgumentException iae){
            assertTrue(true);
        }
    }

    @Test
    public void testFlipVertically() {
        int[][] expResult = new int[][]{
            {30, 31, 32, 33}, 
            {20, 21, 22, 23}, 
            {10, 11, 12, 13}, 
            {0, 1, 2, 3}};
        assertArrayEquals(expResult, ArrayHandler.flipVertically(array2D));
        
        int[][] expResultHight = new int[][]{
            {40, 41, 42},
            {30, 31, 32}, 
            {20, 21, 22}, 
            {10, 11, 12}, 
            {0, 1, 2}};
        assertArrayEquals(expResultHight, ArrayHandler.flipVertically(array2DHight));
        
        int[][] expResultWidth = new int[][]{             
            {20, 21, 22, 23}, 
            {10, 11, 12, 13}, 
            {0, 1, 2, 3}};
        assertArrayEquals(expResultWidth, ArrayHandler.flipVertically(array2DWeight));
        
        assertArrayEquals(new int[][]{{0}}, ArrayHandler.flipVertically(new int[][]{{0}}));
        assertNull(ArrayHandler.flipVertically(null));
    }

    @Test
    public void testFlipHorizontally() {
        int[][] expResult = new int[][]{
            {3, 2, 1, 0}, 
            {13, 12, 11, 10}, 
            {23, 22, 21, 20}, 
            {33, 32, 31, 30}};            
        assertArrayEquals(expResult, ArrayHandler.flipHorizontally(array2D));
        
        int[][] expResultHight = new int[][]{
            {2, 1, 0}, 
            {12, 11, 10}, 
            {22, 21, 20}, 
            {32, 31, 30},
            {42, 41, 40}};            
        assertArrayEquals(expResultHight, ArrayHandler.flipHorizontally(array2DHight));
        
        int[][] expResultWidth = new int[][]{
            {3, 2, 1, 0}, 
            {13, 12, 11, 10}, 
            {23, 22, 21, 20}};            
        assertArrayEquals(expResultWidth, ArrayHandler.flipHorizontally(array2DWeight));
        
        assertArrayEquals(new int[][]{{0}}, ArrayHandler.flipHorizontally(new int[][]{{0}}));
        assertNull(ArrayHandler.flipHorizontally(null));
    }
    
    private int[][] generateArray(int row, int column) {
        int[][] result = new int[row][column];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = 10 * i + j;                
            }            
        }
        return result;
    }
    
}
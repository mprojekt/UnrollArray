package m.mprojekt.spirals;

import org.junit.*;
import static org.junit.Assert.*;


public class SpiralTest {
    
    Spiral instance;
    int[][] array;
    int[][] arrayHight;
    int[][] arrayWeight;
    
    public SpiralTest() {
        instance = new Spiral();
    }
    
    @Before
    public void setUp() {
        array = generateArray(4, 4);
        arrayHight = generateArray(5, 3);
        arrayWeight = generateArray(3, 4);
    }

    @Test
    public void testTop() {        
        int[] expResult = {0, 1, 2, 3, 13, 23, 33, 32, 31, 30, 20, 10, 11, 12, 22, 21};
        assertArrayEquals(expResult, instance.unroll(array));
        
        int[] expResultHight = {0, 1, 2, 12, 22, 32, 42, 41, 40, 30, 20, 10, 11, 21, 31};
        assertArrayEquals(expResultHight, instance.unroll(arrayHight));
        
        int[] expResultWeight = {0, 1, 2, 3, 13, 23, 22, 21, 20, 10, 11, 12};
        assertArrayEquals(expResultWeight, instance.unroll(arrayWeight));
    }

    @Test
    public void testRight() {
        int[] expResult = {3, 13, 23, 33, 32, 31, 30, 20, 10, 0, 1, 2, 12, 22, 21, 11};
        assertArrayEquals(expResult, instance.right().unroll(array));
        
        int[] expResultHight = {2, 12, 22, 32, 42, 41, 40, 30, 20, 10, 0, 1, 11, 21, 31};
        assertArrayEquals(expResultHight, instance.right().unroll(arrayHight));
        
        int[] expResultWeight = {3, 13, 23, 22, 21, 20, 10, 0, 1, 2, 12, 11};
        assertArrayEquals(expResultWeight, instance.right().unroll(arrayWeight));
    }

    @Test
    public void testBottom() {
        int[] expResult = {33, 32, 31, 30, 20, 10, 0, 1, 2, 3, 13, 23, 22, 21, 11, 12};
        assertArrayEquals(expResult, instance.bottom().unroll(array));
        
        int[] expResultHight = {42, 41, 40, 30, 20, 10, 0, 1, 2, 12, 22, 32, 31, 21, 11};
        assertArrayEquals(expResultHight, instance.bottom().unroll(arrayHight));
        
        int[] expResultWeight = {23, 22, 21, 20, 10, 0, 1, 2, 3, 13, 12, 11};
        assertArrayEquals(expResultWeight, instance.bottom().unroll(arrayWeight));
    }

    @Test
    public void testLeft() {
        int[] expResult = {30, 20, 10, 0, 1, 2, 3, 13, 23, 33, 32, 31, 21, 11, 12, 22};
        assertArrayEquals(expResult, instance.left().unroll(array));
        
        int[] expResultHight = {40, 30, 20, 10, 0, 1, 2, 12, 22, 32, 42, 41, 31, 21, 11};
        assertArrayEquals(expResultHight, instance.left().unroll(arrayHight));
        
        int[] expResultWeight = {20, 10, 0, 1, 2, 3, 13, 23, 22, 21, 11, 12};
        assertArrayEquals(expResultWeight, instance.left().unroll(arrayWeight));
    }
    
    @Test
    public void testTopAnticlockwise() {        
        int[] expResult = {3, 2, 1, 0, 10, 20, 30, 31, 32, 33, 23, 13, 12, 11, 21, 22};
        assertArrayEquals(expResult, instance.anticlockwise().unroll(array));
        
        int[] expResultHight = {2, 1, 0, 10, 20, 30, 40, 41, 42, 32, 22, 12, 11, 21, 31};
        assertArrayEquals(expResultHight, instance.anticlockwise().unroll(arrayHight));
        
        int[] expResultWeight = {3, 2, 1, 0, 10, 20, 21, 22, 23, 13, 12, 11};
        assertArrayEquals(expResultWeight, instance.anticlockwise().unroll(arrayWeight));
    }

    @Test
    public void testRightAnticlockwise() {
        int[] expResult = {33, 23, 13, 3, 2, 1, 0, 10, 20, 30, 31, 32, 22, 12, 11, 21};
        assertArrayEquals(expResult, instance.anticlockwise().right().unroll(array));
        
        int[] expResultHight = {42, 32, 22, 12, 2, 1, 0, 10, 20, 30, 40, 41, 31, 21, 11};
        assertArrayEquals(expResultHight, instance.anticlockwise().right().unroll(arrayHight));
        
        int[] expResultWeight = {23, 13, 3, 2, 1, 0, 10, 20, 21, 22, 12, 11};
        assertArrayEquals(expResultWeight, instance.anticlockwise().right().unroll(arrayWeight));
    }

    @Test
    public void testBottomAnticlockwise() {
        int[] expResult = {30, 31, 32, 33, 23, 13, 3, 2, 1, 0, 10, 20, 21, 22, 12, 11};
        assertArrayEquals(expResult, instance.anticlockwise().bottom().unroll(array));
        
        int[] expResultHight = {40, 41, 42, 32, 22, 12, 2, 1, 0, 10, 20, 30, 31, 21, 11};
        assertArrayEquals(expResultHight, instance.anticlockwise().bottom().unroll(arrayHight));
        
        int[] expResultWeight = {20, 21, 22, 23, 13, 3, 2, 1, 0, 10, 11, 12};
        assertArrayEquals(expResultWeight, instance.anticlockwise().bottom().unroll(arrayWeight));
    }

    @Test
    public void testLeftAnticlockwise() {
        int[] expResult = {0, 10, 20, 30, 31, 32, 33, 23, 13, 3, 2, 1, 11, 21, 22, 12};
        assertArrayEquals(expResult, instance.anticlockwise().left().unroll(array));
        
        int[] expResultHight = {0, 10, 20, 30, 40, 41, 42, 32, 22, 12, 2, 1, 11, 21, 31};
        assertArrayEquals(expResultHight, instance.anticlockwise().left().unroll(arrayHight));
        
        int[] expResultWeight = {0, 10, 20, 21, 22, 23, 13, 3, 2, 1, 11, 12};
        assertArrayEquals(expResultWeight, instance.anticlockwise().left().unroll(arrayWeight));
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

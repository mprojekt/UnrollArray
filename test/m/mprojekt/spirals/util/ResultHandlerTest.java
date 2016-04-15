package m.mprojekt.spirals.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ResultHandlerTest {
    
    ResultHandler instance;
    
    @Before
    public void setUp() {
        instance = new ResultHandler(4, 5);
    }

    @Test
    public void testAppendToResult() {
        instance.appendToResult(null);
        assertArrayEquals(new int[20], instance.getResult());
        
        instance.appendToResult(new int[]{2, 4});        
        int[] expArray = new int[20];
        expArray[0] = 2;
        expArray[1] = 4;
        assertArrayEquals(expArray, instance.getResult());
    }

    @Test
    public void testGetResult() {
        assertArrayEquals(new int[20], instance.getResult());
    }
    
}

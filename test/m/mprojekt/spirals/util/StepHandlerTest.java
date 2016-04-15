package m.mprojekt.spirals.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class StepHandlerTest {
    
    StepHandler instance;
    
    @Before
    public void setUp() {
        instance = new StepHandler(new int[5][4]);
    }
    
    @Test
    public void testNewInstance(){
        try{
            new StepHandler(null);
            fail("array is null");
        } catch(IllegalArgumentException iae){
            assertTrue(true);
        }
    }

    @Test
    public void testGetStartStep() {
        assertNotNull(instance.getStartStep(StartSide.Bottom));
        
        try{
            instance.getStartStep(null);
            fail("start side is null");
        } catch(IllegalArgumentException iae){
            assertTrue(true);
        }
    }
    
}

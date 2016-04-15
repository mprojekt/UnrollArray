package m.mprojekt.spirals.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SpiralStateTest {
    
    SpiralState instance;
    
    @Before
    public void setUp() {
        instance = new SpiralState(5, 6);
    }

    @Test
    public void testUpdateAfterFirstStep() {
        instance.updateAfterFirstStep();
        
        assertEquals(4, instance.getWidth());
        assertEquals(5, instance.getHeight());
        assertEquals(1, instance.getStart());
    }

    @Test
    public void testUpdateAfterThirdStep() {
        instance.updateAfterThirdStep();
        
        assertEquals(4, instance.getWidth());
        assertEquals(5, instance.getHeight());
    }

    @Test
    public void testUpdateAfterFourthStep() {
        instance.updateAfterFourthStep();
        
        assertEquals(1, instance.getLeft());
        assertEquals(3, instance.getRight());
        assertEquals(4, instance.getBottom());
    }

    @Test
    public void testGetWidth() {
        assertEquals(5, instance.getWidth());
    }

    @Test
    public void testGetHeight() {
        assertEquals(6, instance.getHeight());
    }

    @Test
    public void testGetStart() {
        assertEquals(0, instance.getStart());
    }

    @Test
    public void testGetLeft() {
        assertEquals(0, instance.getLeft());
    }

    @Test
    public void testGetRight() {
        assertEquals(4, instance.getRight());
    }

    @Test
    public void testGetBottom() {
        assertEquals(5, instance.getBottom());
    }
    
}

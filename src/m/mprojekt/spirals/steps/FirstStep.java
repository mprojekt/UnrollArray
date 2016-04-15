package m.mprojekt.spirals.steps;

import m.mprojekt.spirals.util.*;


public class FirstStep extends Step{
  
    @Override
    public int[] getArray(int[][] array, SpiralStan stan) {
        return ArrayHandler.getRow(array, stan.getLeft());
    }

    @Override
    public int getParam(SpiralStan stan) {
        return stan.getWidth();
    }

    @Override
    public void updateStan(SpiralStan stan) {
        stan.updateAfterFirstStep();
    }
    
}

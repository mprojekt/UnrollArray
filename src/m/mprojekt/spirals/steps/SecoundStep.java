package m.mprojekt.spirals.steps;

import m.mprojekt.spirals.util.*;


public class SecoundStep extends Step{

    @Override
    public int[] getArray(int[][] array, SpiralStan stan) {
        return ArrayHandler.getColumn(array, stan.getRight());
    }

    @Override
    public int getParam(SpiralStan stan) {
        return stan.getHeight();
    }

    @Override
    public void updateStan(SpiralStan stan) {        
    }

}

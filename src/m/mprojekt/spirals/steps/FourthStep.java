package m.mprojekt.spirals.steps;

import m.mprojekt.spirals.util.*;


public class FourthStep extends Step{

    @Override
    public int[] getArray(int[][] array, SpiralStan stan) {
        return ArrayHandler.reverse(ArrayHandler.getColumn(array, stan.getLeft()));
    }

    @Override
    public int getParam(SpiralStan stan) {
        return stan.getHeight();
    }

    @Override
    public void updateStan(SpiralStan stan) {
        stan.updateAfterFourthStep();
    }

}

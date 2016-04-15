package m.mprojekt.spirals.steps;

import m.mprojekt.spirals.util.*;


public class ThirdStep extends Step{

    @Override
    public int[] getArray(int[][] array, SpiralStan stan) {
        return ArrayHandler.reverse(ArrayHandler.getRow(array, stan.getBottom()));
    }

    @Override
    public int getParam(SpiralStan stan) {
        return stan.getWidth();
    }

    @Override
    public void updateStan(SpiralStan stan) {
        stan.updateAfterThirdStep();
    }

}

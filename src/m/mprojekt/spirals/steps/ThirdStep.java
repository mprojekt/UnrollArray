package m.mprojekt.spirals.steps;

import m.mprojekt.spirals.util.*;


public class ThirdStep extends Step{

    public ThirdStep(int[][] array, SpiralState state) {
        super(array, state);
    }

    @Override
    public int[] getArray() {
        return ArrayHandler.reverse(ArrayHandler.getRow(array, state.getBottom()));
    }

    @Override
    public int getParam() {
        return state.getWidth();
    }

}

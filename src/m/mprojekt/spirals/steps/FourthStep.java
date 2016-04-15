package m.mprojekt.spirals.steps;

import m.mprojekt.spirals.util.*;


public class FourthStep extends Step{

    public FourthStep(int[][] array, SpiralState state) {
        super(array, state);
    }

    @Override
    public int[] getArray() {
        return ArrayHandler.reverse(ArrayHandler.getColumn(array, state.getLeft()));
    }

    @Override
    public int getParam() {
        return state.getHeight();
    }

}

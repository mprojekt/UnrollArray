package m.mprojekt.spirals.steps;

import m.mprojekt.spirals.util.*;


public class SecoundStep extends Step{

    public SecoundStep(int[][] array, SpiralState state) {
        super(array, state);
    }

    @Override
    public int[] getArray() {
        return ArrayHandler.getColumn(array, state.getRight());
    }

    @Override
    public int getParam() {
        return state.getHeight();
    }

}

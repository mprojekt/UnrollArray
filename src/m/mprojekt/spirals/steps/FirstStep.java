package m.mprojekt.spirals.steps;

import m.mprojekt.spirals.util.*;


public class FirstStep extends Step{

    public FirstStep(int[][] array, SpiralState state) {
        super(array, state);
    }
    
    @Override
    public int[] getArray() {
        return ArrayHandler.getRow(array, state.getLeft());
    }

    @Override
    public int getParam() {
        return state.getWidth();
    }
    
}

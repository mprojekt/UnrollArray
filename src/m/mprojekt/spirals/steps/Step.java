package m.mprojekt.spirals.steps;

import java.util.Objects;
import java.util.function.Consumer;
import m.mprojekt.spirals.util.*;


public abstract class Step {   
    
    private Step nextStep;
    private Consumer<SpiralState> changeStateConsumer;
    protected final SpiralState state;
    protected final int[][] array;

    public Step(int[][] array, SpiralState state) {
        this.state = state;
        this.array = array;
    }
    
    public int[] perform() throws Exception{
        int[] arr = getArray();
        int size = getParam();
        
        if(size <= 0){
            throw new Exception("end");
        }
        
        int[] result = ArrayHandler.cutBeetwen(arr, state.getStart(), size);
        if(changeStateConsumer != null)
            changeStateConsumer.accept(state);
        
        return result;
    }
    
    public abstract int[] getArray();
    public abstract int getParam();
    
    public boolean hasNext() {
        return true;
    }

    public void setChangeStateConsumer(Consumer<SpiralState> changeStateConsumer) {
        this.changeStateConsumer = changeStateConsumer;
    }
    
    public Step next() {
        return nextStep;
    }

    public void setNextStep(Step nextStep) {
        this.nextStep = nextStep;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.nextStep);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Step other = (Step) obj;
        if (!Objects.equals(this.nextStep, other.nextStep)) {
            return false;
        }
        return true;
    }
    
}

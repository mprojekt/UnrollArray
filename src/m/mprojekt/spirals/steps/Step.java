package m.mprojekt.spirals.steps;

import java.util.Objects;
import m.mprojekt.spirals.util.*;


public abstract class Step {   
    
    private Step nextStep;
    private boolean isNext;

    public Step() { 
        isNext = true;
    }
    
    public int[] perform(int[][] array, SpiralStan stan) throws Exception{
        int[] arr = getArray(array, stan);
        int size = getParam(stan);
        
        if(size <= 0){
            throw new Exception("end");
        }            
        
//        arrayHandler.appendPartArray(arr, stan.getStart(), size);
        
        int[] result = ArrayHandler.cutBeetwen(arr, stan.getStart(), size);
        updateStan(stan);
        
        return result;
    }
    
    public abstract int[] getArray(int[][] array, SpiralStan stan);
    public abstract int getParam(SpiralStan stan);
    public abstract void updateStan(SpiralStan stan);
    
    public boolean hasNext() {
        return true;
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

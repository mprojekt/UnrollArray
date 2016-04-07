package m.mprojekt.spirals;

import java.util.function.*;
import m.mprojekt.spirals.util.*;


public class Step {
    
    private final BiFunction<int[][], SpiralStan, int[]> arrayFunction;
    private final Function<SpiralStan, Integer> sizeFunction;
    private final Consumer<SpiralStan> changeStanConsumer;
    
    private Step nextStep;

    public Step(BiFunction<int[][], SpiralStan, int[]> arrayFunction, 
            Function<SpiralStan, Integer> sizeFunction, 
            Consumer<SpiralStan> changeStanConsumer) {
        
        this.arrayFunction = arrayFunction;
        this.sizeFunction = sizeFunction;
        this.changeStanConsumer = changeStanConsumer;
    }
    
    public boolean takeStep(int[][] array, SpiralStan stan, ArrayHandler arrayHandler){        
        int[] arr = arrayFunction.apply(array, stan);
        int size = sizeFunction.apply(stan);
        
        if(size <= 0 ) 
            return false;
        arrayHandler.appendPartArray(arr, stan.getStart(), size);
        
        if(changeStanConsumer != null)
            changeStanConsumer.accept(stan);
        
        return true;
    }

    public Step nextStep() {
        return nextStep;
    }

    public void setNextStep(Step nextStep) {
        this.nextStep = nextStep;
    }
    
    public static Step getFirstStep(StartSide startSide){
        Step first = new Step(startSide::firstStep, startSide::choiceFirstParam, s -> s.updateAfterFirstStep());
        Step secound = new Step(startSide::secondStep, startSide::choiceSecoundParam, null);        
        Step third = new Step(startSide::thirdStep, startSide::choiceThirdParam, s -> s.updateAfterThirdStep());        
        Step fourth = new Step(startSide::fourthStep, startSide::choiceFourthParam, s -> s.updateAfterFourthStep());
        
        first.setNextStep(secound);
        secound.setNextStep(third);
        third.setNextStep(fourth);
        fourth.setNextStep(first);
        
        return first;
    }

}

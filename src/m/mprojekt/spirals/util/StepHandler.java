package m.mprojekt.spirals.util;

import java.util.*;
import m.mprojekt.spirals.steps.*;


public class StepHandler {

    private final Map<String, Step> steps;
    private final SpiralState state;
    private final int[][] array;
    
    public StepHandler(int[][] array) throws IllegalArgumentException{
        if(array == null)
            throw new IllegalArgumentException(this.getClass().getSimpleName()+ ": null Array param");
        
        this.array = array;
        state = new SpiralState(array[0].length, array.length); 
        steps = generateSteps();
    }   
    
    public Step getStartStep(StartSide startSide) throws IllegalArgumentException{
        if(startSide == null)
            throw new IllegalArgumentException(this.getClass().getSimpleName()+ ": null Start Side param");
        
        Step result = steps.get(startSide.toString());
        result = addChangeStateConsumer(result);
        return result;
    }
    
    
    private Map<String, Step> generateSteps() {
        Step first = new FirstStep(array, state);
        Step secound = new SecoundStep(array, state);
        Step third = new ThirdStep(array, state);
        Step fourth = new FourthStep(array, state);
        
        first.setNextStep(secound);
        secound.setNextStep(third);
        third.setNextStep(fourth);
        fourth.setNextStep(first);
        
        Map<String, Step> result = new HashMap<>();
        result.put("Top", first);
        result.put("Right", secound);
        result.put("Bottom", third);
        result.put("Left", fourth);
        
        return result;
    }

    private Step addChangeStateConsumer(Step result) {
        result.setChangeStateConsumer(s -> s.updateAfterFirstStep());
        Step third = result.next().next();
        third.setChangeStateConsumer(s -> s.updateAfterThirdStep());
        Step fourth = third.next();
        fourth.setChangeStateConsumer(s -> s.updateAfterFourthStep());
        return result;
    }

}

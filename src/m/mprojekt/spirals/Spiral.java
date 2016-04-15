package m.mprojekt.spirals;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import m.mprojekt.spirals.steps.*;
import m.mprojekt.spirals.util.*;


public class Spiral {
    
    StartSide startSide;
    Direction direction;
    
    Map<String, Step> steps; 
    
    public Spiral() {
        startSide = StartSide.Top;
        direction = Direction.Clockwise;
        
        steps = generateSteps();
    }
    
    public int[] unroll(int[][] array) throws IllegalArgumentException{
        if(!ArrayHandler.isRightArray(array))
            throw new IllegalArgumentException("Not all of rows are the same length.");
        
        array = preparationArray(array);
        
        ResultHandler resultHandler = new ResultHandler(array[0].length, array.length);
        SpiralStan stan = new SpiralStan(array[0].length, array.length);
        Step actual = steps.get(startSide.toString());
        
        while(actual.hasNext()){
            try {
                int[] tmp = actual.perform(array, stan);
                resultHandler.appendPartArray(tmp);
                actual = actual.next();
            } catch (Exception ex) {
//                Logger.getLogger(Spiral.class.getName()).log(Level.INFO, "End processing");
                break;
            }
        }      
        
        return resultHandler.getResult();
    }    
    
    public Spiral top(){
        this.startSide = StartSide.Top;
        return this;
    }
    
    public Spiral right(){
        this.startSide = StartSide.Right;
        return this;
    }
    
    public Spiral bottom(){
        this.startSide = StartSide.Bottom;
        return this;
    }
    
    public Spiral left(){
        this.startSide = StartSide.Left;
        return this;
    }
    
    public Spiral clockwise(){
        this.direction = Direction.Clockwise;
        return this;
    }
    
    public Spiral anticlockwise(){
        this.direction = Direction.Anticlockwise;
        return this;
    }    

    private int[][] preparationArray(int[][] array) {
        if(direction == Direction.Anticlockwise){
            if(startSide == StartSide.Top || startSide == StartSide.Bottom){
                return ArrayHandler.flipHorizontally(array);
            } else if(startSide == StartSide.Left || startSide == StartSide.Right){
                return ArrayHandler.flipVertically(array);
            }
        }
        return array;
    }

    private Map<String, Step> generateSteps() {
        Step first = new FirstStep();
        Step secound = new SecoundStep();
        Step third = new ThirdStep();
        Step fourth = new FourthStep();
        
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

}

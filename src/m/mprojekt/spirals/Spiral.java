package m.mprojekt.spirals;

import m.mprojekt.spirals.steps.*;
import m.mprojekt.spirals.util.*;


public class Spiral implements UnrollArray{
    
    StartSide startSide;
    Direction direction;
    
    public Spiral() {
        startSide = StartSide.Top;
        direction = Direction.Clockwise;        
        
    }
    
    @Override
    public int[] unroll(int[][] array) throws IllegalArgumentException{
        if(!ArrayHandler.isRightArray(array))
            throw new IllegalArgumentException(this.getClass().getSimpleName() + ": Not all of rows are the same length.");
        
        array = preparationArray(array);
        
        StepHandler stepHandler = new StepHandler(array);                    
        Step actual = stepHandler.getStartStep(startSide);        
        ResultHandler resultHandler = new ResultHandler(array[0].length, array.length);
        
        while(actual.hasNext()){
            try {
                int[] tmp = actual.perform();
                resultHandler.appendToResult(tmp);
                actual = actual.next();
            } catch (Exception ex) {
                break;
            }
        }      
        
        return resultHandler.getResult();
    }    
    
    @Override
    public Spiral top(){
        this.startSide = StartSide.Top;
        return this;
    }
    
    @Override
    public Spiral right(){
        this.startSide = StartSide.Right;
        return this;
    }
    
    @Override
    public Spiral bottom(){
        this.startSide = StartSide.Bottom;
        return this;
    }
    
    @Override
    public Spiral left(){
        this.startSide = StartSide.Left;
        return this;
    }
    
    @Override
    public Spiral clockwise(){
        this.direction = Direction.Clockwise;
        return this;
    }
    
    @Override
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

}

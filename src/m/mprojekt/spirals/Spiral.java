package m.mprojekt.spirals;

import m.mprojekt.spirals.util.*;


public class Spiral {

    StartSide startSide;
    Direction direction;
    
    public Spiral() {
        startSide = StartSide.Top;
        direction = Direction.Clockwise;
    }

    public int[] unroll(int[][] array){
        ArrayHandler arrayHandler = new ArrayHandler(array[0].length, array.length);
        SpiralStan stan = new SpiralStan(array[0].length, array.length);
                
        array = preparationArray(array);
        
        Step actual = Step.getFirstStep(startSide);        
        boolean isNext = true;
        while(isNext){            
            isNext = actual.takeStep(array, stan, arrayHandler);
            actual = actual.nextStep();
        }
        
        return arrayHandler.getResult();
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
    
}
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
        
        while(true){
            int[] a = startSide.firstStep(array, stan);
            int sizeA = startSide.choiceFirstParam(stan);
            if(sizeA <= 0 ) break;
            
            arrayHandler.appendPartArray(a, stan.getStart(), sizeA);
            stan.updateAfterFirstStep();
            
            //=============
            
            int[] b = startSide.secondStep(array, stan);
            int sizeB = startSide.choiceSecoundParam(stan);
            if(sizeB <= 0 ) break;
            
            arrayHandler.appendPartArray(b, stan.getStart(), sizeB);
            
            //=============
            
            int[] c = startSide.thirdStep(array, stan);
            int sizeC = startSide.choiceThirdParam(stan);
            if(sizeC <= 0 ) break;
            
            arrayHandler.appendPartArray(c, stan.getStart(), sizeC);
            stan.updateAfterThirdStep();
            
            //============
            
            int[] d = startSide.fourthStep(array, stan);
            int sizeD = startSide.choiceFourthParam(stan);
            if(sizeD <= 0 ) break;
            
            arrayHandler.appendPartArray(d, stan.getStart(), sizeD);
            stan.updateAfterFourthStep();
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
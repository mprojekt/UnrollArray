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
        ArrayHandler arrayHandler = new ArrayHandler(array.length, array[0].length);
        
        int width = array[0].length;
        int height = array.length;
        int start = 0;
        
        int left = 0;
        int right = array[0].length - 1;
        int bottom = array.length - 1;
        
        array = preparationArray(array);
        
        while(true){
            int[] a = startSide.firstStep(array, left, right, bottom);
            int sizeA = startSide.choiceFirstParam(width, height);
            if(sizeA <= 0 ) break;
            
            arrayHandler.appendPartArray(a, start, sizeA);
            
            width--;
            height--;
            start++;
            
            //=============
            
            int[] b = startSide.secondStep(array, left, right, bottom);
            int sizeB = startSide.choiceSecoundParam(width, height);
            if(sizeB <= 0 ) break;
            
            arrayHandler.appendPartArray(b, start, sizeB);
            
            //=============
            
            int[] c = startSide.thirdStep(array, left, right, bottom);
            int sizeC = startSide.choiceThirdParam(width, height);
            if(sizeC <= 0 ) break;
            
            arrayHandler.appendPartArray(c, start, sizeC);
            
            width--;
            height--;
            
            //============
            
            int[] d = startSide.fourthStep(array, left, right, bottom);
            int sizeD = startSide.choiceFourthParam(width, height);
            if(sizeD <= 0 ) break;
            
            arrayHandler.appendPartArray(d, start, sizeD);
            
            left++;
            right--;
            bottom--;
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
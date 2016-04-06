package m.mprojekt.spirals;


public class Spirals {

    StartSide startSide;
    Direction direction;
    
    public Spirals() {
        startSide = StartSide.Top;
        direction = Direction.Clockwise;
    }

    public int[] unroll(int[][] array){
        int[] result = new int[array.length * array[0].length];
        int resultIndex = 0;
        int width = array[0].length;
        int height = array.length;
        int start = 0;
        int left = 0;
        int right = array[0].length - 1;
        int bottom = array.length - 1;
        
        if(direction == Direction.Anticlockwise){
            if(startSide == StartSide.Top || startSide == StartSide.Bottom){
                array = ArrayHandler.flipHorizontally(array);
            } else if(startSide == StartSide.Left || startSide == StartSide.Right){
                array = ArrayHandler.flipVertically(array);
            }
        }
        
        while(true){
            int[] a = startSide.firstStep(array, left, right, bottom);
            int[] ac = ArrayHandler.cutBeetwen(a, start, startSide.choiceFirstParam(width, height));
            if(ac.length <= 0 )
                break;
            resultIndex = ArrayHandler.addArray(result, resultIndex, ac);
            
            width--;
            height--;
            start++;
            
            int[] b = startSide.secondStep(array, left, right, bottom);
            int[] bc = ArrayHandler.cutBeetwen(b, start, startSide.choiceSecoundParam(width, height));
            if(bc.length <= 0 )
                break;
            resultIndex = ArrayHandler.addArray(result, resultIndex, bc);
            
            int[] c = startSide.thirdStep(array, left, right, bottom);
            int[] cc = ArrayHandler.cutBeetwen(c, start, startSide.choiceThirdParam(width, height));
            if(cc.length <= 0 )
                break;
            resultIndex = ArrayHandler.addArray(result, resultIndex, cc);
            
            width--;
            height--;
            
            int[] d = startSide.fourthStep(array, left, right, bottom);
            int[] dc = ArrayHandler.cutBeetwen(d, start, startSide.choiceFourthParam(width, height));
            if(dc.length <= 0 )
                break;
            resultIndex = ArrayHandler.addArray(result, resultIndex, dc);
            
            left++;
            right--;
            bottom--;
        }
        
        return result;
    }
    
    public Spirals top(){
        this.startSide = StartSide.Top;
        return this;
    }
    
    public Spirals right(){
        this.startSide = StartSide.Right;
        return this;
    }
    
    public Spirals bottom(){
        this.startSide = StartSide.Bottom;
        return this;
    }
    
    public Spirals left(){
        this.startSide = StartSide.Left;
        return this;
    }
    
    public Spirals clockwise(){
        this.direction = Direction.Clockwise;
        return this;
    }
    
    public Spirals anticlockwise(){
        this.direction = Direction.Anticlockwise;
        return this;
    }    
    
}
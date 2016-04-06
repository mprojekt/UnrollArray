package m.mprojekt.spirals;


public class Spirals {
    
    StartSide startSide = StartSide.Top;
    Direction direction = Direction.Clockwise;

    public int[] unroll(int[][] array){
        int[] result = new int[array.length * array[0].length];
        int resultI = 0;        
        int width = array[0].length;
        int height = array.length;
        int start = 0;
        int left = 0;
        int right = array[0].length - 1;
        int bottom = array.length - 1;
        
        if(direction == Direction.Anticlockwise){
            if(startSide == StartSide.Top || startSide == StartSide.Bottom){
                array = flipHorizontally(array);
            } else if(startSide == StartSide.Left || startSide == StartSide.Right){
                array = flipVertically(array);
            }
        }
        
        while(true){
            int[] a = startSide.firstStep(array, left, right, bottom);
            int[] ac = cutBeetwen(a, start, startSide.choiceFirstParam(width, height));
            if(ac.length <= 0 )
                break;
            resultI = addArray(result, resultI, ac);
            
            width--;
            height--;
            start++;
            
            int[] b = startSide.secondStep(array, left, right, bottom);
            int[] bc = cutBeetwen(b, start, startSide.choiceSecoundParam(width, height));
            if(bc.length <= 0 )
                break;
            resultI = addArray(result, resultI, bc);
            
            int[] c = startSide.thirdStep(array, left, right, bottom);
            int[] cc = cutBeetwen(c, start, startSide.choiceThirdParam(width, height));
            if(cc.length <= 0 )
                break;
            resultI = addArray(result, resultI, cc);
            
            width--;
            height--;
            
            int[] d = startSide.fourthStep(array, left, right, bottom);
            int[] dc = cutBeetwen(d, start, startSide.choiceFourthParam(width, height));
            if(dc.length <= 0 )
                break;
            resultI = addArray(result, resultI, dc);
            
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
    
    private static int[] cutBeetwen(int[] arr, int start, int width){
        int[] result = new int[width];
        for (int i = 0; i < width; i++) {
            result[i] = arr[i + start];
        }
        return result;
    }
    
    private static int addArray(int[] dest, int i, int[] arr){
        System.arraycopy(arr, 0, dest, i, arr.length);
        return i + arr.length;
    }

    private int[][] flipVertically(int[][] array) {
        int[][] result = array.clone();
        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - 1 - i];            
        }  
        printArray(result);
        return result;
    }

    private int[][] flipHorizontally(int[][] array) {
        int[][] result = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result[i][result[i].length - 1 - j] = array[i][j];
            }
        }
        printArray(result);
        return result;
    }
    
    private static void printArray(int[][] arr){
        String print = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                print += " " + ((arr[i][j] < 10)? " ": "") + arr[i][j];              
            }
            print += "\n";
        }
        System.out.println(print);
    }
}
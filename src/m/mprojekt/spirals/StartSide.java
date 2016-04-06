package m.mprojekt.spirals;

public enum StartSide {
    
    Top {

        @Override
        int[] firstStep(int[][] array, int left, int right, int bottom) {
            return getRow(array, left);
        }

        @Override
        int[] secondStep(int[][] array, int left, int right, int bottom) {
            return getColumn(array, right);
        }

        @Override
        int[] thirdStep(int[][] array, int left, int right, int bottom) {
            return reverse(getRow(array, bottom));
        }

        @Override
        int[] fourthStep(int[][] array, int left, int right, int bottom) {
            return reverse(getColumn(array, left));
        }

        @Override
        int choiceFirstParam(int width, int height) {
            return width;
        }

        @Override
        int choiceSecoundParam(int width, int height) {
            return height;
        }

        @Override
        int choiceThirdParam(int width, int height) {
            return width;
        }

        @Override
        int choiceFourthParam(int width, int height) {
            return height;
        }
    }, Right {

        @Override
        int[] firstStep(int[][] array, int left, int right, int bottom) {
            return getColumn(array, right);
        }

        @Override
        int[] secondStep(int[][] array, int left, int right, int bottom) {
            return reverse(getRow(array, bottom));
        }

        @Override
        int[] thirdStep(int[][] array, int left, int right, int bottom) {
            return reverse(getColumn(array, left));
        }

        @Override
        int[] fourthStep(int[][] array, int left, int right, int bottom) {
            return getRow(array, left);
        }

        @Override
        int choiceFirstParam(int width, int height) {
            return height;
        }

        @Override
        int choiceSecoundParam(int width, int height) {
            return width;
        }

        @Override
        int choiceThirdParam(int width, int height) {
            return height;
        }

        @Override
        int choiceFourthParam(int width, int height) {
            return width;
        }
    }, Bottom {

        @Override
        int[] firstStep(int[][] array, int left, int right, int bottom) {
            return reverse(getRow(array, bottom));
        }

        @Override
        int[] secondStep(int[][] array, int left, int right, int bottom) {
            return reverse(getColumn(array, left));
        }

        @Override
        int[] thirdStep(int[][] array, int left, int right, int bottom) {
            return getRow(array, left);
        }

        @Override
        int[] fourthStep(int[][] array, int left, int right, int bottom) {
            return getColumn(array, right);
        }

        @Override
        int choiceFirstParam(int width, int height) {
            return width;
        }

        @Override
        int choiceSecoundParam(int width, int height) {
            return height;
        }

        @Override
        int choiceThirdParam(int width, int height) {
            return width;
        }

        @Override
        int choiceFourthParam(int width, int height) {
            return height;
        }
    }, Left {

        @Override
        int[] firstStep(int[][] array, int left, int right, int bottom) {
            return reverse(getColumn(array, left));
        }

        @Override
        int[] secondStep(int[][] array, int left, int right, int bottom) {
            return getRow(array, left);
        }

        @Override
        int[] thirdStep(int[][] array, int left, int right, int bottom) {
            return getColumn(array, right);
        }

        @Override
        int[] fourthStep(int[][] array, int left, int right, int bottom) {
            return reverse(getRow(array, bottom));
        }

        @Override
        int choiceFirstParam(int width, int height) {
            return height;
        }

        @Override
        int choiceSecoundParam(int width, int height) {
            return width;
        }

        @Override
        int choiceThirdParam(int width, int height) {
            return height;
        }

        @Override
        int choiceFourthParam(int width, int height) {
            return width;
        }
    };
    
    abstract int[] firstStep(int[][] array, int left, int right, int bottom);
    abstract int[] secondStep(int[][] array, int left, int right, int bottom);
    abstract int[] thirdStep(int[][] array, int left, int right, int bottom);
    abstract int[] fourthStep(int[][] array, int left, int right, int bottom);    
    
    abstract int choiceFirstParam(int width, int height);
    abstract int choiceSecoundParam(int width, int height);
    abstract int choiceThirdParam(int width, int height);
    abstract int choiceFourthParam(int width, int height);
    
    private static int[] getColumn(int[][] arr, int number){
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i][number];
        }        
        return result;
    }
    
    private static int[] getRow(int[][] arr, int number){
        return arr[number];
    }
    
    private static int[] reverse(int[] arr){
        int j = arr.length;
        int[] tmp = new int[j];        
        
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[--j];
        }
        return tmp;
    }
    
}

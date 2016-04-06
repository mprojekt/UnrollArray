package m.mprojekt.spirals;

public enum StartSide {
    
    Top {

        @Override
        int[] firstStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.getRow(array, left);
        }

        @Override
        int[] secondStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.getColumn(array, right);
        }

        @Override
        int[] thirdStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.reverse(ArrayHandler.getRow(array, bottom));
        }

        @Override
        int[] fourthStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.reverse(ArrayHandler.getColumn(array, left));
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
            return ArrayHandler.getColumn(array, right);
        }

        @Override
        int[] secondStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.reverse(ArrayHandler.getRow(array, bottom));
        }

        @Override
        int[] thirdStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.reverse(ArrayHandler.getColumn(array, left));
        }

        @Override
        int[] fourthStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.getRow(array, left);
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
            return ArrayHandler.reverse(ArrayHandler.getRow(array, bottom));
        }

        @Override
        int[] secondStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.reverse(ArrayHandler.getColumn(array, left));
        }

        @Override
        int[] thirdStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.getRow(array, left);
        }

        @Override
        int[] fourthStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.getColumn(array, right);
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
            return ArrayHandler.reverse(ArrayHandler.getColumn(array, left));
        }

        @Override
        int[] secondStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.getRow(array, left);
        }

        @Override
        int[] thirdStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.getColumn(array, right);
        }

        @Override
        int[] fourthStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.reverse(ArrayHandler.getRow(array, bottom));
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
    
}

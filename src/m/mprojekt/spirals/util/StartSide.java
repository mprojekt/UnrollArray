package m.mprojekt.spirals.util;

public enum StartSide {
    
    Top {

        @Override
        public int[] firstStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.getRow(array, left);
        }

        @Override
        public int[] secondStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.getColumn(array, right);
        }

        @Override
        public int[] thirdStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.reverse(ArrayHandler.getRow(array, bottom));
        }

        @Override
        public int[] fourthStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.reverse(ArrayHandler.getColumn(array, left));
        }

        @Override
        public int choiceFirstParam(int width, int height) {
            return width;
        }

        @Override
        public int choiceSecoundParam(int width, int height) {
            return height;
        }

        @Override
        public int choiceThirdParam(int width, int height) {
            return width;
        }

        @Override
        public int choiceFourthParam(int width, int height) {
            return height;
        }
    }, Right {

        @Override
        public int[] firstStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.getColumn(array, right);
        }

        @Override
        public int[] secondStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.reverse(ArrayHandler.getRow(array, bottom));
        }

        @Override
        public int[] thirdStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.reverse(ArrayHandler.getColumn(array, left));
        }

        @Override
        public int[] fourthStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.getRow(array, left);
        }

        @Override
        public int choiceFirstParam(int width, int height) {
            return height;
        }

        @Override
        public int choiceSecoundParam(int width, int height) {
            return width;
        }

        @Override
        public int choiceThirdParam(int width, int height) {
            return height;
        }

        @Override
        public int choiceFourthParam(int width, int height) {
            return width;
        }
    }, Bottom {

        @Override
        public int[] firstStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.reverse(ArrayHandler.getRow(array, bottom));
        }

        @Override
        public int[] secondStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.reverse(ArrayHandler.getColumn(array, left));
        }

        @Override
        public int[] thirdStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.getRow(array, left);
        }

        @Override
        public int[] fourthStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.getColumn(array, right);
        }

        @Override
        public int choiceFirstParam(int width, int height) {
            return width;
        }

        @Override
        public int choiceSecoundParam(int width, int height) {
            return height;
        }

        @Override
        public int choiceThirdParam(int width, int height) {
            return width;
        }

        @Override
        public int choiceFourthParam(int width, int height) {
            return height;
        }
    }, Left {

        @Override
        public int[] firstStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.reverse(ArrayHandler.getColumn(array, left));
        }

        @Override
        public int[] secondStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.getRow(array, left);
        }

        @Override
        public int[] thirdStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.getColumn(array, right);
        }

        @Override
        public int[] fourthStep(int[][] array, int left, int right, int bottom) {
            return ArrayHandler.reverse(ArrayHandler.getRow(array, bottom));
        }

        @Override
        public int choiceFirstParam(int width, int height) {
            return height;
        }

        @Override
        public int choiceSecoundParam(int width, int height) {
            return width;
        }

        @Override
        public int choiceThirdParam(int width, int height) {
            return height;
        }

        @Override
        public int choiceFourthParam(int width, int height) {
            return width;
        }
    };
    
    public abstract int[] firstStep(int[][] array, int left, int right, int bottom);
    public abstract int[] secondStep(int[][] array, int left, int right, int bottom);
    public abstract int[] thirdStep(int[][] array, int left, int right, int bottom);
    public abstract int[] fourthStep(int[][] array, int left, int right, int bottom);    
    
    public abstract int choiceFirstParam(int width, int height);
    public abstract int choiceSecoundParam(int width, int height);
    public abstract int choiceThirdParam(int width, int height);
    public abstract int choiceFourthParam(int width, int height);
    
}

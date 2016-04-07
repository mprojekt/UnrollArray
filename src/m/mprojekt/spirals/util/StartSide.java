package m.mprojekt.spirals.util;

public enum StartSide {
    
    Top {

        @Override
        public int[] firstStep(int[][] array, SpiralStan stan) {
            return ArrayHandler.getRow(array, stan.getLeft());
        }

        @Override
        public int[] secondStep(int[][] array, SpiralStan stan) {
            return ArrayHandler.getColumn(array, stan.getRight());
        }

        @Override
        public int[] thirdStep(int[][] array, SpiralStan stan) {
            return ArrayHandler.reverse(ArrayHandler.getRow(array, stan.getBottom()));
        }

        @Override
        public int[] fourthStep(int[][] array, SpiralStan stan) {
            return ArrayHandler.reverse(ArrayHandler.getColumn(array, stan.getLeft()));
        }

        @Override
        public int choiceFirstParam(SpiralStan stan) {
            return stan.getWidth();
        }

        @Override
        public int choiceSecoundParam(SpiralStan stan) {
            return stan.getHeight();
        }

        @Override
        public int choiceThirdParam(SpiralStan stan) {
            return stan.getWidth();
        }

        @Override
        public int choiceFourthParam(SpiralStan stan) {
            return stan.getHeight();
        }
    }, Right {

        @Override
        public int[] firstStep(int[][] array, SpiralStan stan) {
            return ArrayHandler.getColumn(array, stan.getRight());
        }

        @Override
        public int[] secondStep(int[][] array, SpiralStan stan) {
            return ArrayHandler.reverse(ArrayHandler.getRow(array, stan.getBottom()));
        }

        @Override
        public int[] thirdStep(int[][] array, SpiralStan stan) {
            return ArrayHandler.reverse(ArrayHandler.getColumn(array, stan.getLeft()));
        }

        @Override
        public int[] fourthStep(int[][] array, SpiralStan stan) {
            return ArrayHandler.getRow(array, stan.getLeft());
        }

        @Override
        public int choiceFirstParam(SpiralStan stan) {
            return stan.getHeight();
        }

        @Override
        public int choiceSecoundParam(SpiralStan stan) {
            return stan.getWidth();
        }

        @Override
        public int choiceThirdParam(SpiralStan stan) {
            return stan.getHeight();
        }

        @Override
        public int choiceFourthParam(SpiralStan stan) {
            return stan.getWidth();
        }
    }, Bottom {

        @Override
        public int[] firstStep(int[][] array, SpiralStan stan) {
            return ArrayHandler.reverse(ArrayHandler.getRow(array, stan.getBottom()));
        }

        @Override
        public int[] secondStep(int[][] array, SpiralStan stan) {
            return ArrayHandler.reverse(ArrayHandler.getColumn(array, stan.getLeft()));
        }

        @Override
        public int[] thirdStep(int[][] array, SpiralStan stan) {
            return ArrayHandler.getRow(array, stan.getLeft());
        }

        @Override
        public int[] fourthStep(int[][] array, SpiralStan stan) {
            return ArrayHandler.getColumn(array, stan.getRight());
        }

        @Override
        public int choiceFirstParam(SpiralStan stan) {
            return stan.getWidth();
        }

        @Override
        public int choiceSecoundParam(SpiralStan stan) {
            return stan.getHeight();
        }

        @Override
        public int choiceThirdParam(SpiralStan stan) {
            return stan.getWidth();
        }

        @Override
        public int choiceFourthParam(SpiralStan stan) {
            return stan.getHeight();
        }
    }, Left {

        @Override
        public int[] firstStep(int[][] array, SpiralStan stan) {
            return ArrayHandler.reverse(ArrayHandler.getColumn(array, stan.getLeft()));
        }

        @Override
        public int[] secondStep(int[][] array, SpiralStan stan) {
            return ArrayHandler.getRow(array, stan.getLeft());
        }

        @Override
        public int[] thirdStep(int[][] array, SpiralStan stan) {
            return ArrayHandler.getColumn(array, stan.getRight());
        }

        @Override
        public int[] fourthStep(int[][] array, SpiralStan stan) {
            return ArrayHandler.reverse(ArrayHandler.getRow(array, stan.getBottom()));
        }

        @Override
        public int choiceFirstParam(SpiralStan stan) {
            return stan.getHeight();
        }

        @Override
        public int choiceSecoundParam(SpiralStan stan) {
            return stan.getWidth();
        }

        @Override
        public int choiceThirdParam(SpiralStan stan) {
            return stan.getHeight();
        }

        @Override
        public int choiceFourthParam(SpiralStan stan) {
            return stan.getWidth();
        }
    };
    
    public abstract int[] firstStep(int[][] array, SpiralStan stan);
    public abstract int[] secondStep(int[][] array, SpiralStan stan);
    public abstract int[] thirdStep(int[][] array, SpiralStan stan);
    public abstract int[] fourthStep(int[][] array, SpiralStan stan);    
    
    public abstract int choiceFirstParam(SpiralStan stan);
    public abstract int choiceSecoundParam(SpiralStan stan);
    public abstract int choiceThirdParam(SpiralStan stan);
    public abstract int choiceFourthParam(SpiralStan stan);
    
}

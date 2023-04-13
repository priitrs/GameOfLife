import java.util.Arrays;

public class GameOfLife {

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
        };
        int counter = 0;

        while (counter < 10) {
            input = getNextState(input);
            for (int[] ints : input) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println();
            counter++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }

    public static int[][] getNextState(int[][] input) {
        int[][] nextState = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                int sum = findSum(input, i, j);
                nextState[i][j] = ((sum == 4 && input[i][j] == 1) || sum == 3) ? 1 : 0;
            }
        }
        return nextState;
    }

    private static int findSum(int[][] input, int i, int j) {
        int sum = 0;
        for (int m = i - 1; m < i + 2; m++) {
            for (int k = j - 1; k < j + 2; k++) {
                try {
                    sum += input[m][k];
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }
        return sum;
    }
}

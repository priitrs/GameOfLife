import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {
    @Test
    void getNextState_allDeadCells() {
        int[][] input = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        };
        int[][] nextState = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        };

        assertArrayEquals(nextState, GameOfLife.getNextState(input));
    }

    @Test
    void getNextState_someCellsAreAlive() {
        int[][] input = new int[][]{
                {1, 0, 0},
                {0, 1, 1},
                {0, 1, 1},
        };
        int[][] nextState = new int[][]{
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 1},
        };

        assertArrayEquals(nextState, GameOfLife.getNextState(input));
    }

    @Test
    void getNextState_bigOne() {
        int[][] input = new int[][]{
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };
        int[][] nextState = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
        };

        assertArrayEquals(nextState, GameOfLife.getNextState(input));
    }
}
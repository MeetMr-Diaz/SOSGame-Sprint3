package production;

import java.util.ArrayList;
public class SOSGameGetters {
    public enum Cell {EMPTY, S, O;}
    public enum GameModeType {Simple, General;}
    public enum GameState {PLAYING, DRAW, BLUE_WON, RED_WON;}
    public int TOTAL_ROWS;
    public int TOTAL_COLUMNS;
    public Cell[][] grid;
    public int size;
    public char turn;
    public int x;
    public int y;
    public int blueScore;
    public int redScore;
    protected ArrayList<ArrayList<Integer>> sosInfo;
    protected GameModeType currentGameModeType;
    protected GameState currentGameState;
    public SOSGameGetters(int size) {
        grid = new Cell[size][size];
        currentGameModeType = GameModeType.Simple;
        this.size = size;
    }
    public int sizeBoard() {

        return TOTAL_COLUMNS * TOTAL_ROWS;
    }
    public Object getGrid() {
        return grid;
    }
    public void setCurrentGameType(GameModeType currentGameModeType) {
        this.currentGameModeType = currentGameModeType;
    }
    public void initGame() {

        grid = new Cell[size][size];

        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                grid[row][col] = Cell.EMPTY;
            }
        }
        currentGameState = GameState.PLAYING;
        turn = 'S';
        blueScore = redScore = 0;
        sosInfo = new ArrayList<>();
    }
    public Cell getCell(int row, int column) {
        if (row >= 0 && row < size && column >= 0 && column < size) {
            return grid[row][column];
        } else {
            return null;
        }
    }
    public char getTurn() {
        return turn;
    }
    public void resetGame() {
        initGame();
    }
    public int getTotalRows() {
        return TOTAL_ROWS;
    }
    public int getTotalColumns() {
        return TOTAL_COLUMNS;
    }
    public GameModeType getCurrentGameType() {

        return currentGameModeType;
    }
    public ArrayList<ArrayList<Integer>> getSosInfo() {
        return sosInfo;
    }
    public ArrayList<Integer> checkSOS() {
        ArrayList<Integer> scoring = new ArrayList<Integer>();
        if (turn == 'B')
            scoring.add(0);
        else
            scoring.add(1);
        boolean isChanged = false;
        if (grid[x][y] == Cell.O) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (x - i < 0 || x - i >= TOTAL_ROWS || x + i < 0 || x + i >= TOTAL_ROWS || y - j < 0
                            || y - j >= TOTAL_COLUMNS || y + j < 0 || y + j >= TOTAL_COLUMNS)
                        continue;
                    if (grid[x - i][y - j] == Cell.S && grid[x + i][y + j] == Cell.S) {
                        scoring.add(x - i);
                        scoring.add(y - j);
                        scoring.add(x + i);
                        scoring.add(y + j);
                        if (turn == 'B')
                            blueScore++;
                        else
                            redScore++;

                        isChanged = true;


                    }
                }
            }
        } else {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (x + 2 * i < 0 || x + 2 * i >= TOTAL_ROWS || y + 2 * j < 0 || y + 2 * j >= TOTAL_COLUMNS)
                        continue;
                    if (grid[x + 2 * i][y + 2 * j] == Cell.S && grid[x + i][y + j] == Cell.O) {
                        scoring.add(x);
                        scoring.add(y);
                        scoring.add(x + 2 * i);
                        scoring.add(y + 2 * j);
                        if (turn == 'B')
                            blueScore++;

                        else
                            redScore++;
                        redScore-=1;
                        isChanged = true;
                    }
                }
            }
        }
        if (isChanged)
            turn = (turn == 'B') ? 'R' : 'B';
        return scoring;
    }
    public GameState getGameState() {
        return currentGameState;
    }
}

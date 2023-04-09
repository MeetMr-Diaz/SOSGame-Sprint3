package production;
public class SOSGame extends SOSGameGetters {
    public SOSGame(int n){
        super( n);
        TOTAL_ROWS = TOTAL_COLUMNS = n;
        initGame();
    }
    public void makeMove(int row, int column, int type) {
        if (row >= 0 && row < TOTAL_ROWS && column >= 0 && column < TOTAL_COLUMNS && grid[row][column] == Cell.EMPTY) {
            x = row;
            y = column;
            if(type == 1){
                grid[row][column] = Cell.S;
                turn = 'B';
            }else {
                grid[row][column] = Cell.O;
                turn = 'R';
            }
            sosInfo.add(checkSOS());
            updateGameState();
        }
    }
    private void updateGameState() {

//        System.out.println("red score "+redScore);
//        System.out.println("blue score "+blueScore);

        if (currentGameModeType == GameModeType.Simple||currentGameModeType == GameModeType.General){

            int x = checkWinner();
            System.out.println("what x is " + x); // debugging value coming in
            if (x >= 0) {
                if (x == 2)
                    currentGameState = GameState.BLUE_WON;
                else if (x == 1)
                    currentGameState = GameState.RED_WON;
                else if (x==3) {
                    currentGameState = GameState.DRAW;
                }

            }else if (isFull())
                currentGameState = GameState.DRAW;
        }
    }
   public boolean isFull() {
       for (int row = 0; row < size; row++) {
           for (int col = 0; col < size; col++) {
               if (grid[row][col] == Cell.EMPTY) {
                   return false;
               }
           }
       }
       return true;
   }
    public int checkWinner() {

        if (currentGameModeType == GameModeType.Simple) {
            System.out.println(blueScore);
            System.out.println(redScore);
            if (blueScore > 0){
                return 2; //blue wins
            }else if (redScore > blueScore){
                return 1; // red wins
            }else if(sosInfo.isEmpty()){
                return 0; //no winner
            }else {
                return -1;
            }

        }  else {
            if (!isFull())
                return 0;
            if (blueScore > redScore)
                return 2;
            else if (blueScore < redScore)
                return 1;
            else {
                return 3;
            }
        }
    }
}

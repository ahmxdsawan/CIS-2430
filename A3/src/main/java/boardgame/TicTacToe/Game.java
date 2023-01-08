package boardgame.TicTacToe;


public class Game extends boardgame.bGame.BoardGame implements boardgame.bGame.Saveable {

    private String player = "X";
    private int numPlayer = 1;


    public Game(int wide, int high) {
        super(wide, high);
        setGrid(new TGrid(wide, high));

    }

    @Override
    public void newGame() {
        super.newGame();

    }

    @Override
    public boolean takeTurn(int across, int down, String input) {
        setValue(across, down, input);
        if (player == "X") {
            player = "O";
        } else {
            player = "X";
        }
        return true;
    }

    // numerical tictactoe
    @Override
    public boolean takeTurn(int across, int down, int input) {
        setValue(across, down, input);
        return true;
    }

    @Override
    public String getGameStateMessage() {
        return "You Won!"; // should be a message based on the state of the game
    }

    @Override
    public String getStringToSave() {
        return "This should be a csv delimited string that could be written to file";
    }

    @Override
    public void loadSavedString(String saved) {
        // here there should be code to parse the saved string into a board.
        // I would probably write a method in my KakuroBoard class that did the parsing
        // and just pass it the string/

        /*
         * must cast it to get a reference that can use Kakuro grid
         * methods
         */
        TGrid myGrid = (TGrid) getGrid();
        myGrid.parseStringIntoBoard(saved);
    }

    @Override
    public int getWinner() {
        return 1; // there is only one player in kakuro
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String newPlayer) {
        player = newPlayer;
    }

    public void setNumPlayer(int newPlayer) {
        numPlayer = newPlayer;
    }

    public int getNumPlayer() {
        return numPlayer;
    }

    public void changePlayer(){
        if(player == "X"){
            player = "O";
        }else{
            player = "X";
        }
    }

    public void changeNumPlayer(){
        if(numPlayer == 1){
            numPlayer = 2;
        }else{
            numPlayer = 1;
        }
    }

    public boolean rowCheck(int row){
        boolean match = false;
        if(!getValue(1, row).equals(" ")){
            match = getValue(1,row).equals(getValue(2, row));
            if(match){
                match = getValue(2,row).equals(getValue(3, row));
            }
        }
        return match;
    }
    
    public  boolean columnCheck(int col){
        boolean match = false;
        if(!getValue(col, 1).equals(" ")){
            match = getValue(col, 1).equals(getValue(col, 2));
            if(match){
                match = getValue(col, 2).equals(getValue(col, 3));
            }
        }
        return match;
    }
    
    public boolean diagonalCheck(){
        boolean match = false;
        if(!getValue(1, 1).equals(" ")){
            match = getValue(1, 1).equals(getValue(2, 2));
            if(match){
                match = getValue(2, 2).equals(getValue(3, 3));
            }
        } else if(!getValue(1, 3).equals(" ")){
            match = getValue(1, 3).equals(getValue(2, 2));
            if(match){
                match = getValue(2, 2).equals(getValue(3, 1));
            }
        }
    
        return match;
    }

}

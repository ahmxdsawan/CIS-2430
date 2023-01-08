package connectfour;

import java.io.IOException;


public class ConnectFour{

    private static char player = 'R';

    //main function
    public static void main(String[] args) throws IOException{

        Boolean winner = Board.getWinner();
        



        TextUI.createBoard();

        do{
            Board.makeMove(TextUI.askForTurn(player));
        }while(!winner);
    }

    //setter function to switch the player
    public static void setPlayer(){
        if (player == 'R'){
            player = 'B';
        }else{
            player = 'R';
        }
    }

    //getter function to allow other classes to use the player
    public static char getPlayer(){
        return player;
    }
}
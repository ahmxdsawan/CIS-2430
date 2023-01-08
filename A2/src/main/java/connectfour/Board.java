package connectfour;
import java.util.Scanner;
import java.io.IOException;

public class Board {
private static Scanner input = new Scanner(System.in);
private static Boolean winner = false;

//function to check if win conditions have been met
public static void isWinner(){
char[][] board = TextUI.getBoard();
char player = ConnectFour.getPlayer();
// check for 4 across
for (int row = 0; row < board.length; row++) {
for (int col = 0; col < board[0].length - 3; col++) {
if (board[row][col] == player
    && board[row][col + 1] == player && board[row][col + 2] == player
    && board[row][col + 3] == player) {
    winner = true;
        }
    }
}
// check for 4 up and down
for (int row = 0; row < board.length - 3; row++) {
for (int col = 0; col < board[0].length; col++) {
if (board[row][col] == player
    && board[row + 1][col] == player && board[row + 2][col] == player
    && board[row + 3][col] == player) {
    winner = true;
        }
    }
}
// check upward diagonal
for (int row = 3; row < board.length; row++) {
    for (int col = 0; col < board[0].length - 3; col++) {
        if (board[row][col] == player && board[row - 1][col + 1] == player
                && board[row - 2][col + 2] == player
                && board[row - 3][col + 3] == player) {
                winner = true;
            }
        }
    }
// check downward diagonal
for (int row = 0; row < board.length - 3; row++) {
     for (int col = 0; col < board[0].length - 3; col++) {
        if (board[row][col] == player && board[row + 1][col + 1] == player
            && board[row + 2][col + 2] == player && board[row + 3][col + 3] == player) {
winner = true;
}
        }
    }
}

//makes the move that the user entered and updates the board
public static void makeMove(int index) throws IOException {

int move = index - 1;
char[][] board = TextUI.getBoard();

char player = ConnectFour.getPlayer();

int count = 1;

if (!winner && count < 43) {
    while (!validate(move)) {
    System.out.print("Player " + player + ", choose a column: ");
    move = input.nextInt() - 1;
}
    for (int row = board.length - 1; row >= 0; row--) {
        if (board[row][move] == ' ') {
        board[row][move] = player;
        break;
        }
    }

    updateBoard(move);

    isWinner();

   count++;
}

if (winner) {
    TextUI.displayWinner(winner, player);
}

ConnectFour.setPlayer();
TextUI.displayBoard();


TextUI.setBoard(board);

}

//function to check if the users desired move is valid
public static boolean validate(int index) {
char[][] board = TextUI.getBoard();
// valid column
if (index < 0 || index > 7) {
    return false;
}

if (board[0][index] != '0') { 
    return false;
}

return true;
}

//function to update the board with the move that the user inputed
public static void updateBoard(int column){
    char[][] board = TextUI.getBoard();
    char player = ConnectFour.getPlayer();
    for(int i = 5; i >= 0; i--){
       if(board[i][column] == '0'){
       board[i][column] = player;
       break;
      }
   }
}

public static Boolean getWinner(){
 return winner;
}


}
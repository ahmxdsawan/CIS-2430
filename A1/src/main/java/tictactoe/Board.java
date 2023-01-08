/*
  Student Name: Ahmad Sawan
  Student ID: 1205875
  Course: CIS*2430

  I have exclusive control over this submission via my password.
  By including this header comment, I certify that:
   1) I have read and understood the policy on academic integrity.
   2) I have completed Moodle's module on academic integrity.
   3) I have achieved at least 80% on the academic integrity quiz
  I assert that this work is my own. I have appropriate acknowledged
  any and all material that I have used, be it directly quoted or
  paraphrased. Furthermore, I certify that this assignment was written
  by me in its entirety.
*/

package tictactoe;

public class Board {

    //char array to store board
    private static char[] board = {
    '0', '|', '1', '|', '2', '\n',
    '-', '+', '-', '+', '-', '\n',
    '3', '|', '4', '|', '5', '\n',
    '-', '+', '-', '+', '-', '\n',
    '6', '|', '7', '|', '8', '\n'};

    //int array to store positions
    private static int[] posToIndex = {0, 2, 4, 12, 14, 16, 24, 26, 28};

    // Function to check if the players desired postion is clear or not
    public static boolean checkBoard(int position) {
        return board[posToIndex[position]] == 'X' || board[posToIndex[position]] == 'O';
    }// checkBoard

    
    //function that prints board with a following new line
    public static void printBoard() {
        System.out.println(board);
    }//printBoard

    //function to evaluate the winner
    public static boolean winner(int depth) {

        char winner = '?';//char to store a flag that indicates a winner
        //loop that checks if a pleyer gets three X or O in a column
        for (int i = 0; i < 3; i++) {
            if (board[posToIndex[i]] == board[posToIndex[i + 3]]
                    && board[posToIndex[i + 3]] == board[posToIndex[i + 6]]) {
                winner = board[posToIndex[i]];
                break;
            }//if
        }//for
        //if statement that checks if a pleyer gets three X or O in a left to right diagonal
        if (winner == '?') {
            if (board[posToIndex[0]] == board[posToIndex[4]] && board[posToIndex[4]] == board[posToIndex[8]]) {
                winner = board[posToIndex[0]];
            }//if
            //if statement that checks if a pleyer gets three X or O in a right to left diagonal
            if (board[posToIndex[2]] == board[posToIndex[4]] && board[posToIndex[4]] == board[posToIndex[6]]) {
                winner = board[posToIndex[2]];
            }//if
        }//if

        //loop that checks if a player gets three X or O in a row
        if (winner == '?') {
            for (int i = 0; i <= 6; i += 3) {
                if (board[posToIndex[i]] == board[posToIndex[i + 1]]
                        && board[posToIndex[i + 1]] == board[posToIndex[i + 2]]) {
                    winner = board[posToIndex[i]];
                    break;
                }//if
            }//for
        }//if

        //if statement to check if all spaces are full indicating a tie
        if (depth == 9) {
            System.out.println("The Game was a Tie!");
            System.exit(0);
        } else if (winner != '?') { //else statement to print out the winner
            System.out.println("The winner is " + winner);
            System.exit(0);
        }//else
        return true;
    }//winner

    //function to get the current board
    public static char[] getBoard(){
        return board;
    }//getBoard

    //function to set the board to a new board
    public static void setBoard(char[] newBoard){
        board = newBoard;
    }//setBoard

    //function to get the index from posToIndex array
    public static int[] getIndex(){
        return posToIndex;
    }//getIndex

}//class

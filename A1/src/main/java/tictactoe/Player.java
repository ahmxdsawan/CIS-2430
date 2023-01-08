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

public class Player {

  private static char playerTurn = 'X';//char to indicate which players turn it is set for default as X

  // Function to flip player turns
  public static char setTurn(char turn) {
    if (turn == 'X') {
      turn = 'O';
    } else {
      turn = 'X';
    } // else
    return turn;
  }// setTurn

  //function to get which players turn it is
  public static char getTurn(){
    return playerTurn;
  }//getTurn
}// Player

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
import java.util.Scanner;

public class Runner {

  //Initializing a scanner variable called input to recieve user input
  private static Scanner input = new Scanner(System.in); public static void main(String[] args) {
    //char variable to initialize playerTurn to the current players turn from the player class
    char playerTurn = Player.getTurn();
    int[] index = Board.getIndex();//int array that stores the current index from the board class
    char[] board = Board.getBoard();//char array that stores the board from the board class
    int depth = 0;//int variable to act as a counter for the number of turns taken
    int position;//int variable to store the desired position inputed by the user

    Board.printBoard();//function from the board class to print the board
    System.out.println("Turn = X");//prints the begining turn as default X
    //while loop that keeps running as long as there is no winner
    while (Board.winner(depth)) {
      //print function that prompts the user to input a value between 0 and 8
      System.out.print("Enter Position between 0 and 8:\n");
      position = input.nextInt();//stores the users int input to position
      //if statement to check if the users input is within the bounds
      if (position > 8 || position < 0) {
        System.out.println("Error - Out of Bounds");//error message if out of bounds occurs
      } else {
        //if statement to check if the users desired position is empty or not
        if (!Board.checkBoard(position)) {
          depth++;//increments the depth variable
          board[index[position]] = playerTurn;//setting the users input onto the board
          System.out.println(board);//prints out the updated board
          playerTurn = Player.setTurn(playerTurn);//switches the turn to the next player
          //if statement to check if all spaces are empty or not
          if (depth != 9) {
            System.out.println("Turn = " + playerTurn);//print function to indicate which players turn it is
          }//if
        } else {
          //while loop that keeps on running as long as the users desired position is filled
          while (Board.checkBoard(position)) {
            //print function to indicate an error that the desired position is already filled
            System.out.println("illegal move, Please enter another value");
            position = input.nextInt();//updates position with the users new input
          }//while
          depth++;//incrementing depth
          board[index[position]] = playerTurn;//updating the board the users new input
          System.out.println(board);//prints out the updated board
          playerTurn = Player.setTurn(playerTurn);//switches turns to next player
          //if statement to check if all spaces are empty or not
          if (depth != 9) {
            System.out.println("Turn = " + playerTurn);//print function to indicate which players turn it is
          }//if
        }//else
      }//else
    }//while
    playerTurn = Player.setTurn(playerTurn);//switches turns to next player
    System.out.println("Winner = " + playerTurn);//prints out the winner
  }//main
}//Runner

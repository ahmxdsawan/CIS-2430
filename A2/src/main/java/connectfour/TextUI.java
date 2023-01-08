package connectfour;

import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextUI {

private static Scanner input = new Scanner(System.in);

private static char[][] board = new char[6][7];

//function to ask if the user wants to load a previous game or start a new one
public static Boolean askForBoard() {
System.out.println("Do you want to load in a existing game (enter y or n)?");
char temp = input.next().charAt(0);

while (temp != 'Y' || temp != 'y' || temp != 'N' || temp != 'n') {
if (temp == 'y' || temp == 'Y') {
return true;
} else if (temp == 'n' || temp == 'N') {
return false;
} else {
System.out.println("Incorrect input!");
System.out.println("Do you want to load in a existing game (enter y or n)?");
temp = input.next().charAt(0);
}
}

return true;
}

//function to ask for the players desired move
public static int askForTurn(char player) {
System.out.println("Player " + player + " please enter a column.");
int column = input.nextInt();

return column;
}

//function to create the board
public static void createBoard() throws IOException {

Boolean ask = askForBoard();

for (int i = 0; i < 6; i++) {
for (int j = 0; j < 7; j++) {
board[i][j] = '0';
}
}

if (ask) {
System.out.println("What is the name of the file?");
File file = new File(input.nextLine());

if (file.exists()) {
BufferedReader bf = new BufferedReader(new FileReader(file));

String line = bf.readLine();

bf.close();
}
} else {

// initialize array

System.out.println();
System.out.println(" 1 2 3 4 5 6 7");
System.out.println("---------------");
for (int row = 0; row < board.length; row++) {
System.out.print("|");
for (int col = 0; col < board[0].length; col++) {
System.out.print(board[row][col]);
System.out.print("|");
}
System.out.println();
System.out.println("---------------");
}
System.out.println(" 1 2 3 4 5 6 7");
System.out.println();
}
}

//function to display the winner
public static void displayWinner(Boolean winner, char player) {
if (winner) {
    displayBoard();
    if (player == 'R') {
    System.out.println("Red won");
    System.exit(1);
    } else if(player == 'B'){
    System.out.println("Blue won");
    System.exit(1);
    }
    } else {
    System.out.println("Tie game");
    System.exit(1);
   }
}

//function to get board so it can be used by other classes
public static char[][] getBoard() {
return board;
}

//function to set board
public static void setBoard(char[][] newBoard) {
board = newBoard;
}

//function to display board
public static void displayBoard(){
    System.out.println(" 1 2 3 4 5 6 7");
    System.out.println("---------------");
    for (int row = 0; row < board.length; row++) {
       System.out.print("|");
       for (int col = 0; col < board[0].length; col++) {
           System.out.print(board[row][col]);
           System.out.print("|");
        }
    System.out.println();
    System.out.println("---------------");
    }
    System.out.println(" 1 2 3 4 5 6 7");
    System.out.println();
  }

}
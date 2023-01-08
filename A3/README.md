# MiniGames - TicTacToe & Numerical TicTacToe

In this minigame, there are two games. One is TicTacToe and the other is Numerical TicTacToe. TicTacToe allows two users to play on a 3x3 punnet square with player 1 assigned X and player 2 assigned O. The player to get 3 X's or O's diagonally, horizontaly, or verticaly in a row wins. Numerical TicTacToe which has has a 3 x 3 punnet square with player 1 assigned with 0-9 even numbers and player 2 0-9 odd numbers. Who ever add's up to 15 either horizontaly, verticaly, or diagonally win!

## Description


Upon starting the program, you are prompted an application that allows the user to choose between TicTacToe and Numerical TicTacToe. There is also a menu that has a submenu that contains the buttons to load and/or save files into or from the game. If the player choose **TicTacToe** then the window transitions into a 3 x 3 punnet square that allows two players to play the game. X always starts first, to play this game, simply click on this tile you which to place your choice and then it switches to the other player , O, to play next. The user is also prompted with a **New Game** button that clears the board and allows for a fresh game and a **Quit** button that exists from TicTacToe to the main menu. On the side of the game, the user can always switch between **TicTacToe** and **Numerical TicTacToe**. If the user clicks **Numerical TicTacToe** then a similar 3 x 3 punnet square appears. Player 1 always starts first, to play a move, the user must click their desired move and a dialog menu appears prompting the user to input an even number between "0-9". **TicTacToe** handles invalid moves such as if a player already has a sqaure assigned with either an X or an O, then the program wont allow the user to make a move there.

### Dependencies

* Inorder to run this program. Make sure you have the latest version of **Gradle** installed. 
* Make sure that you have Java install on your local machine
* Make sure you install Java SDK

### Executing program

* Make sure you are in the A3 repository.
* With gradle opened, type in "*gradle clean build*"
* Then open your local command prompt or terminal and type in "*java -cp build/classes/java/main boardgame.game.GameUI*"

* Output :- 
BUILD SUCCESSFUL in Xs
4 actionable tasks: 4 executed

## Limitations

* Program does not save/load files given from the user.
* Program cannot run TextUI to the command prompt.
* Numerical TicTacToe does not have proper win conditions.

## Author Information

* **Name :** Ahmad Sawan
* **Email :** asawan@uoguelph.ca
* **Student ID :** 1205875


## Acknowledgments

I shall make some refrences to Prof Judi's code given in the examplegui project.



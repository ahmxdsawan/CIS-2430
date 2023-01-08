# Connect Four

Connect-Four is a tic-tac-toe-like two-player game in which players alternately place pieces on a vertical board 7 columns across and 6 rows high.

## Description

Connect-Four that is played with 2 players, R for red, and B for blue. Players take turns inputing which column they wish to drop their peice in, for exmaple, 4 for colomn 4. This game is played on the same keyboard aswell .There are four win-cases inorder to win the game: -

    1. 4 R's or B's diagonaly to the left
    2. 4 R's or B's diagonaly to the right
    3. 4 R's or B's horizontly
    4. 4 R's or B's verticly either up or down.


### Dependencies

* Libraries used :- 
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

* Packages:- 
connectfour

* Gradle is used to run this program

### Executing program

* Make sure you have imported all the files correctly in their corresponding locations
* cd into A2

```
* gradle build
* gradle run
* java -cp build/classes/java/main connectfour.ConnectFour
```

Enjoy playing!

* Expected output should look like this :-

Do you want to load in a existing game (enter y or n)?
n

 1 2 3 4 5 6 7
---------------
|0|0|0|0|0|0|0|
---------------
|0|0|0|0|0|0|0|
---------------
|0|0|0|0|0|0|0|
---------------
|0|0|0|0|0|0|0|
---------------
|0|0|0|0|0|0|0|
---------------
|0|0|0|0|0|0|0|
---------------
 1 2 3 4 5 6 7

Player R please enter a column.
>

## Limitations

This program is missing the feature to load and save games that have been paused mid-way. 

## Author Information

* Name : Ahmad Sawan
* Student ID : 1205875
* email : asawan@uoguelph.ca




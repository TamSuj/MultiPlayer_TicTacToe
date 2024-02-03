# Multi-Player Tic-Tac-Toe

Welcome to the Multi-Player Tic-Tac-Toe program! This program allows multiple users to play Tic-Tac-Toe simultaneously for up to 10 players. It includes features to ensure valid user inputs, checks for winners based on customizable winning conditions (winnerStreak), and ends the game when a winner is detected.

## How to Play

1. **Setup**: Choose the number of players (3 to 10) and the winning streak (3 to the number of players + 1) to win the game.
2. **Gameplay**: Players take turns entering their moves by entering the row and column they want to mark with the pre-determined and distinct symbol.
3. **Winning Condition**: The game ends when a player achieves a specified number of consecutive marks (depending on inputted winning streak) in a row, column, diagonal or the board is full with no winner.

## Features

- **Multi-Player Support**: Allows multiple players (up to 10) to participate in the game concurrently.
- **Flexible Winning Condition**: Users can specify the number of consecutive marks required to win.
- **Input Validation**: Ensures that user inputs for row and column are within the bounds of the board and not already taken.
- **Game Logic**: Includes a `GameLogic` class that checks for diagonal, horizontal, and vertical matches to determine the winner.

## Usage

To start the game, simply run the program and follow the prompts to set up the game parameters and make moves.

## Contributors

- [Gayvalin Tammy Sujaritchai](https://www.linkedin.com/in/tammy-suj/)

## Notes

- Some of the concepts used in the program (ex: recursion and exception handling) has not been covered in the course. The program was developed with the knowledge and skills learned from CS 8 class (Data Structure) and additional resources.

## Example

```java
Enter the number of players (3-10): 6
Enter the number of winning piece (3-7): 5
Board: 
   1   2   3   4   5   6   7
  ----------------------------
1  _ | _ | _ | _ | _ | _ | _
  ----------------------------
2  _ | _ | _ | _ | _ | _ | _
  ----------------------------
3  _ | _ | _ | _ | _ | _ | _
  ----------------------------
4  _ | _ | _ | _ | _ | _ | _
  ----------------------------
5  _ | _ | _ | _ | _ | _ | _
  ----------------------------
6  _ | _ | _ | _ | _ | _ | _
  ----------------------------
7  _ | _ | _ | _ | _ | _ | _
  ----------------------------

Player 1's turn (X)
Enter the number of row: 1
Enter the number of column: 1

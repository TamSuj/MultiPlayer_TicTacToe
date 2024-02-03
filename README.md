# Multi-Player Tic Tac Toe

Welcome to the Multi-Player Tic Tac Toe program! This program allows multiple users to play Tic Tac Toe simultaneously with support for up to 10 players. It includes features to ensure valid user inputs, checks for winners based on customizable winning conditions, and ends the game when a winner is determined.

## How to Play

1. **Setup**: Choose the number of players (2 to 10) and the dimension of the Tic Tac Toe board (rows x columns).
2. **Gameplay**: Players take turns entering their moves by specifying the row and column they want to mark with their symbol.
3. **Winning Condition**: The game ends when a player achieves a specified number of consecutive marks (traditionally 3, but customizable up to the number of players + 1) in a row, column, or diagonal.

## Features

- **Multi-Player Support**: Allows multiple players to participate in the game concurrently.
- **Customizable Board Size**: Users can choose the dimensions of the Tic Tac Toe board.
- **Flexible Winning Condition**: Users can specify the number of consecutive marks required to win.
- **Input Validation**: Ensures that user inputs for row and column are within the bounds of the board and not already taken.
- **Game Logic**: Includes a `GameLogic` class that checks for diagonal, horizontal, and vertical matches to determine the winner.

## Usage

To start the game, simply run the program and follow the prompts to set up the game parameters and make moves during gameplay.

## GameLogic Class

The `GameLogic` class provides functionality to check for winning conditions in the Tic Tac Toe game. Here's an overview of its methods:

- `__init__(board)`: Initializes the `GameLogic` object with the Tic Tac Toe board.
- `check_winner(row, col, player, consecutive)`: Checks if the latest move made by a player results in a win based on the specified number of consecutive marks required.
- `check_horizontal(row, player, consecutive)`: Checks for horizontal matches.
- `check_vertical(col, player, consecutive)`: Checks for vertical matches.
- `check_diagonal(player, consecutive)`: Checks for diagonal matches.

## Example

```python
# Initialize the Tic Tac Toe game with 3 players and a 3x3 board
game = TicTacToe(3, 3)

# Set the winning condition to 4 consecutive marks
game.set_winning_condition(4)

# Start the game
game.start_game()

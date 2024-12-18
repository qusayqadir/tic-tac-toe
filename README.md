# Tic-Tac-Toe Game (SFWRENG 2OP3: Assignment 06)

---

## Features

- **Interactive Game Modes**:
  - Human vs. Human ( 3 x 3)
  - Human vs. Computer ( 3 x 3 )
  - Human vs. Human ( N x N Grid 3 <= N <= 20)
  - Human vs. Computer ( N x N Grid 3 <= N <= 20)
  - Computer vs. Computer ( 3x3 ONLY )

- **Design**:
  - **Core Classes**:
    - `Game`: Manages game flow and win/draw detection
    - `Player`: Base class for human and computer players
    - `Board`: Handles grid display and marker placement
    - `CustomBoard`: Handles NxN Game Board + new win conditons where #inARow to win < N ( boardSize) 
    - `CustomGame`: Handles the new gameMode with custom board size, and handle the new scenarios

---

## How to Run the Project
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/tic-tac-toe
   cd tic-tac-toe
2. Inside tic-tac-toe: 
   ```bash 
   javac -d bin1 GameMode1/*.java
   java -cp bin1 Game

   javac -d bin2 GameMode2/*java
   java -cp bin2 CustomGame

  

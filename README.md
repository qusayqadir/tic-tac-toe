# Tic-Tac-Toe Game (SFWRENG 2OP3: Assignment 06)

This repository contains a Java-based implementation of the classic **Tic-Tac-Toe** game. 
---

## Features

- **Interactive Game Modes**:
  - Human vs. Human
  - Human vs. Computer
  - Computer vs. Computer
- **Computer Player Strategies**:
  - Random move strategy (base implementation)
  - Smarter move strategy (optional bonus)
- **Dynamic Grid Scaling**:
  - Upgrade to N x N board (3 ≤ N ≤ 20)
  - Customizable winning condition with M markers in a straight line
- **Game Features**:
  - Turn-based play
  - Win/draw detection
  - Restart functionality
- **Object-Oriented Design**:
  - Encapsulation and information hiding
  - Polymorphism for human and computer players
  - Adherence to OOP principles like the single-responsibility principle and open-closed principle

---

## Technical Highlights

- **Language**: Java
- **Build Tool**: Maven
- **Design**:
  - **Core Classes**:
    - `Game`: Manages game flow and win/draw detection
    - `Player`: Base class for human and computer players
    - `Board`: Handles grid display and marker placement
  - **Dynamic Dispatch**:
    - Allows seamless switching between human and computer players
  - **Scalability**:
    - Code refactored for modularity, supporting N x N grid and custom M markers win conditions
- **Principles Applied**:
  - **Encapsulation**: Protects internal state of classes
  - **Open-Closed Principle**: Code can be extended (e.g., smarter AI) without modifying base classes
  - **Single-Responsibility Principle**: Each class has a focused responsibility

---

## How to Run the Project

### Prerequisites
- **Java**: OpenJDK 21 or later
- **Build Tool**: Maven

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/tic-tac-toe
   cd tic-tac-toe

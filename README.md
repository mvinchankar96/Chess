# Chess Piece Movement Simulator (Java OOP)

This project is a console-based chess simulator that calculates all possible legal moves for different chess pieces (`Pawn`, `King`, `Queen`) on an 8x8 chessboard. It follows **Object-Oriented Programming (OOP)** principles using Java.

---

## Features

- Parse and validate chess board positions (e.g., `D4`)
- Calculate valid moves for:
  - Pawn
  - King
  - Queen
- Algebraic notation conversion (e.g., from `(3, 3)` to `D4`)
- Exception handling for invalid moves and positions
- JUnit test coverage for all core functionalities

---

## Project Structure

```
com.chess
├── ChessPositionCalculator.java
├── application
│   └── Main.java
└── domain
    ├── ChessBoard.java
    ├── ChessPiece.java
    ├── ChessPieceRegistry.java
    ├── DirectionalPiece.java
    ├── King.java
    ├── Queen.java
    ├── Pawn.java
    ├── Position.java
    ├── Positions.java
```

---

## How It Works

### `ChessBoard`
- Validates file/rank boundaries
- Parses algebraic notation (like `E5`) to internal coordinates
- Converts internal positions back to chess notation

### `Position`
- Record representing a coordinate (file, rank)

### `ChessPiece` (interface)
- Contract for all chess pieces to implement their move logic

### `DirectionalPiece` (abstract class)
- Provides reusable movement logic for pieces like Queen and King

### Individual Pieces
- `Pawn`: Moves one step forward
- `King`: One step in any direction
- `Queen`: Unlimited steps in all directions

### `ChessPositionCalculator`
- Central class to combine board, piece, and starting position to calculate valid moves

---

## Running the Application

To run the console application:

```bash
javac com/chess/application/Main.java
java com.chess.application.Main
```

When prompted, enter input in the format:

```
King, D5
```

Expected output:

```
Output: C4, C5, C6, D4, D6, E4, E5, E6
```

Another example:

```
Input: Queen, E4
Output: A4, B4, C4, D4, F4, G4, H4, E1, E2, E3, E5, E6, E7, E8, A8, B7, C6, D5, F3, G2, H1, B1, C2, D3, F5, G6, H7
```

---

## Dependencies

- Java 17+
- JUnit 5 (for unit testing)

---

## Running Tests

To run the tests:

```bash
./gradlew test
```

JUnit test cases cover:
- All chess pieces' movement logic
- Boundary and invalid input handling
- Notation conversion

---

## Flow Diagram

```
           +------------------------+
           |   ChessBoard           |
           |------------------------|
           | - parsePosition()      |
           | - isWithinBounds()     |
           | - toChessNotation()    |
           +-----------+------------+
                       |
                       v
              +--------+--------+
              |     Position     |
              +--------+--------+
                       |
                       v
              +--------+--------+
              |    ChessPiece    |
              |  (interface)     |
              +--------+--------+
                       ^
                       |
        +--------------+--------------+
        |                             |
+---------------+        +---------------------+
|     Pawn      |        |   DirectionalPiece  |
|  (Single move)|        | (abstract base for  |
|               |        |  King and Queen)    |
+---------------+        +---------------------+
                                 ^
                       +---------+---------+
                       |                   |
              +--------+--------+  +--------+--------+
              |      King       |  |      Queen      |
              +-----------------+  +-----------------+
```

---

## Future Enhancements

- Add Rook, Bishop, Knight
- Capture move logic

---

## Author

Made by Mangesh Vinchankar

---
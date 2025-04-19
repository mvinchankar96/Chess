package com.chess;

import com.chess.domain.ChessBoard;
import com.chess.domain.King;
import com.chess.domain.Pawn;
import com.chess.domain.Positions;
import com.chess.exception.InvalidPositionException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChessPositionCalculatorTest {

    private final ChessBoard board = new ChessBoard();

    @Test
    void shouldCalculatePossibleMovesGivenPositionForPawn() {
        ChessPositionCalculator calculator = new ChessPositionCalculator();
        Positions possibleMoves = calculator.calculate(new Pawn(), "H7", board);
        assertEquals(List.of("H8"), board.toChessNotation(possibleMoves));
    }

    @Test
    void shouldCalculatePossibleMovesGivenPositionForKing() {
        ChessPositionCalculator calculator = new ChessPositionCalculator();
        Positions possibleMoves = calculator.calculate(new King(), "D5", board);
        assertEquals(List.of("C4", "C5", "C6", "D4", "D6", "E4", "E5", "E6"), board.toChessNotation(possibleMoves));
    }

    @Test
    void shouldThrowExceptionGivenInvalidPositionToCalculateMoves() {
        ChessPositionCalculator calculator = new ChessPositionCalculator();
        InvalidPositionException exception = assertThrows(InvalidPositionException.class,
                () -> calculator.calculate(new Pawn(), "H9", board));
        assertEquals("Rank '9' is out of bounds. Only ranks 1 to 8 are supported.", exception.getMessage());
    }
}
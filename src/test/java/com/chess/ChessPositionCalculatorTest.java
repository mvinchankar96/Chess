package com.chess;

import com.chess.domain.King;
import com.chess.domain.Pawn;
import com.chess.domain.Position;
import com.chess.domain.Positions;
import com.chess.exception.InvalidPositionException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChessPositionCalculatorTest {

    @Test
    void shouldCalculatePossibleMovesGivenPositionForPawn() {
        ChessPositionCalculator chessPositionCalculator = new ChessPositionCalculator();
        Positions possibleMoves = chessPositionCalculator.calculate(new Pawn(), Position.from("H7"));
        assertEquals(List.of("H8"), possibleMoves.toChessNotation());
    }

    @Test
    void shouldCalculatePossibleMovesGivenPositionForKing() {
        ChessPositionCalculator chessPositionCalculator = new ChessPositionCalculator();
        Positions possibleMoves = chessPositionCalculator.calculate(new King(), Position.from("D5"));
        assertEquals(List.of("C4", "C5", "C6", "D4", "D6", "E4", "E5", "E6"), possibleMoves.toChessNotation());
    }

    @Test
    void shouldThrowExceptionGivenInvalidPositionToCalculateMoves() {
        ChessPositionCalculator chessPositionCalculator = new ChessPositionCalculator();

        InvalidPositionException invalidPositionException = assertThrows(InvalidPositionException.class, () -> chessPositionCalculator.calculate(new Pawn(), Position.from("H9")));

        assertEquals(invalidPositionException.getMessage(), "Rank '9' is out of bounds. Only ranks 1 to 8 are supported.");
    }
}
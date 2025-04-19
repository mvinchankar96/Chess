package com.chess;

import com.chess.domain.Pawn;
import com.chess.domain.Position;
import com.chess.exception.InvalidPositionException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChessPositionCalculatorTest {

    @Test
    void shouldCalculatePossibleMovesGivenPositionForPawn() {
        ChessPositionCalculator chessPositionCalculator = new ChessPositionCalculator();
        List<Position> possibleMoves = chessPositionCalculator.calculate(new Pawn(), Position.from("H7"));
        assertEquals(List.of(Position.from("H8")), possibleMoves);
    }

    @Test
    void shouldThrowExceptionGivenInvalidPositionToCalculateMoves() {
        ChessPositionCalculator chessPositionCalculator = new ChessPositionCalculator();

        InvalidPositionException invalidPositionException = assertThrows(InvalidPositionException.class, () -> chessPositionCalculator.calculate(new Pawn(), Position.from("H9")));

        assertEquals(invalidPositionException.getMessage(), "Rank '9' is out of bounds. Only ranks 1 to 8 are supported.");
    }
}
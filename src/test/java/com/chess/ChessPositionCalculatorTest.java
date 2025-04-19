package com.chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ChessPositionCalculatorTest {

    @Test
    void shouldCalculatePossibleMovesGivenPositionForPawn() {
        ChessPositionCalculator chessPositionCalculator = new ChessPositionCalculator();
        List<String> possibleMoves = chessPositionCalculator.calculate("Pawn", "H7");
        Assertions.assertEquals(List.of("H8"), possibleMoves);
    }
}
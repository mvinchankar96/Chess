package com.chess.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueenTest {

    @Test
    void shouldReturnAllMovesFromD4() {
        Queen queen = new Queen();
        Position from = Position.from("D4");

        Positions possibleMoves = queen.getPossibleMoves(from);

        List<String> expectedMoves = List.of(
                "C3", "B2", "A1",
                "C4", "B4", "A4",
                "C5", "B6", "A7",
                "D3", "D2", "D1",
                "D5", "D6", "D7", "D8",
                "E3", "F2", "G1",
                "E4", "F4", "G4", "H4",
                "E5", "F6", "G7", "H8"
        );

        assertEquals(expectedMoves, possibleMoves.toChessNotation());
    }

    @Test
    void shouldReturnValidMovesFromCornerA1() {
        Queen queen = new Queen();
        Position from = Position.from("A1");

        Positions possibleMoves = queen.getPossibleMoves(from);

        List<String> expectedMoves = List.of(
                "B2", "C3", "D4", "E5", "F6", "G7", "H8",
                "B1", "C1", "D1", "E1", "F1", "G1", "H1",
                "A2", "A3", "A4", "A5", "A6", "A7", "A8"
        );

        boolean matchesPossibleMoves = expectedMoves.containsAll(possibleMoves.toChessNotation());
        assertTrue(matchesPossibleMoves);
    }
}
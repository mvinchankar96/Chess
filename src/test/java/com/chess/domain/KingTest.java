package com.chess.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KingTest {

    @Test
    void shouldReturnPossibleMoves() {
        King king = new King();
        Position position = Position.from("D5");
        Positions possibleMoves = king.getPossibleMoves(position);
        assertEquals(List.of("C4", "C5", "C6", "D4", "D6", "E4", "E5", "E6"), possibleMoves.toChessNotation());
    }
}
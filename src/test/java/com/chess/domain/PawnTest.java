package com.chess.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {

    @Test
    void shouldReturnPossibleMoves() {
        Pawn pawn = new Pawn();
        Position position = Position.from("G1");
        Positions possibleMoves = pawn.getPossibleMoves(position);
        assertEquals(List.of("G2"), possibleMoves.toChessNotation());
    }
}
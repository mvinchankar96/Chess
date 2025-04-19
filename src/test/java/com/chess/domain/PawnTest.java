package com.chess.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {

    @Test
    void shouldReturnPossibleMoves() {
        Pawn pawn = new Pawn();
        Position position = Position.from("G1");
        List<Position> possibleMoves = pawn.getPossibleMoves(position);
        assertEquals(List.of(Position.from("G2")), possibleMoves);
    }
}
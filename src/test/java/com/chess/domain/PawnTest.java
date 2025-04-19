package com.chess.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {

    private final ChessBoard board = new ChessBoard();

    @Test
    void shouldReturnPossibleMoves() {
        Pawn pawn = new Pawn();
        Position position = board.parsePosition("G1");
        Positions possibleMoves = pawn.getPossibleMoves(position, board);
        assertEquals(List.of("G2"), board.toChessNotation(possibleMoves));
    }
}
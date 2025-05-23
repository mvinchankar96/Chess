package com.chess.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KingTest {

    private final ChessBoard board = new ChessBoard();

    @Test
    void shouldReturnPossibleMoves() {
        King king = new King();
        Position position = board.parsePosition("D5");
        Positions possibleMoves = king.getPossibleMoves(position, board);
        assertEquals(List.of("C4", "C5", "C6", "D4", "D6", "E4", "E5", "E6"), board.toChessNotation(possibleMoves));
    }
}
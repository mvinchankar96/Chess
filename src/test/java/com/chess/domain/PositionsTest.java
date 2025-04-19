package com.chess.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionsTest {

    private final ChessBoard board = new ChessBoard();

    @Test
    void shouldReturnChessNotationForAllPositions() {
        List<Position> positionList = List.of(
                new Position(0, 0),
                new Position(3, 4),
                new Position(7, 7)
        );

        Positions positions = new Positions(positionList);
        List<String> expected = List.of("A1", "D5", "H8");

        assertEquals(expected, board.toChessNotation(positions));
    }
}
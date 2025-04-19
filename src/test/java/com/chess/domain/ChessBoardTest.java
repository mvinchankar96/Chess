package com.chess.domain;

import com.chess.exception.InvalidPositionException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {

    private final ChessBoard board = new ChessBoard();

    @Test
    void shouldReturnTrueWhenPositionIsWithinBounds() {
        assertTrue(board.isWithinBounds(0, 0));
        assertTrue(board.isWithinBounds(7, 7));
        assertTrue(board.isWithinBounds(3, 5));
    }

    @Test
    void shouldReturnFalseWhenPositionIsOutOfBounds() {
        assertFalse(board.isWithinBounds(-1, 0));
        assertFalse(board.isWithinBounds(0, -1));
        assertFalse(board.isWithinBounds(8, 0));
        assertFalse(board.isWithinBounds(0, 8));
    }

    @Test
    void shouldParseValidChessNotationIntoPosition() {
        Position position = board.parsePosition("A1");
        assertEquals(0, position.file());
        assertEquals(0, position.rank());

        position = board.parsePosition("H8");
        assertEquals(7, position.file());
        assertEquals(7, position.rank());
    }

    @Test
    void shouldThrowExceptionWhenNotationIsNull() {
        InvalidPositionException exception = assertThrows(
                InvalidPositionException.class,
                () -> board.parsePosition(null)
        );
        assertEquals("Invalid position: null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenNotationLengthIsInvalid() {
        InvalidPositionException exception = assertThrows(
                InvalidPositionException.class,
                () -> board.parsePosition("A12")
        );
        assertEquals("Invalid position: A12", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForInvalidFileCharacter() {
        InvalidPositionException exception = assertThrows(
                InvalidPositionException.class,
                () -> board.parsePosition("J1")
        );
        assertEquals("File 'J' is out of bounds. Only files A to H are supported.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForInvalidRankCharacter() {
        InvalidPositionException exception = assertThrows(
                InvalidPositionException.class,
                () -> board.parsePosition("A9")
        );
        assertEquals("Rank '9' is out of bounds. Only ranks 1 to 8 are supported.", exception.getMessage());
    }

    @Test
    void shouldConvertPositionsToChessNotation() {
        Positions positions = new Positions(List.of(
                new Position(0, 0),
                new Position(3, 3),
                new Position(7, 7)
        ));

        List<String> result = board.toChessNotation(positions);
        List<String> expected = List.of("A1", "D4", "H8");

        assertEquals(expected, result);
    }
}
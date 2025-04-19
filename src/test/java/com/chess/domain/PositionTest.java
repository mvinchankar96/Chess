package com.chess.domain;

import com.chess.exception.InvalidPositionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionTest {
    @Test
    void shouldReturnPositionWithFileAndRank() {
        assertEquals(new Position(0, 0), Position.from("A1"));
        assertEquals(new Position(7, 0), Position.from("H1"));
    }

    @Test
    void shouldThrowExceptionGivenInvalidPositionForFile() {
        InvalidPositionException invalidPositionException = assertThrows(InvalidPositionException.class, () -> Position.from("J9"));
        assertEquals("Position out of bounds: J9", invalidPositionException.getMessage());
    }

    @Test
    void shouldThrowExceptionGivenInvalidPositionForRank() {
        InvalidPositionException invalidPositionException = assertThrows(InvalidPositionException.class, () -> Position.from("A9"));
        assertEquals("Position out of bounds: A9", invalidPositionException.getMessage());
    }

    @Test
    void shouldThrowExceptionGivenPositionAsNull() {
        InvalidPositionException invalidPositionException = assertThrows(InvalidPositionException.class, () -> Position.from(null));
        assertEquals("Invalid position: null", invalidPositionException.getMessage());

    }

    @Test
    void shouldThrowExceptionGivenInvalidPosition() {
        InvalidPositionException invalidPositionException = assertThrows(InvalidPositionException.class, () -> Position.from("invalid"));
        assertEquals("Invalid position: invalid", invalidPositionException.getMessage());
    }
}
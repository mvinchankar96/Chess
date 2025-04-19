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
        assertEquals("File 'J' is out of bounds. Only files A to H are supported.", invalidPositionException.getMessage());
    }

    @Test
    void shouldThrowExceptionGivenInvalidPositionForRank() {
        InvalidPositionException invalidPositionException = assertThrows(InvalidPositionException.class, () -> Position.from("A9"));
        assertEquals("Rank '9' is out of bounds. Only ranks 1 to 8 are supported.", invalidPositionException.getMessage());
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
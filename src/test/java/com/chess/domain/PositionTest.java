package com.chess.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    @Test
    void shouldReturnPositionWithFileAndRank() {
        assertEquals(new Position(0, 0), Position.from("A1"));
        assertEquals(new Position(7, 0), Position.from("H1"));
    }
}
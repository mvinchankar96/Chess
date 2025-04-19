package com.chess.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessPieceRegistryTest {

    @Test
    void shouldReturnPawnInstance() {
        ChessPiece piece = ChessPieceRegistry.getPieceByType("pawn");
        assertNotNull(piece);
        assertInstanceOf(Pawn.class, piece);
    }

    @Test
    void shouldReturnKingInstance() {
        ChessPiece piece = ChessPieceRegistry.getPieceByType("king");
        assertNotNull(piece);
        assertInstanceOf(King.class, piece);
    }

    @Test
    void shouldReturnQueenInstance() {
        ChessPiece piece = ChessPieceRegistry.getPieceByType("queen");
        assertNotNull(piece);
        assertInstanceOf(Queen.class, piece);
    }

    @Test
    void shouldThrowExceptionForUnsupportedPiece() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> ChessPieceRegistry.getPieceByType("bishop")
        );
        assertEquals("Unsupported chess piece: bishop", exception.getMessage());
    }

    @Test
    void shouldHandleCaseInsensitiveInput() {
        ChessPiece piece = ChessPieceRegistry.getPieceByType("QuEeN");
        assertNotNull(piece);
        assertInstanceOf(Queen.class, piece);
    }
}
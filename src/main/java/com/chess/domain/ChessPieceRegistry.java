package com.chess.domain;

public class ChessPieceRegistry {
    public static ChessPiece getPieceByType(String pieceType) {
        return switch (pieceType.toLowerCase()) {
            case "pawn" -> new Pawn();
            case "king" -> new King();
            case "queen" -> new Queen();
            default -> throw new IllegalArgumentException("Unsupported chess piece: " + pieceType);
        };
    }
}
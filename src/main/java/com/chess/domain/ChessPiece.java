package com.chess.domain;

public interface ChessPiece {
    Positions getPossibleMoves(Position position, ChessBoard board);
}
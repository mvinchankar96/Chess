package com.chess;

import com.chess.domain.ChessBoard;
import com.chess.domain.ChessPiece;
import com.chess.domain.Position;
import com.chess.domain.Positions;

public class ChessPositionCalculator {
    public Positions calculate(ChessPiece piece, String notation, ChessBoard board) {
        Position position = board.parsePosition(notation);
        return piece.getPossibleMoves(position, board);
    }
}
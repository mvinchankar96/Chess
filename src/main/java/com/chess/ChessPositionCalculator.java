package com.chess;

import com.chess.domain.ChessPiece;
import com.chess.domain.Position;
import com.chess.domain.Positions;

public class ChessPositionCalculator {

    public Positions calculate(ChessPiece chessPiece, Position position) {
        return chessPiece.getPossibleMoves(position);
    }
}
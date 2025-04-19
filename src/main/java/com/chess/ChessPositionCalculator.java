package com.chess;

import com.chess.domain.Pawn;
import com.chess.domain.Position;

import java.util.List;

public class ChessPositionCalculator {

    public List<Position> calculate(Pawn pawn, Position position) {
        return pawn.getPossibleMoves(position);
    }
}

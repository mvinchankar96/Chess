package com.chess.domain;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements ChessPiece {

    public static final int DIRECTION = 1;

    public Positions getPossibleMoves(Position position, ChessBoard board) {
        List<Position> possibleMoves = new ArrayList<>();
        int file = position.file();
        int rank = position.rank();

        int newRank = rank + DIRECTION;
        if (board.isWithinBounds(file, newRank)) {
            possibleMoves.add(new Position(file, newRank));
        }
        return new Positions(possibleMoves);
    }
}
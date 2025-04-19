package com.chess.domain;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements ChessPiece {

    public static final int DIRECTION = 1;

    public Positions getPossibleMoves(Position position) {
        List<Position> possibleMoves = new ArrayList<>();
        int file = position.file();
        int rank = position.rank();

        possibleMoves.add(new Position(file, rank + DIRECTION));
        return new Positions(possibleMoves);
    }
}
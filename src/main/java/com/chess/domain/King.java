package com.chess.domain;

import java.util.ArrayList;
import java.util.List;

public class King implements ChessPiece {
    private static final int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    @Override
    public Positions getPossibleMoves(Position position) {
        List<Position> possibleMoves = new ArrayList<>();
        int file = position.file();
        int rank = position.rank();

        for (int[] direction : DIRECTIONS) {
            int newFile = file + direction[0];
            int newRank = rank + direction[1];

            possibleMoves.add(new Position(newFile, newRank));
        }

        return new Positions(possibleMoves);
    }
}

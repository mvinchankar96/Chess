package com.chess.domain;

import java.util.ArrayList;
import java.util.List;

public class Queen implements ChessPiece {
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

            while (isWithinBounds(newFile, newRank)) {
                possibleMoves.add(new Position(newFile, newRank));
                newFile += direction[0];
                newRank += direction[1];
            }
        }

        return new Positions(possibleMoves);
    }

    private boolean isWithinBounds(int file, int rank) {
        return file >= 0 && file < 8 && rank >= 0 && rank < 8;
    }
}
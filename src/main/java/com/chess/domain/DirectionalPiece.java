package com.chess.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class DirectionalPiece implements ChessPiece {
    protected static final int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    protected final int maxDistance;

    protected DirectionalPiece(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    @Override
    public Positions getPossibleMoves(Position position, ChessBoard board) {
        List<Position> possibleMoves = new ArrayList<>();
        int file = position.file();
        int rank = position.rank();

        for (int[] direction : DIRECTIONS) {
            int distance = 1;
            while (distance <= maxDistance) {
                int newFile = file + direction[0] * distance;
                int newRank = rank + direction[1] * distance;

                if (board.isWithinBounds(newFile, newRank)) {
                    possibleMoves.add(new Position(newFile, newRank));
                }
                distance++;
            }
        }
        return new Positions(possibleMoves);
    }
}

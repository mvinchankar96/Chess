package com.chess.domain;

import java.util.ArrayList;
import java.util.List;

public class Pawn {

    public List<Position> getPossibleMoves(Position position) {
        List<Position> moves = new ArrayList<>();
        int file = position.file();
        int rank = position.rank();

        int direction = 1;
        moves.add(new Position(file, rank + direction));
        return moves;
    }
}
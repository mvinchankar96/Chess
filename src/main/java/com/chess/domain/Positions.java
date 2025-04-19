package com.chess.domain;

import java.util.List;

public class Positions {
    private final List<Position> positions;

    public Positions(List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> get() {
        return positions;
    }
}
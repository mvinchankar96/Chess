package com.chess.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Positions {
    private final List<Position> positions;

    public Positions(List<Position> positions) {
        this.positions = positions;
    }

    public List<String> toChessNotation() {
        return positions.stream()
                .map(Position::toChessNotation)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return toChessNotation().toString();
    }
}
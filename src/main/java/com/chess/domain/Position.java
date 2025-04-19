package com.chess.domain;

import com.chess.exception.InvalidPositionException;

import static java.util.Objects.isNull;

public record Position(int file, int rank) {

    public static final char START_FILE_CHAR = 'A';

    public static Position from(String position) {
        if (isNull(position) || position.length() != 2) {
            throw new InvalidPositionException("Invalid position: " + position);
        }

        char fileChar = Character.toUpperCase(position.charAt(0));
        char rankChar = position.charAt(1);

        int fileIndex = fileChar - START_FILE_CHAR;
        int rankIndex = Character.getNumericValue(rankChar) - 1;

        if (withinLimits(fileIndex) || withinLimits(rankIndex)) {
            throw new InvalidPositionException("Position out of bounds: " + position);
        }

        return new Position(fileIndex, rankIndex);
    }

    private static boolean withinLimits(int fileIndex) {
        return fileIndex < 0 || fileIndex >= 8;
    }
}
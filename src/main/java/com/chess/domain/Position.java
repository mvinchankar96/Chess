package com.chess.domain;

import com.chess.exception.InvalidPositionException;

import static java.util.Objects.isNull;

public record Position(int file, int rank) {

    public static final char START_FILE_CHAR = 'A';

    public static Position from(String position) {
        validatePosition(position);

        char fileChar = Character.toUpperCase(position.charAt(0));
        char rankChar = position.charAt(1);

        int fileIndex = fileChar - START_FILE_CHAR;
        int rankIndex = Character.getNumericValue(rankChar) - 1;

        validateFileIndex(position, fileIndex);
        validateRankIndex(position, rankIndex);

        return new Position(fileIndex, rankIndex);
    }

    private static void validateFileIndex(String position, int fileIndex) {
        if (fileIndex < 0 || fileIndex >= 8) {
            throw new InvalidPositionException("File out of bounds in position: " + position);
        }
    }

    private static void validateRankIndex(String position, int rankIndex) {
        if (rankIndex < 0 || rankIndex >= 8) {
            throw new InvalidPositionException("Rank out of bounds in position: " + position);
        }
    }

    private static void validatePosition(String position) {
        if (isNull(position) || position.length() != 2) {
            throw new InvalidPositionException("Invalid position: " + position);
        }
    }

}
package com.chess.domain;

import com.chess.exception.InvalidPositionException;

import static java.util.Objects.isNull;

public record Position(Integer file, Integer rank) {

    public static final char START_FILE_CHAR = 'A';

    public Position {
        validateFileIndex(file);
        validateRankIndex(rank);
    }

    public static Position from(String position) {
        validatePosition(position);

        char fileChar = Character.toUpperCase(position.charAt(0));
        char rankChar = position.charAt(1);

        int fileIndex = fileChar - START_FILE_CHAR;
        int rankIndex = Character.getNumericValue(rankChar) - 1;

        return new Position(fileIndex, rankIndex);
    }

    private static void validatePosition(String position) {
        if (isNull(position) || position.length() != 2) {
            throw new InvalidPositionException("Invalid position: " + position);
        }
    }

    private void validateFileIndex(Integer fileIndex) {
        if (fileIndex < 0 || fileIndex >= 8) {
            char fileChar = (char) (START_FILE_CHAR + fileIndex);
            throw new InvalidPositionException("File '" + fileChar + "' is out of bounds. Only files A to H are supported.");
        }
    }

    private void validateRankIndex(Integer rankIndex) {
        if (rankIndex < 0 || rankIndex >= 8) {
            int rankNumber = rankIndex + 1;
            throw new InvalidPositionException("Rank '" + rankNumber + "' is out of bounds. Only ranks 1 to 8 are supported.");
        }
    }
}
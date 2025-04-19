package com.chess.domain;

public record Position(int file, int rank) {

    public static final char START_FILE_CHAR = 'A';

    public static Position from(String position) {
        char fileChar = Character.toUpperCase(position.charAt(0));
        char rankChar = position.charAt(1);

        int fileIndex = fileChar - START_FILE_CHAR;
        int rankIndex = Character.getNumericValue(rankChar) - 1;

        return new Position(fileIndex, rankIndex);
    }
}
package com.chess.domain;

import com.chess.exception.InvalidPositionException;

import java.util.List;

import static java.util.Objects.isNull;

public class ChessBoard {
    public static final int BOARD_SIZE = 8;
    public static final char START_FILE_CHAR = 'A';

    public boolean isWithinBounds(int file, int rank) {
        return file >= 0 && file < BOARD_SIZE && rank >= 0 && rank < BOARD_SIZE;
    }

    public Position parsePosition(String notation) {
        if (isNull(notation) || notation.length() != 2) {
            throw new InvalidPositionException("Invalid position: " + notation);
        }

        char fileChar = Character.toUpperCase(notation.charAt(0));
        char rankChar = notation.charAt(1);

        int fileIndex = fileChar - START_FILE_CHAR;
        int rankIndex = Character.getNumericValue(rankChar) - 1;

        if (!isWithinBounds(fileIndex, rankIndex)) {
            validateFileIndex(fileIndex, fileChar);
            validateRankIndex(rankIndex, rankChar);
        }

        return new Position(fileIndex, rankIndex);
    }

    private static void validateRankIndex(int rankIndex, char rankChar) {
        if (rankIndex < 0 || rankIndex >= BOARD_SIZE) {
            throw new InvalidPositionException("Rank '" + rankChar + "' is out of bounds. Only ranks 1 to 8 are supported.");
        }
    }

    private static void validateFileIndex(int fileIndex, char fileChar) {
        if (fileIndex < 0 || fileIndex >= BOARD_SIZE) {
            throw new InvalidPositionException("File '" + fileChar + "' is out of bounds. Only files A to H are supported.");
        }
    }

    public List<String> toChessNotation(Positions positions) {
        return positions.get().stream()
                .map(position -> String.format("%c%d",
                        (char) (START_FILE_CHAR + position.file()), position.rank() + 1)
                )
                .toList();
    }
}
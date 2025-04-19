package com.chess.application;

import com.chess.ChessPositionCalculator;
import com.chess.domain.ChessBoard;
import com.chess.domain.ChessPiece;
import com.chess.domain.ChessPieceRegistry;
import com.chess.domain.Positions;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Chess Piece Movement Simulator");
        System.out.println("Enter input as: PieceType, Position (e.g., King, D5)");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input: ");
            String input = scanner.nextLine().trim();

            handleInput(input);
        }
    }

    private static void handleInput(String input) {
        String[] parts = parseInput(input);
        if (parts == null) return;

        String pieceType = parts[0].trim().toLowerCase();
        String position = parts[1].trim().toUpperCase();

        try {
            ChessPiece piece = ChessPieceRegistry.getPieceByType(pieceType);

            String output = calculateMoves(piece, position);
            System.out.println("Output: " + output);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static String[] parseInput(String input) {
        String[] parts = input.split(",");
        if (parts.length != 2) {
            System.err.println("Invalid input format. Please use: PieceType, Position (e.g., King, D5)");
            return null;
        }
        return parts;
    }

    private static String calculateMoves(ChessPiece piece, String position) {
        ChessBoard board = new ChessBoard();
        ChessPositionCalculator calculator = new ChessPositionCalculator();

        Positions positions = calculator.calculate(piece, position, board);
        List<String> notations = board.toChessNotation(positions);
        return String.join(", ", notations);
    }
}
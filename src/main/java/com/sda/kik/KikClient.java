package com.sda.kik;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class KikClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 1234);

        Scanner scanner = new Scanner(System.in);

        Scanner socketIn = new Scanner(socket.getInputStream());
        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        System.out.println("Waiting for first move");
        Board board = new Board();
        while (!board.isGameFinished()) {
            System.out.println(board);
            if (board.getCounter() % 2 == 0) {
                opponentsTurn(socketIn, board);
            } else {
                yourTurn(scanner, socketOut, board);
            }
        }
    }

    private static void opponentsTurn(Scanner socketIn, Board board) {
        String oponentPosition = socketIn.nextLine();
        Integer position = Integer.valueOf(oponentPosition);
        board.addMove(position, "X");
    }

    private static void yourTurn(Scanner scanner, BufferedWriter socketOut, Board board) throws IOException {
        boolean status;
        do {
            System.out.println("Insert position: ");
            String ourPosition = scanner.nextLine();
            Integer ourPositionNumber = Integer.valueOf(ourPosition);
            status = board.addMove(ourPositionNumber, "O");
            if (status) {
                socketOut.write(ourPositionNumber + "\n");
                socketOut.flush();
            } else {
                System.out.println("Invalid position");
            }
        } while (!status);
    }
}
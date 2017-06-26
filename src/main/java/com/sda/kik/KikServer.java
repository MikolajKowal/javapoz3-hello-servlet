package com.sda.kik;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class KikServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket = serverSocket.accept();

        Scanner scanner = new Scanner(System.in); // wyświetlamy aktualny stan planszy

        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner socketIn = new Scanner(socket.getInputStream()); // przyjmujemy to co przychodzi

        System.out.println("You are first");
        Board board = new Board();
        while (!board.isGameFinished()) {
            System.out.println(board);
            if (board.getCounter() % 2 == 0) {
                    // wysyłamy do użytkownika naszą pozycję, którą ustawiliśmy
                    yourTurn(scanner, socketOut, board);
                } else {
                    oponentsTurn(socketIn, board);
                }
                }
}

    private static void oponentsTurn(Scanner socketIn, Board board) {
        String oponentPosition = socketIn.nextLine();
        board.addMove(Integer.valueOf(oponentPosition), "O");
    }

    private static void yourTurn(Scanner scanner, BufferedWriter socketOut, Board board) throws IOException {
        boolean status;
        do {
            System.out.println("Insert position: ");
            String number = scanner.nextLine();
            status = board.addMove(Integer.valueOf(number), "X");
            if (status) {
                socketOut.write(number + "\n");
                socketOut.flush();
            } else {
                System.out.println("Invalid position");
            }
        } while (!status);
    }
}

package com.sda.sockets;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket = serverSocket.accept();  // ta metoda czeka na połączenie, "nasłuchuje"
        // gdy nastąpi podłączenie program przechodzi dalej
        System.out.println("Waiting for connection");
        System.out.println("Connection established");

        Scanner scanner = new Scanner(socket.getInputStream()); // definiujemy to co do nas przychodzi
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scannerToUser = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            String input = scanner.nextLine();   // czytamy wejście
            System.out.println("Guest: " + input);
            writer.write(scannerToUser.nextLine() + "\n");   
            writer.flush();   // wysyłamy
        }
        socket.close();       // zamykamy strumienie
        serverSocket.close();  // zamykamy strumienie

    }
}

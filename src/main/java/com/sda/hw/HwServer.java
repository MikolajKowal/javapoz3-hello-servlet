package com.sda.hw;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class HwServer {

    public static void main(String[] args) throws IOException {

        /** server czeka na połączenie
         * po podłączeniu odbiera liczbę n
         * wysyła losowego Stringa o rozmiarze n
         */

        ServerSocket serverSocket = new ServerSocket(1234);
        boolean flag = true;
        while(flag) {
            Socket socket = serverSocket.accept();   // nasłuchiwanie przez nas serwer
            Scanner socketIn = new Scanner(socket.getInputStream()); // tworzymy strumienie
            BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            int counter = Integer.valueOf(socketIn.nextLine());  // przypisujemy to co otrzymamy od Klienta
            String random = RandomStringUtils.random(counter, true, true);
            socketOut.write(random + "\n");
            socketOut.flush();

            socket.close();
        }
        serverSocket.close();
    }
}

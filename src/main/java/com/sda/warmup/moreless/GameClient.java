package com.sda.warmup.moreless;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;


public class GameClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 1234);
        Scanner socketIn = new Scanner(socket.getInputStream());
        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        int result=0;
        Scanner scannerFromUser = new Scanner(System.in);
        do {
            System.out.println("Insert number");
            int number = scannerFromUser.nextInt();

            socketOut.write(number + "\n");
            socketOut.flush();

            String serverResponse = socketIn.nextLine();
            result = Integer.valueOf(serverResponse);

            if (1 == result) {
                System.out.println("Value too high");
            } else if (-1 == result) {
                System.out.println("Value too low");
            }
        } while (result != 0);
        System.out.println("Correct value");
        String counter = socketIn.nextLine();
        System.out.println(counter);

        socket.close();
    }
}


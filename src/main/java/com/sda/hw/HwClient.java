package com.sda.hw;



import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class HwClient {

    /** łączy się z serwerem
     * po podłączeniu wysyła liczbę n
     * czeka na odpowiedź
     * po otrzymaniu, wysyła ją w odwrotnej kolejności String.Utils.reverse
     */

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 1234);
        Scanner socketIn = new Scanner(socket.getInputStream()); // tworzymy strumienie
        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give number: ");
        int number = scanner.nextInt();
        socketOut.write(number + "\n");
        socketOut.flush();

        String message = socketIn.nextLine(); // czekamy na odpowiedź od servera

        System.out.println("Received message: " + message);

        String reverseMessage = StringUtils.reverse(message);
        System.out.println("Reversed message: " + reverseMessage);

        socket.close();


    }



}


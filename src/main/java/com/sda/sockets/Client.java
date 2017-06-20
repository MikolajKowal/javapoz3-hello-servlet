package com.sda.sockets;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1235);
        // podłączamy się do istniejącego gniazdka 1234, pod hostem localhost
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scanner = new Scanner(socket.getInputStream());  // zczytujemy to co do nas przychodzi
        Scanner scannerToUser = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            writer.write(scannerToUser.nextLine() + "\n");  // wypisujemy na zewnątrz
            writer.flush();
            System.out.println("Guest: " + scanner.nextLine());  // czekamy na to, co ktoś wpisze
        }

        socket.close();
    }
}

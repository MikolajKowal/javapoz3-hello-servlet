package com.sda.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);

        boolean flag = true;
        ChatUsersStorage storage = new ChatUsersStorage();
        while(flag){
            Socket socket = serverSocket.accept(); // przyjmujemy  wszystkie połączenie
            System.out.println("Someone connected");   // logujemy informacje, że ktoś się podłączył
            ChatServerTask chatServerTask = new ChatServerTask(socket, storage); // tworzymy nowy obiekt
            Thread thread = new Thread(chatServerTask);// tworzymy nowy wątek, który przyjmuje chatServerTask
            thread.start(); // startujemy wątek
        }
        serverSocket.close();
    }
}

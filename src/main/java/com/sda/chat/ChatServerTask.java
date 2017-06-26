package com.sda.chat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatServerTask implements Runnable {


    private ChatConnectionFacade yourConnection;  // obiekt który przyjmuje input i output

    private ChatUsersStorage storage; // dodajemy pole storage

    public ChatServerTask(Socket socket, ChatUsersStorage storage) throws IOException {
        Scanner in = new Scanner(socket.getInputStream());
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.yourConnection = new ChatConnectionFacade(in, out);
        this.storage = storage; // zapisujemy sobie pole storage, inicjalizujemy
    }

    @Override
    public void run() {

        String nickname = yourConnection.read();  // czytamy nickname
        yourConnection.setNickName(nickname);
        boolean add = storage.add(nickname, yourConnection);
        if (add) {
            boolean flag = true;
            while (flag) {
                String input = yourConnection.read();  // czytamy to, co użytkownik napisał
                String nickToSend = input.substring(0, input.indexOf(" "));  // wyciągamy nick adresata
                ChatConnectionFacade destinationConnection = storage.get(nickToSend);

                try {
                    destinationConnection.write(input.substring(input.indexOf(" ")));
                    } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                yourConnection.write("Nickname already in use");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
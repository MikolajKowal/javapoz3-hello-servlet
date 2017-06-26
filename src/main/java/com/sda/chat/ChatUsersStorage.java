package com.sda.chat;

import java.util.HashMap;
import java.util.Map;

public class ChatUsersStorage {

    private Map<String, ChatConnectionFacade> users;

    public ChatUsersStorage() {
        users = new HashMap<>();
            }

            public boolean add (String nickname, ChatConnectionFacade user){
        boolean flag = false;
               if (!users.containsKey(nickname)) {
                   users.put(nickname, user);
                   flag = true;
               }
               return flag;
            }

            public ChatConnectionFacade get(String nickname){
                return users.get(nickname);
            }
}

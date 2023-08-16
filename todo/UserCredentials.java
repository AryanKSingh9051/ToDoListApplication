package com.todo;

import java.util.HashMap;

public class UserCredentials {
    private HashMap<String, UserInfo> userMap = new HashMap<>();

    public void getUser(String username, UserInfo user) {
        userMap.put(username, user);
    }

    public UserInfo setUser(String username, String password) {
        UserInfo user = userMap.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}

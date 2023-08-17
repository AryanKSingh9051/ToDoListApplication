package com.todo;

import java.util.HashMap;

public class UserCredentials {
    HashMap<String, UserInfo> userMap = new HashMap<>();

    public void addUser(String uname, UserInfo user) {
        userMap.put(uname, user);
    }

    public UserInfo checkUser(String uname, String pswrd) {
        UserInfo user = userMap.get(uname);
        if (user != null && user.getPassword().equals(pswrd)) {
            return user;
        }
        return null;
    }
}

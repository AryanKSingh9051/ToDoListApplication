package com.todo;

import java.util.*;

class UserInfo {
    String username;
    String password;
    ArrayList<TaskDetails> list;

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
        this.list = new ArrayList<>();
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<TaskDetails> getTasks() {
        return list;
    }

    public void addTask(TaskDetails task) {
        list.add(task);
    }

    public void removeTask(int index) {
        list.remove(index);
    }

    @Override
    public String toString() {
        return "User-> " + username.toUpperCase() + " has been logged out.\n";
    }
}

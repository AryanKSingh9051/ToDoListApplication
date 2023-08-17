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
    public ArrayList<TaskDetails> getList() {
		return list;
	}
	public void setList(ArrayList<TaskDetails> list) {
		this.list = list;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
    public String toString() {
        return "User-> " + username.toUpperCase() + " has been logged out.\n";
    }
}

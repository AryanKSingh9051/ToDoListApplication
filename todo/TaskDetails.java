package com.todo;

import java.util.*;

public class TaskDetails {
	private String name;
	private String priority;
    private boolean status;

    public TaskDetails(String name, String priority) {
        this.name = name;
        this.priority = priority;
        this.status = false; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    @Override
    public String toString() {
        return name.toUpperCase() + " is " + priority.toUpperCase() + " priority & is " + (status ? "COMPLETED" : "PENDING") + "." ;
    }
}

package com.todo;

import java.util.Scanner;

public class TaskFunctions {
	static Scanner sc = new Scanner(System.in);
	static String high = "High";
	static String normal = "Normal";
	static String low = "Low";
	public static void addTask(UserInfo user) throws InvalidPriorityException{
        System.out.print("\nEnter Task:");
        String task_name = sc.nextLine();
        System.out.print("Set Task Priority (High / Normal / Low): ");
        String task_priority = sc.nextLine(); 
        if(task_priority.equalsIgnoreCase(high) || task_priority.equalsIgnoreCase(normal) || task_priority.equalsIgnoreCase(low)){
        	user.list.add(new TaskDetails(task_name, task_priority)); 
            System.out.println("Task Added in ToDo List.");
        }
        else{
        	throw new InvalidPriorityException("UNKNOWN PRIORITY.");
        } 
    }
    
    public static void deleteTask(UserInfo user) throws InvalidIdException{
        System.out.print("Enter Task ID: ");
        int task_id = sc.nextInt()-1;
        sc.nextLine(); 

        if (task_id >= 0 && task_id < user.list.size()) {
        	user.list.remove(task_id);
            System.out.println("Task Deleted from ToDo List");
        } else {
            throw new InvalidIdException("INVALID TASK ID");
        }
    }

    public static void editTask(UserInfo user) throws InvalidIdException, InvalidPriorityException{
        System.out.print("Enter Task ID: ");
        int task_id = sc.nextInt()-1;
        sc.nextLine();

        if (task_id >= 0 && task_id < user.list.size()) {
            TaskDetails t = user.list.get(task_id);
            System.out.println(t);
            System.out.print("Enter New Task:");
            String newTask = sc.nextLine();
            System.out.print("Set New Task Priority (High/ Normal/ Low): ");
            String newTaskPriority = sc.nextLine();
            if(newTaskPriority.equalsIgnoreCase(high) || newTaskPriority.equalsIgnoreCase(normal) || newTaskPriority.equalsIgnoreCase(low)){
            	t.setName(newTask);
                t.setPriority(newTaskPriority); 
                System.out.println("Task Edited Successfully.");
            }
            else{
            	throw new InvalidPriorityException("UNKNOWN PRIORITY.");
            }
        } else {
        	throw new InvalidIdException("INVALID TASK ID");
        }
    }

    public static void setTaskPriority(UserInfo user) throws InvalidIdException, InvalidPriorityException{
        System.out.print("Enter Task ID: ");
        int task_id = sc.nextInt()-1;
        sc.nextLine();

        if (task_id >= 0 && task_id < user.list.size()) {
            TaskDetails t = user.list.get(task_id);
            System.out.print("Set New Task Priority (High/ Normal/ Low): ");
            String newPriority = sc.nextLine();
            if(newPriority.equalsIgnoreCase(high) || newPriority.equalsIgnoreCase(normal) || newPriority.equalsIgnoreCase(low)){
            	t.setPriority(newPriority);
                System.out.println("Task Priority Changed Successfully.");
            }
            else {
            	throw new InvalidPriorityException("UNKNOWN PRIORITY.");
            }
        } else {
        	throw new InvalidIdException("INVALID TASK ID");
        }
    }
    
    public static void isTaskComplete(UserInfo user) throws InvalidIdException{
        System.out.print("Enter Task ID: ");
        int task_id = sc.nextInt()-1;
        sc.nextLine(); 
        if (task_id >= 0 && task_id < user.list.size()) {
            TaskDetails t = user.list.get(task_id);
            t.setStatus(true);
            System.out.println("Task " + (task_id+1) + " has been COMPLETED.");
        } else {
        	throw new InvalidIdException("INVALID TASK ID");
        }
    }
    
    public static void displayToDoList(UserInfo user) {
        if (user.list.isEmpty()) {
            System.out.println("\nToDo List is EMPTY");
        } else {
            System.out.println("\nTo Do List: ");
            for (int i = 0; i < user.list.size(); i++) {
                TaskDetails t = user.list.get(i);
                System.out.println((i+1) + ". " + t.getName() + " | " + t.getPriority() + " | " + (t.getStatus() ? "[Completed] " : "[Pending] "));
            }
        }
    }
    
    public static void clearToDoList(UserInfo user) {
        user.list.clear();
        System.out.println("ToDo List is CLEARED.");
    }
}

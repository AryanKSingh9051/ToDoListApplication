package com.todo;
//package com.todo;
//
//import java.util.*;
//import java.util.Scanner;
//
//public class ToDo {
//    static HashMap<String, UserInfo> Credentials = new HashMap<>();
//    static UserInfo Current_User = null;
//    static Scanner sc = new Scanner(System.in);
//    static String high = "High";
//	static String normal = "Normal";
//	static String low = "Low";
//
//    public static void main(String[] args) {
//        while (true) {
//        	System.out.println("*********** ToDo List ***********\n");
//            System.out.println("1. New User Registration\n");
//            System.out.println("2. Existing User Login\n");
//            System.out.println("3. Exit Application");
//            System.out.println("---------------------------------");
//            System.out.print("Input: ");
//            int option = sc.nextInt();
//            sc.nextLine();
//
//            switch (option) {
//                case 1:
//                    registration();
//                    break;
//                case 2:
//                    login();
//                    if (Current_User != null) {
//                        userMenu();
//                    }
//                    break;
//                case 3:
//                    System.out.println("\n--- EXITED APPLICATION ---");
//                    return;
//                default:
//                    System.out.println("INVALID INPUT. Please Choose An Option from the Menu Provided.\n");
//            }
//        }
//    }
//
//    public static void registration() {
//        System.out.print("\nSet Username: ");
//        String username = sc.nextLine();
//        System.out.print("Set Password: ");
//        String password = sc.nextLine();
//
//        Credentials.put(username, new UserInfo(username, password));
//        System.out.println("NEW USER REGISTERED\n");
//    }
//
//    public static void login() {
//        System.out.print("\nEnter Username: ");
//        String username = sc.nextLine();
//        System.out.print("Enter Password: ");
//        String password = sc.nextLine();
//
//        UserInfo user = Credentials.get(username);
//        if (user != null && user.password.equals(password)) {
//        	Current_User = user;
//            System.out.println("Logged In Successfully. Welcome, " + Current_User.username.toUpperCase() + "!");
//        } else {
//            System.out.println("INVALID CREDENTIALS. Please Try Again.\n");
//        }
//    }
//
//    public static void userMenu() {
//        while (true) {
//        	System.out.println("\n***** ToDo List Operations *****");
//            System.out.println("1. Add a New Task");
//            System.out.println("2. Delete a Task");
//            System.out.println("3. Edit a Task");
//            System.out.println("4. Change Task Priority");
//            System.out.println("5. Mark Task as Completed");
//            System.out.println("6. Show To-Do List");
//            System.out.println("7. Clear All Tasks");
//            System.out.println("8. Logout");
//            System.out.println("--------------------------------");
//            System.out.print("Choice: ");
//            int option = sc.nextInt();
//            
//            sc.nextLine(); 
//            switch (option) {
//                case 1:
//					try {
//						addTask();
//					} catch (InvalidPriorityException e) {
//						System.out.println(e);
//					}
//                    break;
//                case 2:
//					try {
//						deleteTask();
//					} catch (InvalidIdException e) {
//						System.out.println(e);
//					}
//                    break;
//                case 3:
//					try {
//						editTask();
//					} catch (InvalidIdException e) {
//						System.out.println(e);
//					} catch (InvalidPriorityException e) {
//						System.out.println(e);
//					}
//                    break;
//                case 4:
//					try {
//						setTaskPriority();
//					} catch (InvalidIdException e) {
//						System.out.println(e);
//					} catch (InvalidPriorityException e) {
//						System.out.println(e);
//					}                                   
//                    break;
//                case 5:
//					try {
//						isTaskComplete();
//					} catch (InvalidIdException e) {
//						System.out.println(e);
//					}
//                    break;
//                case 6:
//                	displayToDoList();
//                	break;
//                case 7:
//                    clearToDoList();
//                    break;
//                case 8:
//                    System.out.println(Current_User);
//                    Current_User = null;
//                    return;
//                default:
//                    System.out.println("INVALID OPTION SELECTED");
//            }
//        }
//    }
//
//    public static void addTask() throws InvalidPriorityException{
//        System.out.print("\nEnter Task:");
//        String task_name = sc.nextLine();
//        System.out.print("Set Task Priority (High / Normal / Low): ");
//        String task_priority = sc.nextLine(); 
//        if(task_priority.equalsIgnoreCase(high) || task_priority.equalsIgnoreCase(normal) || task_priority.equalsIgnoreCase(low)){
//        	Current_User.list.add(new TaskDetails(task_name, task_priority)); 
//            System.out.println("Task Added in ToDo List.");
//        }
//        else{
//        	throw new InvalidPriorityException("UNKNOWN PRIORITY.");
//        } 
//    }
//    
//    public static void deleteTask() throws InvalidIdException{
//        System.out.print("Enter Task ID: ");
//        int task_id = sc.nextInt()-1;
//        sc.nextLine(); 
//
//        if (task_id >= 0 && task_id < Current_User.list.size()) {
//            Current_User.list.remove(task_id);
//            System.out.println("Task Deleted from ToDo List");
//        } else {
//            throw new InvalidIdException("INVALID TASK ID");
//        }
//    }
//
//    public static void editTask() throws InvalidIdException, InvalidPriorityException{
//        System.out.print("Enter Task ID: ");
//        int task_id = sc.nextInt()-1;
//        sc.nextLine();
//
//        if (task_id >= 0 && task_id < Current_User.list.size()) {
//            TaskDetails t = Current_User.list.get(task_id);
//            System.out.println(t);
//            System.out.print("Enter New Task:");
//            String newTask = sc.nextLine();
//            System.out.print("Set New Task Priority (High/ Normal/ Low): ");
//            String newTaskPriority = sc.nextLine();
//            if(newTaskPriority.equalsIgnoreCase(high) || newTaskPriority.equalsIgnoreCase(normal) || newTaskPriority.equalsIgnoreCase(low)){
//            	t.setName(newTask);
//                t.setPriority(newTaskPriority); 
//                System.out.println("Task Edited Successfully.");
//            }
//            else{
//            	throw new InvalidPriorityException("UNKNOWN PRIORITY.");
//            }
//        } else {
//        	throw new InvalidIdException("INVALID TASK ID");
//        }
//    }
//
//    public static void setTaskPriority() throws InvalidIdException, InvalidPriorityException{
//        System.out.print("Enter Task ID: ");
//        int task_id = sc.nextInt()-1;
//        sc.nextLine();
//
//        if (task_id >= 0 && task_id < Current_User.list.size()) {
//            TaskDetails t = Current_User.list.get(task_id);
//            System.out.print("Set New Task Priority (High/ Normal/ Low): ");
//            String newPriority = sc.nextLine();
//            if(newPriority.equalsIgnoreCase(high) || newPriority.equalsIgnoreCase(normal) || newPriority.equalsIgnoreCase(low)){
//            	t.setPriority(newPriority);
//                System.out.println("Task Priority Changed Successfully.");
//            }
//            else {
//            	throw new InvalidPriorityException("UNKNOWN PRIORITY.");
//            }
//        } else {
//        	throw new InvalidIdException("INVALID TASK ID");
//        }
//    }
//    
//    public static void isTaskComplete() throws InvalidIdException{
//        System.out.print("Enter Task ID: ");
//        int task_id = sc.nextInt()-1;
//        sc.nextLine(); 
//        if (task_id >= 0 && task_id < Current_User.list.size()) {
//            TaskDetails t = Current_User.list.get(task_id);
//            t.setStatus(true);
//            System.out.println("Task " + (task_id+1) + " has been COMPLETED.");
//        } else {
//        	throw new InvalidIdException("INVALID TASK ID");
//        }
//    }
//    
//    public static void displayToDoList() {
//        if (Current_User.list.isEmpty()) {
//            System.out.println("\nToDo List is EMPTY");
//        } else {
//            System.out.println("\nTo Do List: ");
//            for (int i = 0; i < Current_User.list.size(); i++) {
//                TaskDetails t = Current_User.list.get(i);
//                System.out.println((i+1) + ". " + t.getName() + " | " + t.getPriority() + " | " + (t.getStatus() ? "[Completed] " : "[Pending] "));
//            }
//        }
//    }
//    
//    public static void clearToDoList() {
//        Current_User.list.clear();
//        System.out.println("ToDo List is CLEARED.");
//    }
//}
//
//
//

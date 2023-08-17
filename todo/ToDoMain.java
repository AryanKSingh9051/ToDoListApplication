package com.todo;

import java.util.*;
import java.util.Scanner;

public class ToDoMain {
	private static UserCredentials credentials = new UserCredentials();
    static Scanner sc = new Scanner(System.in);
	static UserInfo Current_User = null;
	
    public static void registration() {
        System.out.print("\nSet Username: ");
        String uname = sc.nextLine();
        System.out.print("Set Password: ");
        String pswrd = sc.nextLine();

        credentials.addUser(uname, new UserInfo(uname, pswrd));
        System.out.println("NEW USER REGISTERED\n");
    }

    public static void login() {
        System.out.print("\nEnter Username: ");
        String uname = sc.nextLine();
        System.out.print("Enter Password: ");
        String pswrd = sc.nextLine();

        UserInfo user = credentials.checkUser(uname,pswrd);
        if (user != null && user.password.equals(pswrd)) {
        	Current_User = user;
            System.out.println("Logged In Successfully. Welcome, " + Current_User.username.toUpperCase() + "!");
        } else {
            System.out.println("INVALID CREDENTIALS. Please Try Again.\n");
        }
    }
    public static void main(String[] args) {
        while (true) {
        	System.out.println("*********** ToDo List ***********\n");
            System.out.println("1. New User Registration\n");
            System.out.println("2. Existing User Login\n");
            System.out.println("3. Exit Application");
            System.out.println("---------------------------------");
            System.out.print("Input: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    registration();
                    break;
                case 2:
                    login();
                    if (Current_User != null) {
                        listOperations();
                    }
                    break;
                case 3:
                    System.out.println("\n--- EXITED APPLICATION ---");
                    return;
                default:
                    System.out.println("INVALID INPUT. Please Choose An Option from the Menu Provided.\n");
            }
        }
    }
    
    public static void listOperations() {
        while (true) {
        	System.out.println("\n***** ToDo List Operations *****");
            System.out.println("1. Add a New Task");
            System.out.println("2. Delete a Task");
            System.out.println("3. Edit a Task");
            System.out.println("4. Change Task Priority");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. Show To-Do List");
            System.out.println("7. Clear All Tasks");
            System.out.println("8. Logout");
            System.out.println("--------------------------------");
            System.out.print("Choice: ");
            int option = sc.nextInt();
            
            sc.nextLine(); 
            switch (option) {
                case 1:
					try {
						TaskFunctions.addTask(Current_User);
					} catch (InvalidPriorityException e) {
						System.out.println(e);
					}
                    break;
                case 2:
					try {
						TaskFunctions.deleteTask(Current_User);
					} catch (InvalidIdException e) {
						System.out.println(e);
					}
                    break;
                case 3:
					try {
						TaskFunctions.editTask(Current_User);
					} catch (InvalidIdException e) {
						System.out.println(e);
					} catch (InvalidPriorityException e) {
						System.out.println(e);
					}
                    break;
                case 4:
					try {
						TaskFunctions.setTaskPriority(Current_User);
					} catch (InvalidIdException e) {
						System.out.println(e);
					} catch (InvalidPriorityException e) {
						System.out.println(e);
					}                                   
                    break;
                case 5:
					try {
						TaskFunctions.isTaskComplete(Current_User);
					} catch (InvalidIdException e) {
						System.out.println(e);
					}
                    break;
                case 6:
                	TaskFunctions.displayToDoList(Current_User);
                	break;
                case 7:
                	TaskFunctions.clearToDoList(Current_User);
                    break;
                case 8:
                    System.out.println(Current_User);
                    Current_User = null;
                    return;
                default:
                    System.out.println("INVALID OPTION SELECTED");
            }
        }
    }

    
}




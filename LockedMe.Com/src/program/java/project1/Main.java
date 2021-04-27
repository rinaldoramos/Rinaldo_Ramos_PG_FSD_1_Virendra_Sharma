package program.java.project1;

import java.io.File;
import java.util.Scanner;

public class Main {
	
	private static Scanner input; // scanner variable to receive input from the user using the keyboard.
    private static File filePath; // File variable to handle the location where the file will be created or exist.
    private static String fileName; // variable to hold the name of a file given by the user.
    private static int choice; // option selected by the user from the menus.
    private static boolean condition = true;

	public static void main(String[] args) {
		
	}

	 // output of the first menu
    private static void firstMenuDisplay(){
        System.out.println("=======================");
        System.out.println("Please choose a number: ");
        System.out.println("=======================\n\n");

        System.out.println("1- Return a list of file names on current directory...");
        System.out.println("2- Add...Delete....Search... a file...");
        System.out.println("3- Close application...");
    }

    // output of the second menu
    private static void secondMenuDisplay(){
        System.out.println("=======================");
        System.out.println("Please choose a number: ");
        System.out.println("=======================\n\n");

        System.out.println("1- Adding a file to the current directory..."); //This can ignore case sensitive
        System.out.println("2- Deleting a file from the current directory...");
        System.out.println("3- Search for a given file...");
        System.out.println("4- Return to previous menu...");
    }
	
}

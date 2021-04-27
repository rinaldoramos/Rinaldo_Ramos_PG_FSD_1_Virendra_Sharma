package program.java.project1;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	
	private static Scanner input; // scanner variable to receive input from the user using the keyboard.
    private static File filePath; // File variable to handle the location where the file will be created or exist.
    private static String fileName; // variable to hold the name of a file given by the user.
    private static int choice; // option selected by the user from the menus.
    private static boolean condition = true;

	public static void main(String[] args) {
			
	System.out.println("\n\n\n");
	System.out.println("==============================================================");
        System.out.println("==============================================================");
        System.out.println("===================  WELCOME TO   ============================");
        System.out.println("=================== LockedMe.Com  ============================");
        System.out.println("===================      By       ============================");
        System.out.println("=================== Rinaldo Ramos ============================");
        System.out.println("==============================================================");
        System.out.println("==============================================================\n\n");

        firstMenu();
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
    
    private static TreeSet<String> returnList() {

        // set the location of the directory
        filePath = new File("C:\\Users\\Rinal\\Desktop\\Web Development\\Files");

        // checking the path is a directory
        if (filePath.isDirectory()) {
            TreeSet<String> files = new TreeSet<>();
            File[] listOfFiles = filePath.listFiles(); // getting all the files on that directory
            for (int i = 0; i < listOfFiles.length; i++) {
                files.add(listOfFiles[i].getName());
            }
            return files;
        } else {
            System.out.println("This is not a valid directory.");
            return null;
        }
}
    
    private static void firstMenu(){

        // calling the displayMenu method
        firstMenuDisplay();
        condition = true;

        // initializing the scanner variable
        input = new Scanner(System.in);

        while(condition){

            // checking option from the user
            condition = input.hasNextInt();

            if (condition){ // If true, then user enter a number.

                // retrieving number entered by user
                choice = Integer.parseInt(input.nextLine());

                if ((choice > 0) && (choice <= 3)) {

                    switch (choice) {
                        case 1:
                            System.out.println("Please wait...retrieving list of files.");
                            // calling returnList method
                            TreeSet<String>  set = returnList();
                            for (int i = 0; i < 3; i++) {
                                try {
                                    Thread.sleep(2000);
                                    System.out.println("...");
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println("\n\n");
                            if (set.size() == 0) {
                                System.out.println("The list is empty. Something went wrong. Please try again.\n\n\n");
                            } else {
                                // creating an iterator to traverse the TreeSet
                                Iterator<String> iterator = set.iterator();
                                int counter = 1; // a counter to organize the number of files

                                System.out.println("=======================");
                                while (iterator.hasNext()) {
                                    System.out.println(counter + " - " + iterator.next());
                                    counter++;
                                }
                                System.out.println("=======================\n\n\n");
                            }
                            firstMenuDisplay();
                            condition = true;
                            break;
                        case 2:
                            System.out.println("Accessing the Add....Delete...search...Menu option....\n\n\n");
                            secondaryMenu(); // accessing the second menu of options.
                            firstMenuDisplay();
                            condition = true;
                            break;
                        case 3:
                            System.out.println("Thank you for using our services.\nHave a great rest of the day " +
                                    "and hope to see you soon!!!");
                            System.out.println("========================================================\n\n\n");
                            System.exit(0);
                            condition = false;
                            break;
                    }
                } else {
                    System.out.println("Invalid number. Please enter a number from 1-3....\n\n\n");
                    firstMenuDisplay();
                    condition = true;
                }
            }else { // If false, then user enter a non-integer value
                System.out.println("Invalid input. It must be a number. Please check again the menu option...\n\n\n");
                firstMenuDisplay();
                condition = true;
                //setting scanner to null and reopen the scanner
                input = null;
                input = new Scanner(System.in);
            }
        }
    }
    
    private static void secondaryMenu() {

        // calling the secondMenu method
        secondMenuDisplay();

        // set the location of the directory
        filePath = new File("C:\\Users\\Rinal\\Desktop\\Web Development\\Files");
        int counter = 0;
        condition = true;
        boolean found;

        while(condition){

            // checking option from the user
            condition = input.hasNextInt();

            if (condition){ // If true, then user enter a number.

                // retrieving number entered by user
                choice = Integer.parseInt(input.nextLine());

                if ((choice > 0) && (choice <= 4)) {

                    switch (choice) {
                        case 1: // adding a file to the directory
                            System.out.println("Please give us the name of the file you want to add \n" +
                                    "to the current directory: ");
                            // asking name of the new file
                            fileName = input.nextLine();

                            try {
                                // set the location of the directory
                                filePath = new File("C:\\Users\\Rinal\\Desktop\\Web Development\\Files\\" + fileName);

                                // Checking if file exist
                                if (filePath.createNewFile()) {
                                    System.out.println("The file " + fileName + " was created successfully!");
                                } else {
                                    System.out.println("Error, there is a file with that name. Please choose a different name.");
                                }
                            } catch (IOException exception) {
                                exception.printStackTrace();
                            }
                            condition = true;
                            secondMenuDisplay();
                            break;
                        case 2: // deleting a file from the directory
                            System.out.println("Please enter the name of the file you want to delete: ");
                            fileName = input.nextLine();
                            found = false;	
                            
                            // set the location of the directory
                            filePath = new File("C:\\Users\\Rinal\\Desktop\\Web Development\\Files");
                            
                            // checking each file to see if a match is found case-sensitive
                            for(File currentFile : filePath.listFiles()){
                            	if (currentFile.getName().equals(fileName)) {                            		                                     
                                     found = true;
                                     break;
								}
                            }
                            
                            // checking if file exist or not
                            if (found) {                            	
                                filePath = new File("C:\\Users\\Rinal\\Desktop\\Web Development\\Files\\" + fileName);
                                filePath.delete();
                                System.out.println("The file " + fileName + " has been deleted!!");
                            } else {
                                System.out.println("The deletion was not completed. File Not Found!");
                            }
                            
                            secondMenuDisplay();
                            condition = true;
                            break;
                        case 3: // searching for a given file
                            System.out.println("Please enter the file name you are looking for: ");
                            fileName = input.nextLine();
                            found = false;	
                            
                            // set the location of the directory
                            filePath = new File("C:\\Users\\Rinal\\Desktop\\Web Development\\Files");
                            
                            // checking each file to see if a match is found case-sensitive
                            for(File currentFile : filePath.listFiles()){
                            	if (currentFile.getName().equals(fileName)) {                            		                                     
                                     found = true;
                                     break;
								}
                            }
                            
                            // checking if file exist or not
                            if (found) {                            	
                            	System.out.println("The file " + fileName + " was found!!");
                            } else {
                            	System.out.println("The file " + fileName + " was not found! Please try again!");
                            }
                            secondMenuDisplay();
                            condition = true;
                            break;
                        case 4: // returning to previous menu
                            System.out.println("Returning to previous menu...\n\n\n");
                            condition = false;
                            break;
                    }
                } else {
                    System.out.println("Invalid number. Please enter a number from 1-3....\n\n\n");
                    secondMenuDisplay();
                    condition = true;
                }
            }else { // If false, then user enter a non-integer value
                System.out.println("Invalid input. It must be a number. Please check again the menu option...\n\n\n");
                secondMenuDisplay();
                condition = true;
                //setting scanner to null and reopen the scanner
                input = null;
                input = new Scanner(System.in);
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
}

package Java;
import java.util.Scanner;

public class Library {
    static int MAX_BOOKS = 100; // Maximum amount of unique books the library can hold.
    static String[] booksTitle = new String[MAX_BOOKS]; // Array for the book title.
    static String[] booksAuthor = new String[MAX_BOOKS]; // Array for the book author.
    static int[] booksAmount = new int[MAX_BOOKS]; // Array for the book quantity.

    static int librarySize = 0; // Current number of books in the library.

    static Scanner userInput = new Scanner(System.in); // Creates the Scanner Object.

    public static void main(String[] args) {
        int choice;

        // Basic UI for the library.
        do {
            System.out.print("\n--- Welcome to the Library ---");
            System.out.print("\n1. Add Books");
            System.out.print("\n2. Borrow Books");
            System.out.print("\n3. Return Books");
            System.out.print("\n4. View Available Books");
            System.out.print("\n5. Exit \n");

            // Input validation loop to make sure the number is between 1-5.
            while (!userInput.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number 1-5.");
                userInput.next(); // Consumes invalid inputs.
            }

            choice = userInput.nextInt();
            userInput.nextLine(); // Consumes new line characters.

            // Switch to handle the user's menu choice.
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again."); // Error handling message for incorect choices.
            }
        } while (choice != 5); // Loops the program until the user chooses to exit.
    }

    // Allows the user to add new books to the library.
    public static void addBook() {
        System.out.print("Enter the book title: ");
        String title = userInput.nextLine().trim().toLowerCase();

        System.out.print("Enter the book author: ");
        String author = userInput.nextLine().trim().toLowerCase();

        System.out.print("Enter quantity: ");
        int quantity = getPositiveInt();

        // Checks if book already exists in library. If found it updates its quantity to the library.
        for (int i = 0; i < librarySize; i++) {
            if (title.equals(booksTitle[i])) {
                booksAmount[i] += quantity;
                System.out.print("Book already exists... Updating quantity.");
            }
        }

        // If book doesn't exist and the library has space, it adds it.
        if (librarySize < MAX_BOOKS) {
            booksTitle[librarySize] = title;
            booksAuthor[librarySize] = author;
            booksAmount[librarySize] = quantity;
            librarySize++;
            System.out.print("Book added successfully.");
        } else {
            System.out.print("Error: Library full. Can't add more books."); // Error handling if library can't take more books.
        }
    }

    // Allows the user to borrow books from the library.
    public static void borrowBook() {
        // Checks if the book exists in the library by comparing the titles. If found it updates its quantity.
        System.out.print("Enter the title of the book you want to borrow: ");
        String title = userInput.nextLine().trim().toLowerCase();

        boolean found = false;
        for (int i = 0; i < librarySize; i++) {
            if (title.equals(booksTitle[i])) {
                found = true;
                System.out.print("Enter the amount you want to borrow: ");
                int quantity = getPositiveInt();
                if (booksAmount[i] < quantity) {
                    System.out.println("Error: Not enough books of this title. Only " + booksAmount[i] + " books left.");
                } else {
                    booksAmount[i] -= quantity;
                    System.out.println("Successfully borrowed " + quantity + " copies of " + title + ".");
                }
                break;
            }
        }
        // If book is not found, it displays an error message.
        if (!found) {
            System.out.print("Error: This book doesn't exist in the library.");
        }
    }

    // Allows user to return a book to the library.
    public static void returnBook() {
        System.out.print("Enter the title of the book you want to return: ");
        String title = userInput.nextLine().trim().toLowerCase();

        for (int i = 0; i < librarySize; i++) {
            if (title.equals(booksTitle[i])) {
                System.out.print("Enter the amount you want to return: ");
                int quantity = getPositiveInt();
                booksAmount[i] += quantity;
                System.out.println("Successfully returned " + quantity + " of " + title + ".");
            } else {
                System.out.print("Error: This book doesn't belong to this library.");
            }
        }
    }

    // Displays all the books available in the library.
    public static void listBooks() {
        if (librarySize == 0) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("\n--- Available Books ---");
        for (int i = 0; i < librarySize; i++) {
            System.out.println("Title: " + booksTitle[i] + " | Author: " + booksAuthor[i] + " | Quantity: " + booksAmount[i]);
        }
    }

    // Prompts the user to enter a positive number to prevent any errors.
    public static int getPositiveInt() {
        int number;
        while (true) {
            if (userInput.hasNextInt()) {
                number = userInput.nextInt();
                userInput.nextLine(); // Consumes newline
                if (number > 0) {
                    return number;
                } else {
                    System.out.print("Please enter a positive number: ");
                }
            } else {
                System.out.print("Invalid input. Enter a number: ");
                userInput.next();
            }
        }
    }
}
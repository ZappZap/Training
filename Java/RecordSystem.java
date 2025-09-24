package Java;

import java.util.Scanner; // Import of the Scanner Method.

public class RecordSystem {
    private static int MAX_STUDENTS = 100; // Max amount of students the system can accept.
    private static Student[] students = new Student[MAX_STUDENTS];
    private static int totalStudents = 0;

    public static Scanner userInput = new Scanner(System.in); // Creates the Scanner Object.
    
    public static void main(String[] args) {
        int choice;

        // Creates a UI for the menu.
        do {
            System.out.println("\n--- Administrator Menu ---");
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Error Handling for numbers not in the menu.
            while (!userInput.hasNextInt()) {
                System.out.println("Error: Invalid input. Please enter a number (1-4).");
                userInput.next();
            }

            choice = userInput.nextInt();
            userInput.nextLine();

            switch (choice) {
                case 1: addStudent(userInput); break;
                case 2: updateStudent(userInput); break;
                case 3: viewStudent(userInput); break;
                case 4: System.out.println("Exiting... Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        userInput.close();
    }

    public static void addStudent(Scanner userInput) {
        // Error Handler for when the system is full.
        if (totalStudents >= MAX_STUDENTS) {
            System.out.print("Error: Storage full. Cannot add more students.");
            return;
        }

        // Inputs the student ID.
        System.out.print("Enter Student ID: ");
        int id = userInput.nextInt();
        userInput.nextLine();

        if (searchStudentByID(id) != -1) {
            System.out.print("Error: Student already exists.");
            return;
        }

        // Inputs the student name.
        System.out.print("Enter Student Name: ");
        String name = userInput.nextLine();

        // Inputs the student age.
        System.out.print("Enter Student Age: ");
        int age = userInput.nextInt();
        userInput.nextLine();

        // Inputs the student grade.
        System.out.print("Enter Student Grade: ");
        String grade = userInput.nextLine();

        // Adds all of the student info.
        students[totalStudents++] = new Student(id, name, age, grade);
        System.out.println("Student added successfully!");
    }

    public static void updateStudent(Scanner userInput) {
        // Input student ID.
        System.out.print("Enter Student ID to update: ");
        int id = userInput.nextInt();
        userInput.nextLine();

        // Error handling for when student is not found.
        int index = searchStudentByID(id);
        if (index == -1) {
            System.out.println("Error: Student ID not found.");
            return;
        }

        // Finds and updates the desired student.
        Student student = students[index];
        System.out.println("Updating details for: " + student.getName());

        // Updates the student name.
        System.out.print("Enter new Name (leave blank to keep current): ");
        String newName = userInput.nextLine();
        if (!newName.trim().isEmpty()) {
            student.setName(newName);
        }

        // Update the student age.
        System.out.print("Enter new Age (enter -1 to keep current): ");
        int newAge = userInput.nextInt();
        userInput.nextLine();
        if (newAge != -1) {
            student.setAge(newAge);
        }

        // Update the student grade.
        System.out.print("Enter new Grade (leave blank to keep current): ");
        String newGrade = userInput.nextLine();
        if (!newGrade.trim().isEmpty()) {
            student.setGrade(newGrade);
        }

        System.out.println("Student information updated successfully!");
    }

    public static void viewStudent(Scanner sc) {
        System.out.print("Enter Student ID to view: ");
        int id = sc.nextInt();
        sc.nextLine();

        int index = searchStudentByID(id);
        if (index == -1) {
            System.out.println("Error: Student ID not found.");
            return;
        }

        students[index].displayInfo();
    }

    // Helper method for cleaning the code a little bit.
    private static int searchStudentByID(int id) {
        for (int i = 0; i < totalStudents; i++) {
            if (students[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
}

// Created the Student Class.
class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    // Constructor for the class Student.
    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }


    // Display student details
    public void displayInfo() {
        System.out.println("\nStudent Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }
}

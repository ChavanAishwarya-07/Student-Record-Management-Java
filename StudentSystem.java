// Import necessary classes
import java.util.ArrayList;
import java.util.Scanner;

// Define a Student class to store student details
class Student {
    int rollNo;
    String name;
    float marks;

    // Constructor to initialize student data
    Student(int rollNo, String name, float marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    // Method to display student details
    void display() {
        System.out.println("\nRoll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
}

// Main class for the Student Record Management System
public class StudentSystem {
    // A dynamic list to store student records
    static ArrayList<Student> studentList = new ArrayList<>();
    // Scanner object for user input
    static Scanner sc = new Scanner(System.in);

    // Method to add a new student
    public static void addStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        float marks = sc.nextFloat();
        
        // Add the new student to the list
        studentList.add(new Student(roll, name, marks));
        System.out.println("Student added successfully!");
    }

    // Method to display all students
    public static void displayStudents() {
        System.out.println("\n=== Student Records ===");
        for (Student s : studentList) {
            s.display(); // Call display method for each student
        }
    }

    // Method to search a student by roll number
    public static void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int roll = sc.nextInt();
        boolean found = false;

        // Search through the list
        for (Student s : studentList) {
            if (s.rollNo == roll) {
                s.display(); // Display if found
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Method to delete a student by roll number
    public static void deleteStudent() {
        System.out.print("Enter Roll No to delete: ");
        int roll = sc.nextInt();

        // Remove the student if roll number matches
        boolean removed = studentList.removeIf(s -> s.rollNo == roll);

        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Main method - entry point of the program
    public static void main(String[] args) {
        int choice;

        // Menu-driven program using a do-while loop
        do {
            // Display menu options
            System.out.println("\n----- Student Record Management -----");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            // Perform action based on user's choice
            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: searchStudent(); break;
                case 4: deleteStudent(); break;
                case 5: System.out.println("Exiting program..."); break;
                default: System.out.println("Invalid choice!"); break;
            }
        } while (choice != 5); // Loop until user chooses to exit
    }
}

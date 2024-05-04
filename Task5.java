package intern;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Task5 implements Serializable
{

    private String name;
    private int rollNumber;
    private String grade;

    public Task5(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Task5> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Task5 student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        System.out.println("Student removed successfully.");
    }

    public Task5 searchStudent(int rollNumber) {
        for (Task5 student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Task5 student : students) {
            System.out.println(student);
        }
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(students);
            System.out.println("Student data saved to file.");
        } catch (IOException e) {
            System.err.println("Error saving student data to file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            students = (ArrayList<Task5>) ois.readObject();
            System.out.println("Student data loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading student data from file: " + e.getMessage());
        }
    }
}

class StudentManagementApp {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent(system, scanner);
                    break;
                case 2:
                    removeStudent(system, scanner);
                    break;
                case 3:
                    searchStudent(system, scanner);
                    break;
                case 4:
                    displayAllStudents(system);
                    break;
                case 5:
                    system.saveToFile();
                    break;
                case 6:
                    system.loadFromFile();
                    break;
                case 7:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 7);

        scanner.close();
    }

    private static void addStudent(StudentManagementSystem system, Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        Task5 student = new Task5(name, rollNumber, grade);
        system.addStudent(student);
    }

    private static void removeStudent(StudentManagementSystem system, Scanner scanner) {
        System.out.print("Enter the roll number of the student to be removed: ");
        int rollNumber = scanner.nextInt();
        system.removeStudent(rollNumber);
    }

    private static void searchStudent(StudentManagementSystem system, Scanner scanner) {
        System.out.print("Enter the roll number of the student to be searched: ");
        int rollNumber = scanner.nextInt();
        Task5 student = system.searchStudent(rollNumber);

        if (student != null) {
            System.out.println("Student found:\n" + student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayAllStudents(StudentManagementSystem system) {
        System.out.println("All Students:");
        system.displayAllStudents();
    }
}



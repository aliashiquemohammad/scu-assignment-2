
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class Menu
{
    public static void main(String[] args) {
        StudentMarks studentMarks = new StudentMarks();
        Scanner scanner = new Scanner(System.in); 
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("What you wanna do? Press number for each item to process:");
            System.out.println("1. Read File");
            System.out.println("2. Calculate and Print Total Marks");
            System.out.println("3. Show Students Below Threshold");
            System.out.println("4. Show Top and Bottom Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    students = studentMarks.readFileDataFromUser();
                    break;
                case 2:
                    studentMarks.showAllStudentDetails( students );
                    break;
                case 3:
                    //Scanner inputThreshold = new Scanner( System.in );
                    System.out.println("Enter the Threshold Marks to list:");
                    int userInputThreshold = scanner.nextInt();
                    studentMarks.showStudentsBelowThreshold(students, userInputThreshold);
                    break;
                case 4:
                    studentMarks.studentTopFiveTopAndButtom(students);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

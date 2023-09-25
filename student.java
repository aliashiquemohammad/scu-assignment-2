
/**
 * The student class for student information from the file.
 *
 * @author (Mohammad Ashique Ali)
 * @version (25/09/2023)
 * @github (https://github.com/aliashiquemohammad/scu-assignment-2) 
 */
public class Student
{
    private String studentFirstName;
    private String studentLastName;
    private String studentId;
    private String studentFullName;
    private double studentAssignment1Marks;
    private double studentAssignment2Marks;
    private double studentAssignment3Marks;
    private double studentTotalMarks;

    public Student(String firstName, String lastName, String studentId, double assignment1, double assignment2, double assignment3) {
        this.studentFirstName = firstName;
        this.studentLastName = lastName;
        this.studentFullName = firstName + ' ' + lastName; 
        this.studentId = studentId;
        this.studentAssignment1Marks = assignment1;
        this.studentAssignment2Marks = assignment2;
        this.studentAssignment3Marks = assignment3;
        this.studentTotalMarks = assignment1 + assignment2 + assignment3;
    }

    public void printStudentDetails() {
        System.out.println("Name: " + studentFullName);
        System.out.println("Student ID: " + studentId);
        System.out.println("Assignment 1: " + studentAssignment1Marks);
        System.out.println("Assignment 2: " + studentAssignment2Marks);
        System.out.println("Assignment 3: " + studentAssignment3Marks);
        System.out.println("Total Marks: " + studentTotalMarks);
    }
}

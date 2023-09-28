
/**
 * The student class for student information from the file.
 *
 * @author (Mohammad Ashique Ali)
 * @version (29/09/2023)
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
    
    /**
     * Show the student details
     */
    public void showStudentDetails() {
        System.out.println("Name: " + studentFullName);
        System.out.println("Student ID: " + studentId);
        System.out.println("Assignment 1: " + studentAssignment1Marks);
        System.out.println("Assignment 2: " + studentAssignment2Marks);
        System.out.println("Assignment 3: " + studentAssignment3Marks);
        System.out.println("Total Marks: " + studentTotalMarks);
    }
    
    /**
     * Set the first name of the student
     */
    public void setStudentFristName( String firstName ){
        studentFirstName = firstName;
    }
    
    /**
     * Set the first name of the student
     */
    public void setStudentLastName( String lastName ){
        studentLastName = lastName;
    }
    
    /**
     * Set the ID of the student
     */
    public void setStudentStudentID( String studentID){
        studentId = studentID;
    }
    
    /**
     * Set the Assignment 1 marks of the student
     */
    public void setStudentAssignment1Marks( double studentAssignment1Number ){
        studentAssignment1Marks = studentAssignment1Number;
    }
    
    /**
     * Set the Assignment 2 marks of the student
     */
    public void setStudentAssignment2Marks( double studentAssignment2Number ){
        studentAssignment2Marks = studentAssignment2Number;
    }
    
    /**
     * Set the Assignment 3 marks of the student
     */
    public void setStudentAssignment3Marks( double studentAssignment3Number ){
        studentAssignment3Marks = studentAssignment3Number;
    }
    
    
    /**
     * Get the name of the student
     */
    public String getStudentName(){
        return studentFullName;
    }
    
    /**
     * Get the ID of the student
     */
    public String getStudentStudentID(){
        return studentId;
    }
    
    /**
     * Get the Assignment 1 marks of the student
     */
    public double getStudentAssignment1Marks(){
        return studentAssignment1Marks;
    }
    
    /**
     * Get the Assignment 2 marks of the student
     */
    public double getStudentAssignment2Marks(){
        return studentAssignment2Marks;
    }
    
    /**
     * Get the Assignment 3 marks of the student
     */
    public double getStudentAssignment3Marks(){
        return studentAssignment3Marks;
    }
    
     /**
     * Get the total marks of student
     */
    public double getStudentTotalMarks(){
        return studentTotalMarks;
    }
}

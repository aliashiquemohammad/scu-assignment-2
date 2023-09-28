
/**
 * Write a description of class studentMarks here.
 *
 * @author (Mohammad Ashique Ali)
 * @version (29/09/2023)
 * @github (https://github.com/aliashiquemohammad/scu-assignment-2) 
 */
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class StudentMarks
{
    // instance variables - replace the example below with your own
    //private int x;

    /**
     * Constructor for objects of class studentMarks
     */
    public StudentMarks()
    {
        
    }

    public static void main( String[] args ){
        Scanner fileNameInput = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String fileName = fileNameInput.nextLine(); 
        try{
            //File studentMarksFile = new File( "prog5001_students_grade_2022.csv" );
            File studentMarksFile = new File(fileName + ".csv");
        
            //checking if CSV file exits
            if ( studentMarksFile.exists() ){
                fileNameInput.close();
                List<Student> students = new ArrayList<>();
                int counter = 0;
                Scanner marksFile = new Scanner( studentMarksFile );
                while( marksFile.hasNextLine() ){
                    String filePerLine = marksFile.nextLine();
                    //System.out.println( filePerLine );
                    
                    //ignoring the comment which starts with # or //
                    if ( filePerLine.startsWith("#") || filePerLine.startsWith("//") ) {
                        continue;
                    }
                    
                    //for first line of data 
                    if( counter == 0 ){ 
                        //split the file line data of first one with the ":"
                        String[] firstLineSplit = filePerLine.split(":");
                        //System.out.println( firstLineSplit);
                        //String unitName = firstLineSplit[1].trim();
                    }else if( counter > 1 ){
                        //split the file line data with the ","
                        String[] studentDetailsSplit = filePerLine.split(",", -1 );
                        if ( studentDetailsSplit.length >= 4 ) {
                            String lastName = studentDetailsSplit[0].trim();
                            String firstName = studentDetailsSplit[1].trim();
                            String studentId = studentDetailsSplit[2].trim();
                            double assignment1;
                            double assignment2;
                            double assignment3;
                            
                            if( studentDetailsSplit[3].trim().isEmpty() ){
                                assignment1 = 0;
                            }else{
                                assignment1 = Double.parseDouble(studentDetailsSplit[3].trim());
                            }
                           
                            if( studentDetailsSplit[4].trim().isEmpty() ){
                                assignment2 = 0;
                            }else{
                                assignment2 = Double.parseDouble(studentDetailsSplit[4].trim());
                            }
                            if( studentDetailsSplit[5].trim().isEmpty() ){
                                assignment3 = 0;
                            }else{
                                assignment3 = Double.parseDouble(studentDetailsSplit[5].trim());
                            }
                            
                            Student student = new Student(firstName, lastName, studentId, assignment1, assignment2, assignment3);
                            students.add(student);
                            
                        }
                    }
                    counter++;
                    
                }
                for (Student student : students) {
        
                    student.showStudentDetails();
        
                }
                
                //if( students.isEmpty() ){
                    marksFile.close();
                    Scanner inputThreshold = new Scanner( System.in );
                    System.out.println("Enter the Threshold Marks to list:");
                    int userInputThreshold = inputThreshold.nextInt();
                    for (Student student : students) {
                        if (student.getStudentTotalMarks() < userInputThreshold ) {
                            student.showStudentDetails();
                        }
                    }
                    
                    
                //}
                
                //for ( int i =0; i <= students.size(); i++ ){
                    //students.get(i).printStudentDetails();
                //}
                //System.out.println(students.toString() );
            }
            else{
                System.out.println( "There is no any file as you have entered in the project folder" );
            }
        }
        catch( FileNotFoundException e){
            System.out.println( "There is some error." );
            e.printStackTrace();
        }
        
    }
}


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
import java.util.Comparator;
public class StudentMarks
{
    

    public static List<Student> readFileDataFromUser() {
        List<Student> students = new ArrayList<>();
        Scanner fileNameInput = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String fileName = fileNameInput.nextLine(); 
        try{
            //File studentMarksFile = new File( "prog5001_students_grade_2022.csv" );
            File studentMarksFile = new File(fileName + ".csv");
    
            //checking if CSV file exits
            if ( studentMarksFile.exists() ){
                fileNameInput.close();
                
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
                            int studentId = Integer.parseInt(studentDetailsSplit[2].trim() );
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
                
                    
            }else{
                System.out.println( "There is no any file as you have entered in the project folder" );
            }
        }catch( FileNotFoundException e){
            System.out.println( "There is some error while processing your file." );
            e.printStackTrace();
        }
        return students;
    }
    
    public void studentTopFiveTopAndButtom(List<Student> students){
        int n = students.size();
        boolean swapped;
        swapped = false;
        /**
         * Sorting with bubble sort with descending order
         */
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getStudentTotalMarks() < students.get(j+1).getStudentTotalMarks() ) {
                    // Swap list[j] and list[j+1]
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                    swapped = true;
                }
            }
            
        }
        
        if( !swapped ){
            System.out.println( "There was error on processing your request" );
        }else{
            System.out.println("Top 5 Students:");
            for (int i = 0; i < 5 && i < students.size(); i++) {
                students.get(i).showStudentDetails();
            }
        
            System.out.println("Bottom 5 Students:");
            //int n = students.size();
            for (int i = n - 1; i >= n - 5 && i >= 0; i--) {
                students.get(i).showStudentDetails();
            }
        }
    }
    
    public void showStudentsBelowThreshold( List<Student> students, int userInputThreshold ){
        
        
        for (Student student : students) {
            if (student.getStudentTotalMarks() < userInputThreshold ) {
                student.showStudentDetails();
            }
        }
    }

    public void showAllStudentDetails( List<Student> students ){
        for (Student student : students) {
    
                student.showStudentDetails();
    
            }
    }
}

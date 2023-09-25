
/**
 * Write a description of class studentMarks here.
 *
 * @author (Mohammad Ashique Ali)
 * @version (25/09/2023)
 * @github (https://github.com/aliashiquemohammad/scu-assignment-2) 
 */
import java.io.*;
import java.util.Scanner;
public class studentMarks
{
    // instance variables - replace the example below with your own
    //private int x;

    /**
     * Constructor for objects of class studentMarks
     */
    public studentMarks()
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
                int counter = 0;
                Scanner scanner = new Scanner( studentMarksFile );
                while( scanner.hasNextLine() ){
                    String filePerLine = scanner.nextLine();
                    System.out.println( filePerLine );
                    
                    //ignoring the comment which starts with # or //
                    if ( filePerLine.startsWith("#") || filePerLine.startsWith("//") ) {
                        continue;
                    }
                    
                    //for first line of data 
                    if( counter == 0 ){ 
                        //split the file line data of first one with the ":"
                        String[] firstLineSplit = filePerLine.split(":");
                        String unitName = firstLineSplit[1].trim();
                    }else if( counter > 1 ){
                        //split the file line data with the ","
                        String[] studentDetailsSplit = filePerLine.split(",");
                        if ( studentDetailsSplit.length >= 4 ) {
                            String LastName = studentDetailsSplit[0].trim();
                            String firstName = studentDetailsSplit[1].trim();
                            String studentId = studentDetailsSplit[2].trim();
                            int assignment1 = Integer.parseInt(studentDetailsSplit[3].trim());
                            int assignment2 = Integer.parseInt(studentDetailsSplit[4].trim());
                            int assignment3 = Integer.parseInt(studentDetailsSplit[5].trim());
        
                            
                        }
                    }
                    
                    
                }
                scanner.close();
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

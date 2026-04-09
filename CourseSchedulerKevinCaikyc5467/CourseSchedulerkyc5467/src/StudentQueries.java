import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kevin Cai
 */
public class StudentQueries {
    private static Connection connection;
    private static PreparedStatement addStudent;
    private static PreparedStatement getAllStudents;
    private static PreparedStatement getStudent;
    private static PreparedStatement dropStudent;
    private static ResultSet resultSet;
    
    public static void addStudent(StudentEntry student){
        connection = DBConnection.getConnection();
        try {
            addStudent = connection.prepareStatement("insert into app.StudentEntry (studentid, firstname, lastname) values(?,?,?)");
            addStudent.setString(1,student.getStudentID());
            addStudent.setString(2,student.getFirstName());
            addStudent.setString(3,student.getLastName());
            addStudent.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<StudentEntry> getAllStudents(){
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> students = new ArrayList<>();
        try {
            getAllStudents = connection.prepareStatement("select * from app.StudentEntry order by firstname, lastname, studentid");
            resultSet = getAllStudents.executeQuery();
            
            while(resultSet.next()){
                StudentEntry student = new StudentEntry(resultSet.getString("studentid"), resultSet.getString("firstname"), resultSet.getString("lastname"));
                students.add(student);
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
        return students;
    }
    
    public static StudentEntry getStudent(String studentID) {
        connection = DBConnection.getConnection();
        String firstName = "";
        String lastName = "";
        
        try {
            getStudent = connection.prepareStatement("select * from app.studentEntry where studentID = (?)");
            getStudent.setString(1, studentID);
            resultSet = getStudent.executeQuery();
            resultSet.next();
            firstName = resultSet.getString("firstname");
            lastName = resultSet.getString("lastname");
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
    
    public static void dropStudent(String studentID) {
        connection = DBConnection.getConnection();
        
        try {
            dropStudent = connection.prepareStatement("delete from app.studentEntry where studentID = (?)");
            dropStudent.setString(1, studentID);
            dropStudent.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kevin Cai
 */
public class ScheduleQueries {
    private static Connection connection;
    private static PreparedStatement addScheduleEntry;
    private static PreparedStatement getScheduleByStudent;
    private static PreparedStatement getScheduledStudentCount;
    private static PreparedStatement getWaitlistedStudentsByClass;
    private static PreparedStatement dropStudentScheduleByCourse;
    private static PreparedStatement dropScheduleByCourse;
    private static PreparedStatement updateScheduleEntry;
    private static PreparedStatement returnSpecificScheduleEntry;
    private static ResultSet resultSet;
    
    public static void addScheduleEntry(ScheduleEntry entry){
        connection = DBConnection.getConnection();
        try {
            addScheduleEntry = connection.prepareStatement("insert into app.scheduleEntry (semester, coursecode, studentid, status, timestamp) values(?,?,?,?,?)");
            addScheduleEntry.setString(1,entry.getSemester());
            addScheduleEntry.setString(2,entry.getCourseCode());
            addScheduleEntry.setString(3,entry.getStudentID());
            addScheduleEntry.setString(4,entry.getStatus());
            addScheduleEntry.setTimestamp(5,entry.getTimestamp());
            addScheduleEntry.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<ScheduleEntry> getScheduleByStudent(String semester, String studentID){
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> schedules = new ArrayList<>();
        try {
            getScheduleByStudent = connection.prepareStatement("select * from app.scheduleEntry where semester = (?) and studentID = (?)");
            getScheduleByStudent.setString(1, semester);
            getScheduleByStudent.setString(2, studentID);
            resultSet = getScheduleByStudent.executeQuery();
            
            while(resultSet.next()){
                ScheduleEntry schedule = new ScheduleEntry(resultSet.getString("semester"), resultSet.getString("coursecode"), resultSet.getString("studentid"), resultSet.getString("status"), resultSet.getTimestamp("timestamp"));
                schedules.add(schedule);
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
        return schedules;
    }
    
    public static int getScheduledStudentCount(String currentSemester, String courseCode) {
       connection = DBConnection.getConnection();
       int num = 0;
       try {
            getScheduledStudentCount = connection.prepareStatement("select count(studentID) from app.scheduleEntry where semester = (?) and coursecode = (?)");
            getScheduledStudentCount.setString(1, currentSemester);
            getScheduledStudentCount.setString(2, courseCode);
            resultSet = getScheduledStudentCount.executeQuery();
            resultSet.next();
            num = resultSet.getInt(1);
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
       
       return num;
    }
    
    public static ArrayList<ScheduleEntry> getWaitlistedStudentsByClass(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> schedules = new ArrayList<ScheduleEntry>();
        
        try {
            getWaitlistedStudentsByClass = connection.prepareStatement("select * from app.scheduleEntry where semester = (?) and coursecode = (?) and status = (?) order by timestamp");
            getWaitlistedStudentsByClass.setString(1,semester);
            getWaitlistedStudentsByClass.setString(2,courseCode);
            getWaitlistedStudentsByClass.setString(3,"W");
            resultSet = getWaitlistedStudentsByClass.executeQuery();
            
            while(resultSet.next()){
                ScheduleEntry studentSchedule = new ScheduleEntry(resultSet.getString("semester"), resultSet.getString("coursecode"), resultSet.getString("studentid"), resultSet.getString("status"), resultSet.getTimestamp("timestamp"));
                schedules.add(studentSchedule);
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
        return schedules;
    }
    
    public static void dropStudentScheduleByCourse(String semester, String studentID, String courseCode) {
        connection = DBConnection.getConnection();
        
        try {
            dropStudentScheduleByCourse = connection.prepareStatement("delete from app.scheduleEntry where semester = (?) and studentid = (?) and coursecode = (?)");
            dropStudentScheduleByCourse.setString(1, semester);
            dropStudentScheduleByCourse.setString(2, studentID);
            dropStudentScheduleByCourse.setString(3, courseCode);
            dropStudentScheduleByCourse.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public static void dropScheduleByCourse(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        try {
            dropScheduleByCourse = connection.prepareStatement("delete from app.scheduleEntry where semester = (?) and coursecode = (?)");
            dropScheduleByCourse.setString(1, semester);
            dropScheduleByCourse.setString(2, courseCode);
            dropScheduleByCourse.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public static void updateScheduleEntry(ScheduleEntry entry) {
        connection = DBConnection.getConnection();
        
        try{
            updateScheduleEntry = connection.prepareStatement("update app.scheduleEntry set status = 'S' where semester = (?) and coursecode = (?) and studentid = (?)");
            updateScheduleEntry.setString(1, entry.getSemester());
            updateScheduleEntry.setString(2, entry.getCourseCode());
            updateScheduleEntry.setString(3, entry.getStudentID());
            updateScheduleEntry.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public static ScheduleEntry returnSpecificScheduleEntry(String studentID, String courseCode, String semester){
        connection = DBConnection.getConnection();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ScheduleEntry output = new ScheduleEntry("","","","",timestamp);
        try {
            returnSpecificScheduleEntry = connection.prepareStatement("select * from app.scheduleEntry where studentid = (?) and coursecode = (?) and semester = (?)");
            returnSpecificScheduleEntry.setString(1, studentID);
            returnSpecificScheduleEntry.setString(2, courseCode);
            returnSpecificScheduleEntry.setString(3,semester);
            
            resultSet = returnSpecificScheduleEntry.executeQuery();
            resultSet.next();
            output = new ScheduleEntry(resultSet.getString("semester"), resultSet.getString("coursecode"), resultSet.getString("studentid"), resultSet.getString("status"), resultSet.getTimestamp("timestamp"));
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
        return output;
    
    }
}

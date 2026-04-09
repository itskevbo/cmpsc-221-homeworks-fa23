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
public class MultiTableQueries {
    private static Connection connection;
    private static PreparedStatement getAllClassDescriptions;
    private static PreparedStatement getScheduledStudentsByClass;
    private static PreparedStatement getWaitlistedStudentsByClass;
    private static ResultSet resultSet;
    
    public static ArrayList<ClassDescription> getAllClassDescriptions(String semester) {
        connection = DBConnection.getConnection();
        ArrayList<ClassDescription> desc = new ArrayList<ClassDescription>();
        
        try {
            getAllClassDescriptions = connection.prepareStatement("select app.classEntry.courseCode, description, seats from app.classEntry, app.courseEntry where semester = ? "
                    + "and app.classEntry.courseCode = app.courseEntry.courseCode order by app.classEntry.courseCode");
            getAllClassDescriptions.setString(1, semester);
            resultSet = getAllClassDescriptions.executeQuery();
            
            while(resultSet.next())
            {
                desc.add(new ClassDescription(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
        return desc;
    }
    
    public static ArrayList<ScheduleEntry> getScheduledStudentsByClass(String semester, String courseCode) {
       ArrayList<ScheduleEntry> schedules = new ArrayList<>();
       connection = DBConnection.getConnection();
       
       try {
            getScheduledStudentsByClass = connection.prepareStatement("select * from app.scheduleEntry where semester = (?) and coursecode = (?) and status = (?)");
            getScheduledStudentsByClass.setString(1,semester);
            getScheduledStudentsByClass.setString(2,courseCode);
            getScheduledStudentsByClass.setString(3,"S");
            resultSet = getScheduledStudentsByClass.executeQuery();
            
            while(resultSet.next()){
                ScheduleEntry schedule = new ScheduleEntry(resultSet.getString("semester"), resultSet.getString("coursecode"), resultSet.getString("studentid"), resultSet.getString("status"), resultSet.getTimestamp("timestamp"));
                schedules.add(schedule);
            }
        }
       
       catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
       return schedules;
    }
    
    public static ArrayList<ScheduleEntry> getWaitlistedStudentsByClass(String semester, String courseCode) {
        ArrayList<ScheduleEntry> schedules = new ArrayList<ScheduleEntry>();
        connection = DBConnection.getConnection();
        
        try {
            getWaitlistedStudentsByClass = connection.prepareStatement("select * from app.scheduleEntry where semester = (?) and coursecode = (?) and status = (?) order by timestamp");
            getWaitlistedStudentsByClass.setString(1,semester);
            getWaitlistedStudentsByClass.setString(2,courseCode);
            getWaitlistedStudentsByClass.setString(3,"W");
            resultSet = getWaitlistedStudentsByClass.executeQuery();
            
            while(resultSet.next()){
                ScheduleEntry schedule = new ScheduleEntry(resultSet.getString("semester"), resultSet.getString("coursecode"), resultSet.getString("studentid"), resultSet.getString("status"), resultSet.getTimestamp("timestamp"));
                schedules.add(schedule);
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
       return schedules;
    }
}

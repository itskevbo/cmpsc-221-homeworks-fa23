/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kevin Cai
 */
public class ClassEntry {
    private String Semester;
    private String CourseCode;
    private int Seats;

    public ClassEntry(String Semester, String CourseCode, int Seats) { //Constructor Method
        this.Semester = Semester;
        this.CourseCode = CourseCode;
        this.Seats = Seats;
    }
    
    /*
     * Getter methods
     */

    public String getSemester() {
        return Semester;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public int getSeats() {
        return Seats;
    }
    
    @Override
    public String toString() {
        return CourseCode;
    }
}

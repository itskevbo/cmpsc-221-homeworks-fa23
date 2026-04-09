/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kevin Cai
 */
public class CourseEntry {
    private String CourseCode;
    private String Description;

    public CourseEntry(String CourseCode, String Description) { //Constructor method
        this.CourseCode = CourseCode;
        this.Description = Description;
    }
    
    /*
     * Getter methods
     */

    public String getCourseCode() {
        return CourseCode;
    }

    public String getDescription() {
        return Description;
    }

}



package BusinessLogic;

import database.DBConnector;

public class Course {
    // Fields
    private String courseID;
    private String courseType;
    private String courseName;

    // Constructor
    public Course(String courseID, String courseType, String courseName) {
        this.courseID = courseID;
        this.courseType = courseType;
        this.courseName = courseName;
    }

    // Getters
    public String getCourseID() { return courseID; }
    public String getCourseType() { return courseType; }
    public String getCourseName() { return courseName; }

    // Setters
    public void setCourseID(String courseID) { this.courseID = courseID; }
    public void setCourseType(String courseType) { this.courseType = courseType; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    
    
    // Methods to view and edit course
    public void viewCourse(String courseID) {
    	DBConnector C = new DBConnector();
    	C.viewCourse();
    }

    public void editCourse(String courseID) {
    	DBConnector C = new DBConnector();
        C.EditCourse(this);
    }
}

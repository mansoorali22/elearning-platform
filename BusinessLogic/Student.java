package BusinessLogic;
import application.*;
import database.DBConnector;

public class Student extends User {
    // Fields
    private Integer semesterNo;
    private Double cGPA;

    // Constructor
    public Student(String email, String password) {
    	this.setEmail(email);
    	this.setPassword(password);
    }

    public Student(Integer userID, String fullName, String email, String password, String phoneNo,
                   Integer semesterNo, Double cGPA, String designation) {
        super(userID, fullName, email, password, phoneNo, designation);
        this.semesterNo = semesterNo;
        this.cGPA = cGPA;
    }

    // Getters
    public Integer getSemesterNo() { return semesterNo; }
    public Double getCGPA() { return cGPA; }

    // Setters
    public void setSemesterNo(Integer semesterNo) { this.semesterNo = semesterNo; }
    public void setCGPA(Double cGPA) { this.cGPA = cGPA; }
    
    @Override
    public void signUp() {
    	DBConnector C = new DBConnector();
    	C.saveStudent(this);
    }
    
    @Override
    public void signIn(String email, String password) {
    	DBConnector C = new DBConnector();
    	C.checkStudentLogin(this);
    }
}


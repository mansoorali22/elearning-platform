package application;
import java.util.*;

import BusinessLogic.*;
import database.DBConnector;
//import javafx.collections.ObservableList;

public class Controller {
	private DBConnector C = new DBConnector();
//	String UserName;
//	String Password;
//	String email;
//	String phoneNo;
//	Integer id; 
//	
	public Boolean AdminLogin(String email, String Password) {
		Admin A = new Admin(email, Password);
		return C.checkadminlogin(A);
	}
	public Boolean StudentLogin(String email, String Password) {
		Student S = new Student(email,Password);
		return C.checkStudentLogin(S);
	}
	public Boolean AlumniLogin(String email, String Password) {
		Alumni Al = new Alumni(email,Password);
		return C.checkAlumniLogin(Al);
	}
	public boolean registerStudent(Integer ID, String UserName,String Password, String email, String phoneNo, Integer semester, Double cGPA, String designation) {
		Student S = new Student(ID, UserName, email, Password, phoneNo, semester,cGPA, designation);
		return C.saveStudent(S);
	}
	public boolean registerAlumni(Integer ID, String UserName, String Password, String email, String phoneNo, String yoc, String designation, String status) {
		Alumni Al = new Alumni(ID, UserName, email, Password, phoneNo, yoc, designation, status);
		return C.saveAlumni(Al);
	}
	public ArrayList<Alumni> AlumniDatabase(){
		return C.AlumniDatabase();
	}
	public ArrayList<CourseMaterial> Syllabus(){
		return C.SyllabusDatabase();
	}
	public ArrayList<CourseMaterial> Books(){
		return C.BooksDatabase();
	}
	public ArrayList<CourseMaterial> CourseOutline(){
		return C.CourseOutlineDatabase();
	}
	public ArrayList<CourseMaterial> Assignment(){
		return C.AssignmentDatabase();
	}	
	public ArrayList<CourseMaterial> Notes(){
		return C.NotesDatabase();
	}
	public ArrayList<CourseMaterial> PastPaper(){
		return C.PastPaperDatabase();
	}
	public boolean VerifyALumni(int alumni_number) {
		return C.VerifyAlumni(alumni_number);
	}
	public boolean createCourse(String ID, String type, String name) {
		Course Cr = new Course(ID, type, name);
		return C.NewCourse(Cr);
	}
	public boolean editCourse(String ID, String type, String name) {
		Course Cr = new Course(ID, type, name);
		return C.EditCourse(Cr);
	}
	public ArrayList<Course> viewCourse() {
		return C.viewCourse();
	}
	public boolean changeEmail(String email) {
		return C.saveEmail(email);
	}
	public boolean changeName(String name) {
		return C.saveName(name);
	}
	public boolean changePassword(String Password) {
		return C.savePassword(Password);
	}
	public boolean changePhoneNo(String PhoneNo) {
		return C.savePhoneNo(PhoneNo);
	}
	
}